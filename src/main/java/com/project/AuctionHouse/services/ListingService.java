package com.project.AuctionHouse.services;

import com.project.AuctionHouse.dtos.ListingDTO;
import com.project.AuctionHouse.dtos.UserDTO;
import com.project.AuctionHouse.mappers.ListingMapper;
import com.project.AuctionHouse.mappers.UserMapper;
import com.project.AuctionHouse.models.Listing;
import com.project.AuctionHouse.models.User;
import com.project.AuctionHouse.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {
    private ListingRepository listingRepository;
    private UserService userService;
    @Autowired
    public ListingService(ListingRepository listingRepository, UserService userService){
        this.listingRepository = listingRepository;
        this.userService = userService;
    }

    public ListingDTO createListing(ListingDTO listingDTO) {
        UserDTO userDTO = userService.getUserByUsername(listingDTO.getUsername());
        User user = UserMapper.toEntity(userDTO);
        Listing listing = new Listing(user.getUsername(), listingDTO.getProduct(), listingDTO.getPrice(), listingDTO.getImageURL(), listingDTO.getEndDate(), listingDTO.getHighestBidder());
        Listing savedListing = listingRepository.save(listing);
        return ListingMapper.toDTO(savedListing);
    }

    public ListingDTO getListingById(String id) {
        Optional<Listing> listing = listingRepository.findById(id);
        if (listing.isPresent()) {
            return ListingMapper.toDTO(listing.get());
        } else {
            return null;
        }
    }

    public List<ListingDTO> getAllListings() {
        return ListingMapper.toDTO(listingRepository.findAll());
    }

    public ListingDTO updateListing(String id, ListingDTO listingDTO) {
        if (id.equals(listingDTO.getId())) {
            Listing listing = ListingMapper.toEntity(listingDTO);
            Listing savedListing = listingRepository.save(listing);
            return ListingMapper.toDTO(savedListing);
        } else {
            //TODO log attempt to change id
            return null;
        }
    }

    public void deleteListingById(String id) {
        listingRepository.deleteById(id);
    }

    public boolean existById(String id){
        return listingRepository.existsById(id);
    }

    public List<ListingDTO> getAllCurrentBids(String id){
        long currentTime = System.currentTimeMillis();
        List<Listing> listings = listingRepository.findAllCurrentBids(currentTime, id);

        List<ListingDTO> listingDTOS = ListingMapper.toDTO(listings);
        return listingDTOS;
    }

    public List<ListingDTO> getAllItemsWon(String id){
        long currentTime = System.currentTimeMillis();
        List<Listing> listings = listingRepository.findAllCurrentBids(currentTime, id);

        List<ListingDTO> listingDTOS = ListingMapper.toDTO(listings);
        return listingDTOS;
    }

}


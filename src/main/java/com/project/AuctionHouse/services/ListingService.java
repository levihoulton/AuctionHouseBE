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

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private UserService userService;

    public ListingDTO createListing(ListingDTO listingDTO) {
        UserDTO userDTO = userService.getUserByUsername(listingDTO.getUsername());
        User user = UserMapper.toEntity(userDTO);
        Listing listing = new Listing(user.getUsername(), listingDTO.getProduct(), listingDTO.getPrice(), listingDTO.getImageURL());
        Listing savedListing = listingRepository.save(listing);
        return ListingMapper.toDTO(savedListing);
    }

    public ListingDTO getListingById(String id) {
        Optional<Listing> listing = listingRepository.findById(id);
        if (listing.isPresent()) {
            return ListingMapper.toDTO(listing.get());
        } else {
            //TODO add logging
            return null;
        }
    }

    public List<ListingDTO> getAllListings() {
        return ListingMapper.toDTOList(listingRepository.findAll());
    }

    public ListingDTO updateListing(String id, ListingDTO listingDTO) {
        Listing listing = ListingMapper.toEntity(listingDTO);
        listing.setId(id);
        Listing savedListing = listingRepository.save(listing);
        return ListingMapper.toDTO(savedListing);
    }


    public void deleteListingById(String id) {
        listingRepository.deleteById(id);
    }

    public boolean existById(String id){
        return listingRepository.existsById(id);
    }


}


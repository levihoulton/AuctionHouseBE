package com.project.AuctionHouse.services;

import com.project.AuctionHouse.Mappers.ListingMapper;
import com.project.AuctionHouse.Mappers.UserMapper;
import com.project.AuctionHouse.dtos.ListingDTO;
import com.project.AuctionHouse.dtos.UserDTO;
import com.project.AuctionHouse.models.Listing;
import com.project.AuctionHouse.models.User;
import com.project.AuctionHouse.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if (userDTO == null) {
            //TODO throw an error, add logger for logger.error
        }
        User user = UserMapper.toEntity(userDTO);
        Listing listing = new Listing(user.getUsername(), listingDTO.getProduct(), listingDTO.getPrice(), listingDTO.getImageURL());
        Listing savedListing = listingRepository.save(listing);
        return ListingMapper.toDTO(savedListing);
    }

    public ListingDTO getListingById(String id) {
        Optional<Listing> listing = listingRepository.findById(id);
        if(listing.isPresent()){
            return ListingMapper.toDTO(listing.get());
        }
        return ListingMapper.toDTO(null);
    }

    public List<ListingDTO> getAllListings(){
        List<Listing> listings = listingRepository.findAll();
        List<ListingDTO> listingDTO = new ArrayList<>();
        for (Listing listing : listings){
            listingDTO.add(ListingMapper.toDTO(listing));
        }
        return listingDTO;
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

//    public List<ListingDTO> getListingsForUser(String username) {
//        List<Listing> listings = listingRepository.findByUsername(username);
//        return ListingMapper.toDTOList(listings);
//    }

}


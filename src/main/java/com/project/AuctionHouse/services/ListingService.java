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

import java.util.List;

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
        Listing listing = new Listing(user.getUsername(), listingDTO.getProduct(), listingDTO.getPrice());
        Listing savedListing = listingRepository.save(listing);
        return ListingMapper.toDTO(savedListing);
    }

    public ListingDTO getListingById(String id) {
        Listing listing = listingRepository.findById(id);
        return ListingMapper.toDTO(listing);
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


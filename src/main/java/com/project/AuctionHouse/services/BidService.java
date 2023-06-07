package com.project.AuctionHouse.services;

import com.project.AuctionHouse.dtos.BidDTO;
import com.project.AuctionHouse.dtos.ListingDTO;
import com.project.AuctionHouse.dtos.UserDTO;
import com.project.AuctionHouse.mappers.BidMapper;
import com.project.AuctionHouse.mappers.ListingMapper;
import com.project.AuctionHouse.mappers.UserMapper;
import com.project.AuctionHouse.models.Bid;
import com.project.AuctionHouse.models.Listing;
import com.project.AuctionHouse.models.User;
import com.project.AuctionHouse.repository.BidRepository;
import com.project.AuctionHouse.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {

    private BidRepository bidRepository;
    private UserService userService;
    private ListingService listingService;
    @Autowired
    public BidService(BidRepository bidRepository, UserService userService, ListingService listingService){
        this.listingService = listingService;
        this.bidRepository = bidRepository;
        this.userService = userService;
    }

    public BidDTO createBid(BidDTO bidDTO){
        Bid bid = new Bid(bidDTO.getUsername(), bidDTO.getListingId(), bidDTO.getPrice());
        Bid savedBid = bidRepository.save(bid);
        return BidMapper.toDTO(savedBid);
    }


}

package com.project.AuctionHouse.controllers;

import com.project.AuctionHouse.dtos.BidDTO;
import com.project.AuctionHouse.dtos.ListingDTO;
import com.project.AuctionHouse.services.BidService;
import com.project.AuctionHouse.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bid")
public class BidController {

    private BidService bidService;
    private ListingService listingService;

    @Autowired
    public BidController(BidService bidService, ListingService listingService){
        this.bidService = bidService;
        this.listingService = listingService;
    }

    @PostMapping("/")
    public ResponseEntity<?> makeBid(@RequestBody BidDTO bidDTO) {
        try {
            if (listingService.existById(bidDTO.getListingId())) {
                //TODO add check listing isActive? otherwise dont bid

                //TODO add check isBid Higher then current
                ListingDTO listingDTO = listingService.getListingById(bidDTO.getListingId());
                listingDTO.setHighestBidder(bidDTO.getUsername());
                listingDTO.setPrice(bidDTO.getPrice());
                listingService.updateListing(listingDTO);

                bidService.createBid(bidDTO);

                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllBids(){
        try {
            List<BidDTO> bidDTO = bidService.getAllBids();
            return new ResponseEntity<>(bidDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    //TODO implement get id bids
    //TODO implement get all bids for listing
    //TODO implement get id bids for listing

}

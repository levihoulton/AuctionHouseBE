package com.project.AuctionHouse.controllers;

import com.project.AuctionHouse.dtos.ListingDTO;
import com.project.AuctionHouse.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @PostMapping("/")
    public ResponseEntity<ListingDTO> createListing(@RequestBody ListingDTO listingDTO) {
        ListingDTO createdListing = listingService.createListing(listingDTO);
        return new ResponseEntity<>(createdListing, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingDTO> getListing(@PathVariable String id) {
        try {
            if (listingService.existById(id)) {
                ListingDTO listingDTO = listingService.getListingById(id);
                return new ResponseEntity<>(listingDTO, HttpStatus.FOUND);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ListingDTO>> getAllListing() {
        try {
            List<ListingDTO> listingDTO = listingService.getAllListings();
            return new ResponseEntity<>(listingDTO, HttpStatus.FOUND);
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateListing(@PathVariable String id, @RequestBody ListingDTO listingDTO) {
        try {
            if (listingService.existById(id)) {
                ListingDTO updatedListing = listingService.updateListing(id, listingDTO);
                //TODO log updatedListing
                return new ResponseEntity<>(true, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(false, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable String id) {
        try {
            if (listingService.existById(id)) {
                listingService.deleteListingById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}

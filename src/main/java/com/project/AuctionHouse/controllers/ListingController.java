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
        if (createdListing != null){
            return new ResponseEntity<>(createdListing, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
            //TODO log already exist
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingDTO> getListing(@PathVariable String id) {
        ListingDTO listingDTO = listingService.getListingById(id);

        if (listingDTO != null){
            return new ResponseEntity<>(listingDTO, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<ListingDTO>> getAllListing() {
        List<ListingDTO> listingDTO = listingService.getAllListings();
        return ResponseEntity.ok(listingDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListingDTO> updateListing(@PathVariable String id, @RequestBody ListingDTO listingDTO) {
        ListingDTO updatedListing = listingService.updateListing(id, listingDTO);
        return ResponseEntity.ok(updatedListing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable String id) {
        listingService.deleteListingById(id);
        return ResponseEntity.noContent().build();
    }

}

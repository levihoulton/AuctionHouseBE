package com.project.AuctionHouse.controllers;

import com.project.AuctionHouse.aspects.LoggingAspect;
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


    private ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService){
        this.listingService = listingService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createListing(@RequestBody ListingDTO listingDTO) {
        try {
            ListingDTO createdListing = listingService.createListing(listingDTO);
            return new ResponseEntity<>(createdListing, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getListing(@PathVariable String id) {
        try {
            if (listingService.existById(id)) {
                ListingDTO listingDTO = listingService.getListingById(id);
                return new ResponseEntity<>(listingDTO, HttpStatus.FOUND);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllListing() {
        try {
            List<ListingDTO> listingDTO = listingService.getAllListings();
            return new ResponseEntity<>(listingDTO, HttpStatus.FOUND);
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateListing(@RequestBody ListingDTO listingDTO) {
        try {
            if (listingService.existById(listingDTO.getId())) {
                ListingDTO updatedListing = listingService.updateListing(listingDTO);
                return new ResponseEntity<>(updatedListing, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteListing(@PathVariable String id) {
        try {
            if (listingService.existById(id)) {
                listingService.deleteListingById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/bidActive/{id}")
    public ResponseEntity<?> getActiveBidsListById(@PathVariable String id) {
        try {
            List<ListingDTO> listingDTOS = listingService.getAllCurrentBids(id);
            return new ResponseEntity<>(listingDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/bidPast/{id}")
    public ResponseEntity<?> getPastBidsListById(@PathVariable String id) {
        try {
            List<ListingDTO> listingDTOS = listingService.getAllItemsWon(id);
            return new ResponseEntity<>(listingDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<?> getActiveListingsListById(@PathVariable String id) {
        try {
            List<ListingDTO> listingDTOS = listingService.getAllActiveListings(id);
            return new ResponseEntity<>(listingDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/past/{id}")
    public ResponseEntity<?> getPastListingsListById(@PathVariable String id) {
        try {
            List<ListingDTO> listingDTOS = listingService.getAllCompletedListings(id);
            return new ResponseEntity<>(listingDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.EXPECTATION_FAILED);
        }
    }

    //TODO implement get all active
//    @GetMapping("/active")
//    public ResponseEntity<List<ListingDTO>> isListingActive(@PathVariable String id){
//
//    }

    //TODO implement isActive
//    @GetMapping("/active/{id}")
//    public ResponseEntity<Boolean> isListingActive(@PathVariable String id){
//
//    }

    //TODO implement getLosingListings



}

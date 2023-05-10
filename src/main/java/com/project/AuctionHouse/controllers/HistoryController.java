package com.project.AuctionHouse.controllers;

import com.project.AuctionHouse.dtos.HistoryDTO;
import com.project.AuctionHouse.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/{productId}")
    public List<HistoryDTO> getHistoryForProduct(@PathVariable String productId) {
        return historyService.getHistoryForProduct(productId);
    }

    @PostMapping("/{listingId}")
    public HistoryDTO createHistory(@PathVariable String listingId, @RequestBody HistoryDTO historyDTO) {
        return historyService.createHistory(listingId, historyDTO.getPrice());
    }

    // rest of HistoryController methods...

}


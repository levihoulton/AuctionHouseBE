package com.project.AuctionHouse.services;

import com.project.AuctionHouse.Mappers.HistoryMapper;
import com.project.AuctionHouse.dtos.HistoryDTO;
import com.project.AuctionHouse.models.History;
import com.project.AuctionHouse.models.Listing;
import com.project.AuctionHouse.repository.HistoryRepository;
import com.project.AuctionHouse.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private ListingRepository listingRepository;

    public List<HistoryDTO> getHistoryForProduct(String productId) {
        List<History> historyList = historyRepository.findByProductId(productId);
        return HistoryMapper.toDTOList(historyList);
    }

    public HistoryDTO createHistory(String listingId, double price) {
        Listing listing = listingRepository.findById(listingId);
        History history = new History(listing.getId(), price);
        History savedHistory = historyRepository.save(history);
        return HistoryMapper.toDTO(savedHistory);
    }

    // rest of HistoryService methods...

}


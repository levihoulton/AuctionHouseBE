package com.project.AuctionHouse.mappers;

import com.project.AuctionHouse.dtos.BidDTO;
import com.project.AuctionHouse.models.Bid;

import java.util.List;
import java.util.stream.Collectors;

public class BidMapper {
    public static Bid toEntity(BidDTO bidDTO) {
        Bid bid = new Bid();
        bid.setId(bidDTO.getId());
        bid.setUsername(bidDTO.getUsername());
        bid.setListingId(bidDTO.getListingId());
        bid.setPrice(bidDTO.getPrice());
        return bid;
    }

    public static BidDTO toDTO(Bid bid) {
        BidDTO bidDTO = new BidDTO();
        bidDTO.setId(bid.getId());
        bidDTO.setUsername(bid.getUsername());
        bidDTO.setListingId(bid.getListingId());
        bidDTO.setPrice(bid.getPrice());
        return bidDTO;
    }

    public static List<BidDTO> toDTO(List<Bid> bidList) {
        return bidList.stream()
                .map(BidMapper::toDTO)
                .collect(Collectors.toList());
    }
}

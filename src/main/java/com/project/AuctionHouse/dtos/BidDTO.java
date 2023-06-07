package com.project.AuctionHouse.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BidDTO {
    private String id;
    private String username;
    private String listingId;
    private double price;
}

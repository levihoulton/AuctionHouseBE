package com.project.AuctionHouse.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListingDTO {

    private String id;
    private String username;
    private String product;
    private double price;
    private String endDate;
    private String imageURL;

    // getters and setters

}


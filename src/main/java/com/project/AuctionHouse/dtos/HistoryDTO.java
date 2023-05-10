package com.project.AuctionHouse.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO {

    private String id;
    private String productId;
    private double price;
    private Date date;

    // getters and setters

}


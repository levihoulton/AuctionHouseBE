package com.project.AuctionHouse.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bids")
public class Bid {
    @Id
    private String id;
    private String username;
    private String listingId;
    private double price;

    public Bid(String username, String listingId, double price){
        this.id = new ObjectId().toString();
        this.username = username;
        this.listingId = listingId;
        this.price = price;
    }
}

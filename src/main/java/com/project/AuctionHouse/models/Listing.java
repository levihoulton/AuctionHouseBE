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
@Document(collection = "listings")
public class Listing {

    @Id
    private String id;
    private String username;
    private String product;
    private double price;
    private String endDate;
    private String imageURL;
    private String highestBidder;

    public Listing(String username, String product, double price, String imageURL, String endDate, String highestBidder) {
        this.id = new ObjectId().toString();
        this.username = username;
        this.product = product;
        this.price = price;
        this.endDate = endDate;
        this.highestBidder = highestBidder;
        this.imageURL = imageURL;
    }

}

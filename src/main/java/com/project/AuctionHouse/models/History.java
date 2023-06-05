package com.project.AuctionHouse.models;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter
@Setter
@Document(collection = "history")
public class History {

    @Id
    private String id;
    private String productId;
    private double price;
    private Date date;

    public History(String productId, double price) {
        this.id = new ObjectId().toString();
        this.productId = productId;
        this.price = price;
        this.date = new Date();
    }

}

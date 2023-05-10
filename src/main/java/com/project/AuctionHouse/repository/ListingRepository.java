package com.project.AuctionHouse.repository;

import com.project.AuctionHouse.models.Listing;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ListingRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Listing save(Listing listing) {
        return mongoTemplate.insert(listing);
    }

    public Listing findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));
        return mongoTemplate.findOne(query, Listing.class);
    }

    public Listing update(Listing listing) {
        return mongoTemplate.save(listing);
    }

    public void deleteById(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(username));
        mongoTemplate.remove(query, Listing.class);
    }
}




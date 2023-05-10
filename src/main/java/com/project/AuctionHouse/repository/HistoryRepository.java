package com.project.AuctionHouse.repository;

import com.project.AuctionHouse.models.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoryRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<History> findByProductId(String productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoTemplate.find(query, History.class);
    }

    public History save(History history) {
        return mongoTemplate.insert(history);
    }

    // TODO add more methods

}


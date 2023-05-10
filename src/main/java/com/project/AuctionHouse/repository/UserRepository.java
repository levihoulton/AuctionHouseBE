package com.project.AuctionHouse.repository;

import com.project.AuctionHouse.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User save(User user) {
        return mongoTemplate.insert(user);
    }

    public User findByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query, User.class);
    }

    public User update(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(user.getUsername()));
        Update update = new Update();
        update.set("password", user.getPassword());
        return mongoTemplate.findAndModify(query, update, User.class);
    }

    public void deleteByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        mongoTemplate.remove(query, User.class);
    }

}


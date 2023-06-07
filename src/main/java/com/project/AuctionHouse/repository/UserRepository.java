package com.project.AuctionHouse.repository;

import com.project.AuctionHouse.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'username': ?0, 'password': ?1}")
    Optional<User> authenticateUser(String username, String password);
}


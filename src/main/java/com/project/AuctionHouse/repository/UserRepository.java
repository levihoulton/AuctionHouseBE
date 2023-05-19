package com.project.AuctionHouse.repository;

import com.project.AuctionHouse.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);

    @Override
    List<User> findAll();

    @Override
    <S extends User> S save(S entity);

    @Override
    void deleteById(String s);
}


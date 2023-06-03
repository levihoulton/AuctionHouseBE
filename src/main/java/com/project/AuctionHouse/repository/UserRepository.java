package com.project.AuctionHouse.repository;

import com.project.AuctionHouse.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Override
    Optional<User> findById(String s);

    @Override
    List<User> findAll();

    @Override
    <S extends User> S save(S entity);

    @Override
    void deleteById(String s);

    @Override
    boolean existsById(String s);
}


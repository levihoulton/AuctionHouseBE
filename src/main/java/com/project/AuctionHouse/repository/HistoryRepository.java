package com.project.AuctionHouse.repository;

import com.project.AuctionHouse.models.History;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoryRepository extends MongoRepository<History, String> {
    @Override
    Optional<History> findById(String s);

    @Override
    List<History> findAll();

    @Override
    void deleteById(String s);

    @Override
    <S extends History> S save(S entity);

    // TODO add more methods

}


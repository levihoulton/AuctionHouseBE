package com.project.AuctionHouse.repository;

import com.project.AuctionHouse.models.History;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoryRepository extends MongoRepository<History, String> {

}


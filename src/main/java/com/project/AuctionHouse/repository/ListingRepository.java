package com.project.AuctionHouse.repository;

import com.project.AuctionHouse.models.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository extends MongoRepository<Listing, String> {

}




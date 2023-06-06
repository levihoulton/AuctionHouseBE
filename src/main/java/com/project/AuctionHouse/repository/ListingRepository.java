package com.project.AuctionHouse.repository;

import com.project.AuctionHouse.models.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository extends MongoRepository<Listing, String> {
    @Query("{'endDate': { $gt: ?0 }, 'highestBidder': ?1}")
    List<Listing> findAllCurrentBids(long currentTime, String id);

}




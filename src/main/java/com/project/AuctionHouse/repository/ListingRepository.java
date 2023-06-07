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

    @Query("{'endDate': { $lte: ?0 }, 'highestBidder': ?1}")
    List<Listing> findAllItemsWon(long currentTime, String id);

    @Query("{'endDate': { $gt: ?0 }, 'username': ?1}")
    List<Listing> findAllActiveListings(long currentTime, String id);

    @Query("{'endDate': { $lte: ?0 }, 'username': ?1}")
    List<Listing> findAllCompletedListings(long currentTime, String id);


}




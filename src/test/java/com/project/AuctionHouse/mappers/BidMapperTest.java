package com.project.AuctionHouse.mappers;

import com.project.AuctionHouse.dtos.BidDTO;
import com.project.AuctionHouse.models.Bid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BidMapperTest {

    @Test
    public void testToEntity() {
        BidDTO bidDTO = new BidDTO();
        bidDTO.setId("1");
        bidDTO.setUsername("user1");
        bidDTO.setListingId("listing1");
        bidDTO.setPrice(100.0);

        Bid result = BidMapper.toEntity(bidDTO);

        Assertions.assertEquals(bidDTO.getId(), result.getId());
        Assertions.assertEquals(bidDTO.getUsername(), result.getUsername());
        Assertions.assertEquals(bidDTO.getListingId(), result.getListingId());
        Assertions.assertEquals(bidDTO.getPrice(), result.getPrice());
    }

    @Test
    public void testToDTO() {
        Bid bid = new Bid();
        bid.setId("1");
        bid.setUsername("user1");
        bid.setListingId("listing1");
        bid.setPrice(100.0);

        BidDTO result = BidMapper.toDTO(bid);

        Assertions.assertEquals(bid.getId(), result.getId());
        Assertions.assertEquals(bid.getUsername(), result.getUsername());
        Assertions.assertEquals(bid.getListingId(), result.getListingId());
        Assertions.assertEquals(bid.getPrice(), result.getPrice());
    }

    @Test
    public void testToDTOList() {
        Bid bid = new Bid();
        bid.setId("1");
        bid.setUsername("user1");
        bid.setListingId("listing1");
        bid.setPrice(100.0);

        List<Bid> bidList = Arrays.asList(bid);

        List<BidDTO> result = BidMapper.toDTO(bidList);

        Assertions.assertEquals(1, result.size());

        BidDTO bidDTO = result.get(0);
        Assertions.assertEquals(bid.getId(), bidDTO.getId());
        Assertions.assertEquals(bid.getUsername(), bidDTO.getUsername());
        Assertions.assertEquals(bid.getListingId(), bidDTO.getListingId());
        Assertions.assertEquals(bid.getPrice(), bidDTO.getPrice());
    }
}

package com.project.AuctionHouse.mappers;

import com.project.AuctionHouse.dtos.ListingDTO;
import com.project.AuctionHouse.models.Listing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListingMapperTest {

    @Test
    public void testToEntity() {
        ListingDTO listingDTO = new ListingDTO();
        listingDTO.setId("1L");
        listingDTO.setUsername("john");
        listingDTO.setProduct("Phone");
        listingDTO.setPrice(500.0);
        listingDTO.setEndDate(Long.valueOf(1685990532));
        listingDTO.setImageURL("https://example.com/image.jpg");
        listingDTO.setHighestBidder("levi");

        Listing listing = ListingMapper.toEntity(listingDTO);

        Assertions.assertEquals("1L", listing.getId());
        Assertions.assertEquals("john", listing.getUsername());
        Assertions.assertEquals("Phone", listing.getProduct());
        Assertions.assertEquals(500.0, listing.getPrice());
        Assertions.assertEquals("https://example.com/image.jpg", listing.getImageURL());
        Assertions.assertEquals(1685990532, listing.getEndDate());
        Assertions.assertEquals("levi", listing.getHighestBidder());
    }

    @Test
    public void testToDTO() {
        Listing listing = new Listing();
        listing.setId("1L");
        listing.setUsername("jane");
        listing.setProduct("Laptop");
        listing.setPrice(1000.0);
        listing.setImageURL("https://example.com/laptop.jpg");
        listing.setEndDate(Long.valueOf(1685990532));
        listing.setHighestBidder("Levi");

        ListingDTO listingDTO = ListingMapper.toDTO(listing);

        Assertions.assertEquals("1L", listingDTO.getId());
        Assertions.assertEquals("jane", listingDTO.getUsername());
        Assertions.assertEquals("Laptop", listingDTO.getProduct());
        Assertions.assertEquals(1000.0, listingDTO.getPrice());
        Assertions.assertEquals("https://example.com/laptop.jpg", listingDTO.getImageURL());
        Assertions.assertEquals(1685990532, listingDTO.getEndDate());
        Assertions.assertEquals("Levi", listingDTO.getHighestBidder());
    }

    @Test
    public void testToDTOList() {
        Listing listing1 = new Listing();
        listing1.setId("1L");
        listing1.setUsername("john");
        listing1.setProduct("Phone");
        listing1.setPrice(500.0);
        listing1.setImageURL("https://example.com/phone.jpg");
        listing1.setEndDate(Long.valueOf(1685990532));
        listing1.setHighestBidder("Levi");

        Listing listing2 = new Listing();
        listing2.setId("2L");
        listing2.setUsername("jane");
        listing2.setProduct("Laptop");
        listing2.setPrice(1000.0);
        listing2.setImageURL("https://example.com/laptop.jpg");
        listing2.setEndDate(Long.valueOf(1685990532));
        listing2.setHighestBidder("John");

        List<Listing> listings = Arrays.asList(listing1, listing2);

        List<ListingDTO> listingDTOs = ListingMapper.toDTO(listings);

        Assertions.assertEquals(2, listingDTOs.size());
        Assertions.assertEquals("1L", listingDTOs.get(0).getId());
        Assertions.assertEquals("john", listingDTOs.get(0).getUsername());
        Assertions.assertEquals("Phone", listingDTOs.get(0).getProduct());
        Assertions.assertEquals(500.0, listingDTOs.get(0).getPrice());
        Assertions.assertEquals("https://example.com/phone.jpg", listingDTOs.get(0).getImageURL());
        Assertions.assertEquals(1685990532, listing1.getEndDate());
        Assertions.assertEquals("Levi", listing1.getHighestBidder());

        Assertions.assertEquals("2L", listingDTOs.get(1).getId());
        Assertions.assertEquals("jane", listingDTOs.get(1).getUsername());
        Assertions.assertEquals("Laptop", listingDTOs.get(1).getProduct());
        Assertions.assertEquals(1000.0, listingDTOs.get(1).getPrice());
        Assertions.assertEquals("https://example.com/laptop.jpg", listingDTOs.get(1).getImageURL());
        Assertions.assertEquals(1685990532, listing2.getEndDate());
        Assertions.assertEquals("John", listing2.getHighestBidder());

    }
}

package com.project.AuctionHouse.mappers;

import com.project.AuctionHouse.dtos.ListingDTO;
import com.project.AuctionHouse.models.Listing;

import java.util.List;
import java.util.stream.Collectors;

public class ListingMapper {

    public static Listing toEntity(ListingDTO listingDTO) {
        Listing listing = new Listing();
        listing.setId(listingDTO.getId());
        listing.setUsername(listingDTO.getUsername());
        listing.setProduct(listingDTO.getProduct());
        listing.setPrice(listingDTO.getPrice());
        listing.setEndDate(listingDTO.getEndDate());
        listing.setImageURL(listingDTO.getImageURL());
        return listing;
    }

    public static ListingDTO toDTO(Listing listing) {
        ListingDTO listingDTO = new ListingDTO();
        listingDTO.setId(listing.getId());
        listingDTO.setUsername(listing.getUsername());
        listingDTO.setProduct(listing.getProduct());
        listingDTO.setPrice(listing.getPrice());
        listingDTO.setEndDate(listing.getEndDate());
        listingDTO.setImageURL(listing.getImageURL());
        return listingDTO;
    }

    public static List<ListingDTO> toDTOList(List<Listing> listings) {
        return listings.stream()
                .map(ListingMapper::toDTO)
                .collect(Collectors.toList());
    }

}


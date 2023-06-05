package com.project.AuctionHouse.Mappers;

import com.project.AuctionHouse.dtos.HistoryDTO;
import com.project.AuctionHouse.models.History;

import java.util.List;
import java.util.stream.Collectors;

public class HistoryMapper {

    public static History toEntity(HistoryDTO historyDTO) {
        History history = new History(historyDTO.getProductId(), historyDTO.getPrice());
        history.setId(historyDTO.getId());
        history.setDate(historyDTO.getDate());
        return history;
    }

    public static HistoryDTO toDTO(History history) {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setId(history.getId());
        historyDTO.setProductId(history.getProductId());
        historyDTO.setPrice(history.getPrice());
        historyDTO.setDate(history.getDate());
        return historyDTO;
    }

    public static List<HistoryDTO> toDTOList(List<History> historyList) {
        return historyList.stream()
                .map(HistoryMapper::toDTO)
                .collect(Collectors.toList());
    }

}

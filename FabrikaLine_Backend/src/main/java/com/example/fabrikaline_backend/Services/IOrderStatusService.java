package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.OrderStatus;

import java.util.List;

public interface IOrderStatusService {
    List<OrderStatus> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}

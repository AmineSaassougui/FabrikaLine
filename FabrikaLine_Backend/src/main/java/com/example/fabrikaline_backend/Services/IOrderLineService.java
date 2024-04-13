package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.ComplaintCategory;
import com.example.fabrikaline_backend.Entities.OrderLine;

import java.util.List;

public interface IOrderLineService {
    List<OrderLine> getByOrder(Long orderId);
}

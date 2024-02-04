package com.example.fabrikaline_backend.Models;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SearchCriteria {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}

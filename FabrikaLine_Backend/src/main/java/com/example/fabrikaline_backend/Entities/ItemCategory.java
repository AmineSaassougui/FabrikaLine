package com.example.fabrikaline_backend.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
public class ItemCategory implements Serializable {
    private  static  final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long code ;
    private String description ;
}

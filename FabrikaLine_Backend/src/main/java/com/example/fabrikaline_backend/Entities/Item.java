package com.example.fabrikaline_backend.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
public class Item implements Serializable {
    private  static  final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String description ;
    private double price ;
    private boolean avaiblity ;
    private Long quantity ;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;


}

package com.example.fabrikaline_backend.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
public class Claim implements Serializable {
    private  static  final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String description ;
    @ManyToOne
    @JoinColumn(name = "complaintcategory_id", nullable = false)
    private ComplaintCategory complaintCategory;

    @ManyToOne
    @JoinColumn(name = "complainttype_id", nullable = false)
    private ComplaintType complaintType;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;


}

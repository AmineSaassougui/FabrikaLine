package com.example.fabrikaline_backend.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
public class ComplaintType implements Serializable {
    private  static  final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long code ;
    private String description ;
    @ManyToOne
    @JoinColumn(name = "complaintcategory_id", nullable = false)
    private ComplaintCategory complaintCategory;

}

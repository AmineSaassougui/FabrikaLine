package com.example.fabrikaline_backend.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class User implements Serializable {
    private  static  final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String age ;
    private String description ;
    private Long zipcode ;
    private String note ;
    private String contactNumber ;
    private String email ;
    private String password ;

    @ManyToOne
    @JoinColumn(name = "usertype_id",nullable = false)
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "usergender_id",nullable = false)
    private UserGender userGender;

    @ManyToOne
    @JoinColumn(name = "userstatus_id",nullable = false)
    private UserStatus userStatus;

    @ManyToOne
    @JoinColumn(name = "city_id",nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "country_id",nullable = false)
    private Country country;
}

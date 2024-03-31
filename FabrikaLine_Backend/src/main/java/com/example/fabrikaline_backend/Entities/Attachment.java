package com.example.fabrikaline_backend.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Attachment implements Serializable {
    private  static  final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String code ;
    private String description ;
    private String extension  ;
    @Column(columnDefinition = "LONGTEXT")
    private String attachedFile ;
    private Long parentId ;

    @ManyToOne
    @JoinColumn(name = "attachmentcategory_id")
    private AttachmentCategory attachmentCategory;


}

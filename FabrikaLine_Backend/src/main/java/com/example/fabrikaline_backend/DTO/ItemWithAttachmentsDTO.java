package com.example.fabrikaline_backend.DTO;

import com.example.fabrikaline_backend.Entities.Attachment;

import javax.persistence.Column;
import java.util.List;

public class ItemWithAttachmentsDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private boolean availability;
    private Long quantity;
    @Column(columnDefinition = "LONGTEXT")
    private String coverPic ;
    private List<Attachment> attachments;


    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}

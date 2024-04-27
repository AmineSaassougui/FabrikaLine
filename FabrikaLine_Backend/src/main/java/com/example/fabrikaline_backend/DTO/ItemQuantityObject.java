package com.example.fabrikaline_backend.DTO;

public class ItemQuantityObject {
    private Long itemId;
    private Long quantity;

    public ItemQuantityObject() {
    }

    @Override
    public String toString() {
        return "ItemQuantityObject{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                '}';
    }

    public ItemQuantityObject(Long itemId, Long quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

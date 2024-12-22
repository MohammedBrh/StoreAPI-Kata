package com.alten.store.dto;

import com.alten.store.utils.InventoryStatus;
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ProcductDto {
        private Long id;
        private String code;
        private String name;
        private String description;
        private String image;
        private String category;
        private double price;
        private int quantity;
        private String internalReference;
        private Long shellId;
        private InventoryStatus inventoryStatus;
        private int rating;
        private Instant createdAt;
        private Instant updatedAt;

}

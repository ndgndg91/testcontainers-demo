package com.ndgndg91.testcontainers.product.controller.dto.request;

import com.ndgndg91.testcontainers.product.ProductInventory;
import com.ndgndg91.testcontainers.product.ProductVariant;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductInventoryRequest {
    private Long availableQuantity;
    private Boolean tracked;

    protected ProductInventory toProductInventory() {
        return new ProductInventory(availableQuantity, tracked);
    }
}

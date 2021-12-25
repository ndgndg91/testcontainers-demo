package com.ndgndg91.testcontainers.product;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private BigDecimal price;

    @Convert(converter = OptionValueConverter.class)
    @Column(name = "option_value", columnDefinition = "json")
    private final List<String> optionValues = new ArrayList<>();

    @OneToOne
    private ProductInventory inventory;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
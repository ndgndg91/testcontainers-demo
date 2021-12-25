package com.ndgndg91.testcontainers.product;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Embedded
    @AttributeOverride(name = "title", column = @Column(name = "seo_title"))
    @AttributeOverride(name = "description", column = @Column(name = "seo_description"))
    private ProductSEO seo;

    @Convert(converter = ProductMediaConverter.class)
    @Column(name = "media", columnDefinition = "json")
    private final List<Media> media = new ArrayList<>();

    @Convert(converter = OptionNameConverter.class)
    @Column(name = "option_name", columnDefinition = "json")
    private final List<String> optionNames = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private ProductStatus status;

    @OneToMany(mappedBy = "product")
    private final List<ProductVariant> variants = new ArrayList<>();
}
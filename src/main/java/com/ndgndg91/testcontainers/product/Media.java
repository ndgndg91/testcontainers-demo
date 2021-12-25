package com.ndgndg91.testcontainers.product;

import javax.persistence.*;

public class Media {
    @Enumerated(value = EnumType.STRING)
    private MediaContentType type;
    private String originalSource;
}

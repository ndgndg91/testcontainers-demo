package com.ndgndg91.testcontainers.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Media {
    @Enumerated(value = EnumType.STRING)
    private MediaContentType type;
    private String originalSource;
}

package com.ndgndg91.testcontainers.book.service;

import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

public interface NginxContainerIntegrationTest {
    @Container
    GenericContainer helloWorld = new GenericContainer("nginx:latest")
            .withReuse(true);

    // withReuse 를 사용하기 위해서는 ~/.testcontainers.properties 의 testcontainers.reuse.enable=true 로 설정해야한다.
    @BeforeAll
    static void setup() {
        helloWorld.start();
    }
}

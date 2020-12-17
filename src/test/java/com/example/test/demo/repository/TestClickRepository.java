package com.example.test.demo.repository;

import com.example.test.demo.TestClickerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = TestClickerApplication.class)
@TestPropertySource(locations="classpath:application_test.properties")
public class TestClickRepository {

    @Autowired
    private ClickRepository clickRepository;

    @Test
    public void testIncrementValue() {
        long value = clickRepository.getValue();
        clickRepository.updateValue();
        assertEquals(value + 1, clickRepository.getValue());
    }

}

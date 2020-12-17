package com.example.test.demo.config;

import com.example.test.demo.TestClickerApplication;
import com.example.test.demo.repository.ClickRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = TestClickerApplication.class)
@TestPropertySource(locations="classpath:application_test.properties")
public class TestDbInit {

    @Autowired
    private ClickRepository clickRepository;

    @Test
    public void testAddClickEntityInDb() {
        assertNotNull(clickRepository.getValue());
    }

}

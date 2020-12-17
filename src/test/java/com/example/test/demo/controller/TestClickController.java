package com.example.test.demo.controller;

import com.example.test.demo.TestClickerApplication;
import com.example.test.demo.repository.ClickRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestClickerApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application_test.properties")
public class TestClickController {

    @Autowired
    private ClickRepository clickRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIncrementValueInDB() throws Exception {
        long value = clickRepository.getValue();
        mockMvc.perform(get("/click"))
                .andExpect(status().isOk());
        assertEquals(value + 1, clickRepository.getValue());
    }

    @Test
    public void testMultithreadingIncrement() {
        long value = clickRepository.getValue();
        int countOfThread = 10000;

        AtomicInteger atomicInteger = new AtomicInteger(countOfThread);

        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < countOfThread; i++) {
            list.add(new Thread(() -> {
                try {
                    mockMvc.perform(get("/click"));
                } catch (Exception e) {
                    atomicInteger.decrementAndGet();
                }
            }));
        }

        list.forEach(Thread::start);
        list.forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        assertEquals(value + atomicInteger.get(), clickRepository.getValue());
    }
}

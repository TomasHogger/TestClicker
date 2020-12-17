package com.example.test.demo.service;

import com.example.test.demo.repository.ClickRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TestClickService {
    @Test
    public void testCallUpdateValue() {
        ClickRepository repository = mock(ClickRepository.class);
        ClickService clickService = new ClickService(repository);
        clickService.clickAndGetCount();
        verify(repository, times(1)).updateValue();
    }
}

package com.example.test.demo.service;

import com.example.test.demo.repository.ClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClickService {

    private final ClickRepository clickRepository;

    @Autowired
    public ClickService(ClickRepository clickRepository) {
        this.clickRepository = clickRepository;
    }

    public long clickAndGetCount() {
        clickRepository.updateValue();
        return getCount();
    }

    public long getCount() {
        return clickRepository.getValue();
    }
}

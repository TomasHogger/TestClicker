package com.example.test.demo.config;

import com.example.test.demo.model.Click;
import com.example.test.demo.repository.ClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {
    private final ClickRepository clickRepository;

    @Autowired
    public DbInit(ClickRepository clickRepository) {
        this.clickRepository = clickRepository;
    }

    @PostConstruct
    private void postConstruct() {
        if (clickRepository.findById(0).isEmpty()) {
            Click click = new Click();
            click.setId(0);
            click.setValue(0);
            clickRepository.save(click);
        }
    }
}

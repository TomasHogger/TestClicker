package com.example.test.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Click")
@Entity
@Data
public class Click {
    @Id
    private Integer id;
    private long value;
}

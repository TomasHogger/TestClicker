package com.example.test.demo.repository;

import com.example.test.demo.model.Click;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ClickRepository extends CrudRepository<Click, Integer> {
    @Query("SELECT value FROM Click WHERE id = 0")
    Long getValue();

    @Transactional
    @Modifying
    @Query("update Click SET value = value + 1 WHERE id = 0")
    void updateValue();
}

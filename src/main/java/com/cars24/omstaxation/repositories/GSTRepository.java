package com.cars24.omstaxation.repositories;

import com.cars24.omstaxation.entity.GST;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GSTRepository extends JpaRepository<GST, Long> {
    GST findByState(String state);
}

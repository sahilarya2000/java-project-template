package com.cars24.omstaxation.repository;

import com.cars24.omstaxation.entity.TaxConfig;
import org.springframework.data.jpa.repository.JpaRepository;
/**@author Saunik Singh*/
public interface TaxConfigRepository extends JpaRepository<TaxConfig, Long> {
    TaxConfig findByState(String state);
}

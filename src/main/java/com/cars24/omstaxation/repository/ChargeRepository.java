package com.cars24.omstaxation.repository;

import com.cars24.omstaxation.entity.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends JpaRepository<Charge,Long> {
}

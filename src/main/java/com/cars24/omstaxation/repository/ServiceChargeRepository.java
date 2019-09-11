package com.cars24.omstaxation.repository;

import com.cars24.omstaxation.entity.ServiceCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceChargeRepository extends JpaRepository<ServiceCharge,Long> {
}

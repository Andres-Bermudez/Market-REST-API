package com.platzi.Market.persistence.repositories;

import org.springframework.stereotype.Repository;
import com.platzi.Market.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}

package com.platzi.Market.persistence.repositories;

import org.springframework.stereotype.Repository;
import com.platzi.Market.persistence.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByIdCategory(Long idCategory);
}

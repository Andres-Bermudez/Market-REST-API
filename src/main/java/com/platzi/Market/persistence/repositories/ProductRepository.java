package com.platzi.Market.persistence.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.platzi.Market.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = """
                   SELECT *
                   FROM products
                   WHERE id_category = :idCategory
                   ORDER BY name ASC;
                   """, nativeQuery = true)
    List<ProductEntity> findByCategory(Long idCategory);

    @Query(value = """
                   SELECT *
                   FROM products
                   WHERE stock_quantity <= :quantity;
                   """, nativeQuery = true)
    List<ProductEntity> findByStockQuantity(Long quantity);
}

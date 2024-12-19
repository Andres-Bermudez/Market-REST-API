package com.platzi.Market.persistence.crud;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.platzi.Market.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
                   SELECT *
                   FROM products
                   WHERE id_category = :idCategory
                   ORDER BY name ASC;
                   """, nativeQuery = true)
    List<Product> findByCategory(Long idCategory);

    @Query(value = """
                   SELECT *
                   FROM products
                   WHERE stock_quantity <= :quantity;
                   """, nativeQuery = true)
    List<Product> findByStockQuantity(int quantity);

    @Query(value = """
                   SELECT *
                   FROM products
                   WHERE id_category = :idCategory;
                   """, nativeQuery = true)
    boolean existsByCategory(Long idCategory);
}

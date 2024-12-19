package com.platzi.Market.persistence.crud;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.platzi.Market.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Este metodo es un QUERY METHOD:
    // Un "query method" en el contexto de Spring Data JPA es un método definido en un repositorio que
    // permite realizar consultas a la base de datos basadas en el nombre del método. Spring Data JPA
    // analiza el nombre del método y construye automáticamente la consulta SQL correspondiente. Esto
    // permite realizar operaciones CRUD y consultas complejas sin necesidad de escribir manualmente
    // las consultas SQL o JPQL.

    @Query(value = """
                   SELECT *
                   FROM products
                   WHERE id_category = :idCategory;
                   """, nativeQuery = true)
    List<Product> findByIdCategory(Long idCategory);
}

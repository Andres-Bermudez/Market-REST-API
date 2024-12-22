package com.platzi.Market.persistence.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.platzi.Market.persistence.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {

    @Query(value = """
                   SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END
                   FROM purchases
                   WHERE id_customer = :idCustomer
                   """,
            nativeQuery = true)
    boolean existsByIdCustomer(String idCustomer);

    @Query(value = """
                   SELECT *
                   FROM purchases
                   WHERE id_customer = :idCustomer
                   """, nativeQuery = true)
    List<PurchaseEntity> getPurchasesByIdCustomer(String idCustomer);
}

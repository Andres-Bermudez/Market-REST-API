package com.platzi.Market.domain.entities.methods;

import java.util.List;
import java.util.Optional;
import com.platzi.Market.domain.entities.ProductDomain;

public interface DomainEntitiesMethods {

    List<ProductDomain> getAllProducts();
    Optional<List<ProductDomain>> getProductsByCategory(Long categoryId);
    Optional<List<ProductDomain>> getProductsByStockQuantity(Long quantity);
    Optional<ProductDomain> getProductById(Long productId);
    ProductDomain saveProduct(ProductDomain productDomain);
    void deleteProduct(Long productId);
}

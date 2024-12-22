package com.platzi.Market.persistence.methods;

import java.util.List;
import com.platzi.Market.domain.dto.ProductSavedDTO;
import com.platzi.Market.domain.dto.ProductReceivedDTO;

public interface DomainEntitiesMethods {

    List<ProductSavedDTO> getAllProducts();
    List<ProductSavedDTO> getProductsByIdCategory(Long idCategory);
    List<ProductSavedDTO> getProductsByStockQuantity(Long quantity);
    ProductSavedDTO getProductById(Long idProduct);
    ProductSavedDTO saveProduct(ProductReceivedDTO productReceivedDTO);
    void deleteProduct(Long idProduct);
}

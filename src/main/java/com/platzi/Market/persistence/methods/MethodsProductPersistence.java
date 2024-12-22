package com.platzi.Market.persistence.methods;

import java.util.List;
import com.platzi.Market.domain.dto.productdto.ProductSavedDTO;
import com.platzi.Market.domain.dto.productdto.ProductReceivedDTO;

public interface MethodsProductPersistence {

    List<ProductSavedDTO> getAllProducts();
    List<ProductSavedDTO> getProductsByIdCategory(Long idCategory);
    List<ProductSavedDTO> getProductsByStockQuantity(Long quantity);
    ProductSavedDTO getProductById(Long idProduct);
    ProductSavedDTO saveProduct(ProductReceivedDTO productReceivedDTO);
    void deleteProduct(Long idProduct);
}

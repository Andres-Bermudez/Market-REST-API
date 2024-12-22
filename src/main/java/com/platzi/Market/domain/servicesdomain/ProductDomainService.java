package com.platzi.Market.domain.servicesdomain;

import java.util.List;
import org.springframework.stereotype.Service;
import com.platzi.Market.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import com.platzi.Market.domain.dto.productdto.ProductSavedDTO;
import com.platzi.Market.persistence.methods.MethodsProductPersistence;
import com.platzi.Market.domain.dto.productdto.ProductReceivedDTO;
import com.platzi.Market.persistence.services.ProductPersistenceService;

@Service
public class ProductDomainService implements MethodsProductPersistence {

    @Autowired
    private ProductPersistenceService productPersistenceService;

    @Override
    public List<ProductSavedDTO> getAllProducts() {
        return productPersistenceService.getAllProducts();
    }

    @Override
    public List<ProductSavedDTO> getProductsByIdCategory(Long idCategory) {
        if (idCategory == null) {
            throw new ValidationException("This field 'idCategory' is null.");
        }
        return productPersistenceService.getProductsByIdCategory(idCategory);
    }

    @Override
    public List<ProductSavedDTO> getProductsByStockQuantity(Long quantity) {
        if (quantity == null || quantity == 0) {
            throw new ValidationException("This field 'quantity' is null or 0.");
        }
        return productPersistenceService.getProductsByStockQuantity(quantity);
    }

    @Override
    public ProductSavedDTO getProductById(Long idProduct) {
        if (idProduct == null) {
            throw new ValidationException("This field idProduct is null");
        }
        return productPersistenceService.getProductById(idProduct);
    }

    @Override
    public ProductSavedDTO saveProduct(ProductReceivedDTO productReceivedDTO) {
        if (productReceivedDTO.name() == null ||
            productReceivedDTO.idCategory() == null ||
            productReceivedDTO.salesPrice() == null ||
            productReceivedDTO.stockQuantity() == null
        ) {
            throw new ValidationException("Your request does not have the necessary" +
                    " data to create a new product.");
        }
        return productPersistenceService.saveProduct(productReceivedDTO);
    }

    @Override
    public void deleteProduct(Long idProduct) {
        if (idProduct == null) {
            throw new ValidationException("The field idProduct is null.");
        }
        productPersistenceService.deleteProduct(idProduct);
    }
}

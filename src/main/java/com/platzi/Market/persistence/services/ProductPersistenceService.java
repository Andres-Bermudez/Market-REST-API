package com.platzi.Market.persistence.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.platzi.Market.domain.dto.ProductSavedDTO;
import com.platzi.Market.domain.dto.ProductReceivedDTO;
import com.platzi.Market.exceptions.ValidationException;
import com.platzi.Market.persistence.entities.ProductEntity;
import com.platzi.Market.persistence.entities.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.platzi.Market.persistence.methods.DomainEntitiesMethods;
import com.platzi.Market.persistence.repositories.ProductRepository;
import com.platzi.Market.persistence.repositories.CategoryRepository;

@Service
public class ProductPersistenceService implements DomainEntitiesMethods {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Para listar todos los productos.
    @Override
    public List<ProductSavedDTO> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream()
                              .map(ProductSavedDTO::new)
                              .toList();
    }

    // Para buscar productos por categoria.
    @Override
    public List<ProductSavedDTO> getProductsByIdCategory(Long idCategory) {
        if (!categoryRepository.existsByIdCategory(idCategory)) {
            throw new ValidationException("This category does not exist.");
        }
        List<ProductEntity> productsEntityByCategoryList =
                productRepository.findByCategory(idCategory);

        if (productsEntityByCategoryList.isEmpty()) {
            throw new ValidationException("The product category you are looking for is empty.");
        }
        return productsEntityByCategoryList.stream()
                                           .map(ProductSavedDTO::new)
                                           .toList();
    }

    // Para buscar productos por la cantidad en stock
    @Override
    public List<ProductSavedDTO> getProductsByStockQuantity(Long quantity) {
        List<ProductEntity> productsStockList = productRepository.findByStockQuantity(quantity);

        if (productsStockList.isEmpty()) {
            throw new ValidationException("No records were found with that quantity in stock.");
        }
        return productsStockList.stream()
                                .map(ProductSavedDTO::new)
                                .toList();
    }

    // Para buscar un producto por su Id.
    @Override
    public ProductSavedDTO getProductById(Long idProduct) {
        if (!productRepository.existsById(idProduct)) {
            throw new ValidationException("The product id '" + idProduct + "' not exists.");
        }
        ProductEntity productEntity = productRepository.getReferenceById(idProduct);
        return new ProductSavedDTO(productEntity);
    }

    // Para guardar un nuevo producto.
    @Override
    public ProductSavedDTO saveProduct(ProductReceivedDTO productReceivedDTO) {
        if (!categoryRepository.existsById(productReceivedDTO.idCategory())) {
            throw new ValidationException("This category does not exists.");
        }
        CategoryEntity categoryEntity =
                categoryRepository.getReferenceById(productReceivedDTO.idCategory());

        ProductEntity productEntity = new ProductEntity(
                null,
                productReceivedDTO.name(),
                categoryEntity,
                productReceivedDTO.barCode(),
                productReceivedDTO.salesPrice(),
                productReceivedDTO.stockQuantity()
        );
        return new ProductSavedDTO(productRepository.save(productEntity));
    }

    // Para eliminar un producto.
    @Override
    public void deleteProduct(Long idProduct) {
        if (!productRepository.existsById(idProduct)) {
            throw new ValidationException("This product cannot be removed because it does not exist.");
        }
        productRepository.deleteById(idProduct);
    }
}

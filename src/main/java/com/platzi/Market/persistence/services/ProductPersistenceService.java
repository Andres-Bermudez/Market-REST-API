package com.platzi.Market.persistence.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.platzi.Market.domain.entities.ProductDomain;
import com.platzi.Market.exceptions.ValidationException;
import com.platzi.Market.persistence.mappers.ProductMapper;
import com.platzi.Market.persistence.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.platzi.Market.persistence.repositories.ProductRepository;
import com.platzi.Market.domain.entities.methods.DomainEntitiesMethods;

@Service
public class ProductPersistenceService implements DomainEntitiesMethods {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // Para listar todos los productos.
    @Override
    public List<ProductDomain> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productMapper.toProductsDomain(productEntities);
    }

    // Para buscar productos por categoria.
    @Override
    public Optional<List<ProductDomain>> getProductsByCategory(Long idCategory) {
        if (!productRepository.existsByCategory(idCategory)) {
            throw new ValidationException("This category does not exist.");
        }

        List<ProductEntity> productsByCategory = productRepository.findByCategory(idCategory);
        if (productsByCategory.isEmpty()) {
            throw new ValidationException("The product category you are looking for is empty.");
        }
        return Optional.of(productMapper.toProductsDomain(productsByCategory));
    }

    // Para buscar productos por la cantidad en stock
    @Override
    public Optional<List<ProductDomain>> getProductsByStockQuantity(Long quantity) {
        List<ProductEntity> productsStock = productRepository.findByStockQuantity(quantity);
        if (productsStock.isEmpty()) {
            throw new ValidationException("No records were found with that quantity in stock.");
        }
        return Optional.of(productMapper.toProductsDomain(productsStock));
    }

    // Para buscar un producto por su Id.
    @Override
    public Optional<ProductDomain> getProductById(Long idProduct) {
        if (!productRepository.existsById(idProduct)) {
            throw new ValidationException("The product id '" + idProduct + "' not exists.");
        }
        ProductEntity productEntity = productRepository.getReferenceById(idProduct);
        return Optional.of(productMapper.toProductDomain(productEntity));
    }

    // Para guardar un nuevo producto.
    @Override
    public ProductDomain saveProduct(ProductDomain productDomain) {
        ProductEntity productEntity = productMapper.toProductEntity(productDomain);
        return productMapper.toProductDomain(productRepository.save(productEntity));
    }

    // Para eliminar un producto.
    @Override
    public void deleteProduct(Long idProduct) {
        productRepository.deleteById(idProduct);
    }
}

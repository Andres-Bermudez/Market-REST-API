package com.platzi.Market.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.platzi.Market.persistence.entity.Product;
import com.platzi.Market.exceptions.ValidationException;
import com.platzi.Market.persistence.crud.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Para listar todos los productos.
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Para buscar productos por categoria.
    public List<Product> getProductByCategory(Long idCategory) {
        if (!productRepository.existsByCategory(idCategory)) {
            throw new ValidationException("Esta categoria no existe.");
        }

        List<Product> productsByCategory = productRepository.findByCategory(idCategory);
        if (productsByCategory.isEmpty()) {
            throw new ValidationException("La categoria de productos que buscas esta vacia.");
        }
        return productsByCategory;
    }

    // Para buscar productos por la cantidad en stock
    public List<Product> getByStockQuantity(int quantity) {
        List<Product> productsStock = productRepository.findByStockQuantity(quantity);
        if (productsStock.isEmpty()) {
            throw new ValidationException("No se encontraron registros con esa cantidad en stock.");
        }
        return productsStock;
    }

    // Para buscar un producto por su Id.
    public Product getProductById(Long idProduct) {
        if (!productRepository.existsById(idProduct)) {
            throw new ValidationException("El producto con el id '" + idProduct + "' no existe.");
        }
        return productRepository.getReferenceById(idProduct);
    }

    // Para guardar un nuevo producto.
    public void save(Product product) {
        productRepository.save(product);
    }

    // Para eliminar un producto.
    public void deleteProduct(Long idProduct) {
        productRepository.deleteById(idProduct);
    }
}

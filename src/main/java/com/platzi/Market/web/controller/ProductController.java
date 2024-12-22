package com.platzi.Market.web.controller;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.platzi.Market.domain.dto.ProductSavedDTO;
import com.platzi.Market.domain.dto.ProductReceivedDTO;
import org.springframework.web.util.UriComponentsBuilder;
import com.platzi.Market.domain.services.ProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDomainService productDomainService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductSavedDTO>> getAllProducts() {
        return ResponseEntity.ok(productDomainService.getAllProducts());
    }

    @GetMapping("/category/{idCategory}")
    public ResponseEntity<List<ProductSavedDTO>> getProductsByCategory(
            @PathVariable Long idCategory
    ) {
        List<ProductSavedDTO> productSavedDTOList =
                productDomainService.getProductsByIdCategory(idCategory);
        return ResponseEntity.ok(productSavedDTOList);
    }

    @GetMapping("/stock/{quantity}")
    public ResponseEntity<List<ProductSavedDTO>> getProductsByStockQuantity(
           @PathVariable Long quantity
    ) {
        return ResponseEntity.ok(productDomainService.getProductsByStockQuantity(quantity));
    }

    @GetMapping("/find/{idProduct}")
    public ResponseEntity<ProductSavedDTO> getProductById(
            @PathVariable Long idProduct
    ) {
        return ResponseEntity.ok(productDomainService.getProductById(idProduct));
    }

    @PostMapping("/save")
    public ResponseEntity<ProductSavedDTO> saveProduct(
            @RequestBody
            ProductReceivedDTO productReceivedDTO,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        ProductSavedDTO productSavedDTO = productDomainService.saveProduct(productReceivedDTO);
        URI url = uriComponentsBuilder
                            .path("/products/{idProduct}")
                            .buildAndExpand(productSavedDTO
                                    .idProduct()
                            )
                            .toUri();

        return ResponseEntity.created(url).body(productSavedDTO);
    }

    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity deleteProductById(@PathVariable Long idProduct) {
        productDomainService.deleteProduct(idProduct);
        return ResponseEntity.ok().build();
    }
}

package com.platzi.Market.persistence.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.InheritInverseConfiguration;
import com.platzi.Market.domain.entities.ProductDomain;
import com.platzi.Market.persistence.entities.ProductEntity;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryEntity", target = "categoryDomain"),
            @Mapping(source = "salesPrice", target = "salesPrice"),
            @Mapping(source = "stockQuantity", target = "stockQuantity"),
            @Mapping(source = "status", target = "active")
    })
    ProductDomain toProductDomain(ProductEntity productEntity);
    List<ProductDomain> toProductsDomain(List<ProductEntity> productsEntities);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    ProductEntity toProductEntity(ProductDomain productDomain);
}

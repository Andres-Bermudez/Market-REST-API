package com.platzi.Market.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.InheritInverseConfiguration;
import com.platzi.Market.domain.entities.CategoryDomain;
import com.platzi.Market.persistence.entities.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "status", target = "active")
    })
    CategoryDomain toCategoryDomain(CategoryEntity categoryEntity);

    @InheritInverseConfiguration
    CategoryEntity toCategoryEntity(CategoryDomain categoryDomain);
}

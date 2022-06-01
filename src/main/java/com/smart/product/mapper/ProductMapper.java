package com.smart.product.mapper;

import com.smart.product.dto.ProductDto;
import com.smart.product.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

/**
 * @author Choudhury Subham on 01-06-2022
 */
@Mapper(componentModel ="spring",imports = UUID.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto entityToDto(Product product);
    @InheritInverseConfiguration
    Product dtoToEntity(ProductDto productDto);

}

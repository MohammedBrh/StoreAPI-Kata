package com.alten.store.dto.mappers;

import com.alten.store.dto.ProcductDto;
import com.alten.store.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    ProcductDto toProductDto(Product product);

    Product toProduct(ProcductDto productDto);

    List<ProcductDto> toProductDtos(List<Product> products);

    List<Product> toProducts(List<ProcductDto> productDtos);
}
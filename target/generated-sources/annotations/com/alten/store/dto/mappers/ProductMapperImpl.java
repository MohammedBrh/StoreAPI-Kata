package com.alten.store.dto.mappers;

import com.alten.store.dto.ProcductDto;
import com.alten.store.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T01:35:08+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProcductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProcductDto procductDto = new ProcductDto();

        procductDto.setId( product.getId() );
        procductDto.setCode( product.getCode() );
        procductDto.setName( product.getName() );
        procductDto.setDescription( product.getDescription() );
        procductDto.setImage( product.getImage() );
        procductDto.setCategory( product.getCategory() );
        procductDto.setPrice( product.getPrice() );
        procductDto.setQuantity( product.getQuantity() );
        procductDto.setInternalReference( product.getInternalReference() );
        procductDto.setShellId( product.getShellId() );
        procductDto.setInventoryStatus( product.getInventoryStatus() );
        procductDto.setRating( product.getRating() );
        procductDto.setCreatedAt( product.getCreatedAt() );
        procductDto.setUpdatedAt( product.getUpdatedAt() );

        return procductDto;
    }

    @Override
    public Product toProduct(ProcductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setCode( productDto.getCode() );
        product.setName( productDto.getName() );
        product.setDescription( productDto.getDescription() );
        product.setImage( productDto.getImage() );
        product.setCategory( productDto.getCategory() );
        product.setPrice( productDto.getPrice() );
        product.setQuantity( productDto.getQuantity() );
        product.setInternalReference( productDto.getInternalReference() );
        product.setShellId( productDto.getShellId() );
        product.setInventoryStatus( productDto.getInventoryStatus() );
        product.setRating( productDto.getRating() );
        product.setCreatedAt( productDto.getCreatedAt() );
        product.setUpdatedAt( productDto.getUpdatedAt() );

        return product;
    }

    @Override
    public List<ProcductDto> toProductDtos(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProcductDto> list = new ArrayList<ProcductDto>( products.size() );
        for ( Product product : products ) {
            list.add( toProductDto( product ) );
        }

        return list;
    }

    @Override
    public List<Product> toProducts(List<ProcductDto> productDtos) {
        if ( productDtos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDtos.size() );
        for ( ProcductDto procductDto : productDtos ) {
            list.add( toProduct( procductDto ) );
        }

        return list;
    }
}

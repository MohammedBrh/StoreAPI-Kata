package com.alten.store.dto.mappers;

import com.alten.store.dto.ProcductDto;
import com.alten.store.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-22T23:46:19+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProcductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProcductDto procductDto = new ProcductDto();

        return procductDto;
    }

    @Override
    public Product toProduct(ProcductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        return product;
    }
}

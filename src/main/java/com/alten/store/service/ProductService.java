package com.alten.store.service;

import com.alten.store.dto.ProcductDto;
import com.alten.store.dto.mappers.ProductMapper;
import com.alten.store.entity.Product;
import com.alten.store.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {


    private  ProductRepository productRepository;
    private  ProductMapper productMapper;

    // Get all products as DTOs
    public List<ProcductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (!products.isEmpty()) {
            return products.stream()
                    .map(product -> productMapper.toProductDto(product))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();  // Return an empty list instead of null
        }
    }

    // Get product by ID as DTO
    public Optional<ProcductDto> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return Optional.ofNullable(productMapper.toProductDto(product.get()));
    }

    // Save or update a product using DTO
    public ProcductDto saveOrUpdateProduct(ProcductDto productDTO) {
        Product product = ProductMapper.INSTANCE.toProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.INSTANCE.toProductDto(savedProduct);
    }

    // Delete product by ID
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}

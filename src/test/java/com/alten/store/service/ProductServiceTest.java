package com.alten.store.service;


import com.alten.store.dto.ProcductDto;
import com.alten.store.dto.mappers.ProductMapper;
import com.alten.store.entity.Product;
import com.alten.store.repository.ProductRepository;
import com.alten.store.utils.InventoryStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts_WhenProductsExist() {
        // Arrange
        Product product1 = new Product(
                null, // id will be auto-generated
                "PROD1",
                "Product 1",
                "This is a sample product.",
                "sample.jpg",
                "Category A",
                19.99,
                100,
                "REF123",
                123L,
                InventoryStatus.INSTOCK,
                5,null,null
        );
        Product product2 = new Product(
                null, // id will be auto-generated
                "PROD2",
                "Product 2",
                "This is a sample product.",
                "sample.jpg",
                "Category A",
                19.99,
                100,
                "REF123",
                123L,
                InventoryStatus.INSTOCK,
                5,null,null
        );

        List<Product> products = Arrays.asList(product1, product2);

        ProcductDto productDto1 = new ProcductDto(
                null, // id will be auto-generated
                "PROD2",
                "Product 1",
                "This is a sample product.",
                "sample.jpg",
                "Category A",
                19.99,
                100,
                "REF123",
                123L,
                InventoryStatus.INSTOCK,
                5,null,null
        );

        ProcductDto productDto2 =  new ProcductDto(
                null, // id will be auto-generated
                "PROD2",
                "Product 2",
                "This is a sample product.",
                "sample.jpg",
                "Category A",
                19.99,
                100,
                "REF123",
                123L,
                InventoryStatus.INSTOCK,
                5,null,null
        );

        when(productRepository.findAll()).thenReturn(products);
        when(productMapper.toProductDto(product1)).thenReturn(productDto1);
        when(productMapper.toProductDto(product2)).thenReturn(productDto2);

        // Act
        List<ProcductDto> result = productService.getAllProducts();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
        assertEquals("Product 2", result.get(1).getName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetAllProducts_WhenNoProductsExist() {
        // Arrange
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<ProcductDto> result = productService.getAllProducts();

        // Assert
        assertTrue(result.isEmpty());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProductById_WhenProductExists() {
        // Arrange
        Long productId = 1L;
        Product product = new Product(
                productId, // id will be auto-generated
                "PROD2",
                "Product 1",
                "This is a sample product.",
                "sample.jpg",
                "Category A",
                19.99,
                100,
                "REF123",
                123L,
                InventoryStatus.INSTOCK,
                5,null,null
        );
        ProcductDto productDto = new ProcductDto(
                productId, // id will be auto-generated
                "PROD2",
                "Product 1",
                "This is a sample product.",
                "sample.jpg",
                "Category A",
                19.99,
                100,
                "REF123",
                123L,
                InventoryStatus.INSTOCK,
                5,null,null
        );

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(productMapper.toProductDto(product)).thenReturn(productDto);

        // Act
        Optional<ProcductDto> result = productService.getProductById(productId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Product 1", result.get().getName());
        verify(productRepository, times(1)).findById(productId);
    }



    @Test
    void testSaveOrUpdateProduct() {
        // Arrange
        ProcductDto productDto = new ProcductDto(
                1L, // id will be auto-generated
                "PROD2",
                "Product 1",
                "This is a sample product.",
                "sample.jpg",
                "Category A",
                19.99,
                100,
                "REF123",
                123L,
                InventoryStatus.INSTOCK,
                5,null,null
        );
        Product product = new Product(
                1L, // id will be auto-generated
                "PROD2",
                "Product 1",
                "This is a sample product.",
                "sample.jpg",
                "Category A",
                19.99,
                100,
                "REF123",
                123L,
                InventoryStatus.INSTOCK,
                5,null,null
        );
        when(productMapper.toProduct(productDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        when(productMapper.toProductDto(product)).thenReturn(productDto);

        // Act
        ProcductDto result = productService.saveOrUpdateProduct(productDto);

        // Assert
        assertNotNull(result);
        assertEquals("Product 1", result.getName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testDeleteProductById() {
        // Arrange
        Long productId = 1L;

        // Act
        productService.deleteProductById(productId);

        // Assert
        verify(productRepository, times(1)).deleteById(productId);
    }
}

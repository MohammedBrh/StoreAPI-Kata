package com.alten.store.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import com.alten.store.dto.ProcductDto;
import com.alten.store.dto.mappers.ProductMapper;
import com.alten.store.entity.Product;
import com.alten.store.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Product1");

        Product product2 = new Product();
        product1.setId(2L);
        product1.setName("Product2");

        List<Product> products = Arrays.asList(product1, product2);

        ProcductDto productDto1 = new   ProcductDto();
        product1.setId(1L);
        product1.setName("Product1");

        ProcductDto productDto2 = new   ProcductDto();
        product1.setId(2L);
        product1.setName("Product2");

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
        Product product = new Product(productId, "Product 1", 10.0);
        ProcductDto productDto = new ProcductDto(productId, "Product 1", 10.0);
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
    void testGetProductById_WhenProductDoesNotExist() {
        // Arrange
        Long productId = 1L;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Act
        Optional<ProcductDto> result = productService.getProductById(productId);

        // Assert
        assertFalse(result.isPresent());
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testSaveOrUpdateProduct() {
        // Arrange
        ProcductDto productDto = new ProcductDto(1L, "Product 1", 10.0);
        Product product = new Product(1L, "Product 1", 10.0);
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

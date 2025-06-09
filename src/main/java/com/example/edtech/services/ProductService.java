package com.example.edtech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edtech.entities.Product;
import com.example.edtech.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

      public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

      public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

      public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

       public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

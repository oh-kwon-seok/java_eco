package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.product.ProductDto;

import com.springboot.java_jangan.data.dto.product.ProductSearchDto;
import com.springboot.java_jangan.data.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getTotalProduct(ProductSearchDto productSearchDto);

    Product saveProduct(ProductDto productDto) throws Exception;

    Product updateProduct(ProductDto productDto) throws Exception;

    void deleteProduct(List<Long> uid) throws Exception;


}

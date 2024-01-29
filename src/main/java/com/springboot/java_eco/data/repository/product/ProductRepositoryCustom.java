package com.springboot.java_eco.data.repository.product;

import com.springboot.java_eco.data.dto.product.ProductSearchDto;
import com.springboot.java_eco.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findAll(ProductSearchDto productSearchDto);


}

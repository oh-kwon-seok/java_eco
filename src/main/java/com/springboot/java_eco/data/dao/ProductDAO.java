package com.springboot.java_eco.data.dao;

import com.springboot.java_eco.data.dto.product.ProductDto;
import com.springboot.java_eco.data.dto.product.ProductSearchDto;
import com.springboot.java_eco.data.entity.Product;

import java.util.List;
import java.util.Map;


public interface ProductDAO {



    Product insertProduct(ProductDto productDto) throws Exception;


    List<Product> selectTotalProduct(ProductSearchDto productSearchDto);


    Product updateProduct(ProductDto productDto) throws Exception;

    String deleteProduct(List<Long> uid) throws Exception;


    String excelUploadProduct(List<Map<String, Object>> requestList) throws Exception;



}

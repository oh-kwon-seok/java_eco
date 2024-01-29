package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.ProductDAO;
import com.springboot.java_eco.data.dto.product.ProductDto;
import com.springboot.java_eco.data.dto.product.ProductSearchDto;
import com.springboot.java_eco.data.entity.Product;
import com.springboot.java_eco.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(@Qualifier("productDAOImpl") ProductDAO productDAO){
        this.productDAO = productDAO;
    }


    @Override
    public List<Product> getTotalProduct(ProductSearchDto productSearchDto){
        return productDAO.selectTotalProduct(productSearchDto);
    }

    @Override
    public Product saveProduct(ProductDto productDto) throws Exception {

        return productDAO.insertProduct(productDto);

    }
    @Override
    public Product updateProduct(ProductDto productDto) throws Exception {
        return productDAO.updateProduct(productDto);
    }
    @Override
    public void deleteProduct(List<Long> uid) throws Exception {
        productDAO.deleteProduct(uid);
    }

    @Override
    public void excelUploadProduct(List<Map<String, Object>> requestList) throws Exception {
        productDAO.excelUploadProduct(requestList);
    }

}

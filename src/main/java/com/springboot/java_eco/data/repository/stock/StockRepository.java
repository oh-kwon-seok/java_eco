package com.springboot.java_eco.data.repository.stock;


import com.springboot.java_eco.data.entity.Company;
import com.springboot.java_eco.data.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("stockRepositorySupport")
public interface StockRepository extends JpaRepository<Stock,String>, StockRepositoryCustom {

    Stock findByUid(Long uid);
    Stock findByLotAndCompany(String lot, Company company);

}

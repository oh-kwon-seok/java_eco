package com.springboot.java_eco.data.repository.bom;

import com.springboot.java_eco.data.entity.Company;
import com.springboot.java_eco.data.entity.Bom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bomRepositorySupport")
public interface BomRepository extends JpaRepository<Bom,Long>, BomRepositoryCustom {

    Bom findByUid(Long uid);


    Bom findByCodeAndCompanyAndUsed(String name, Company company, Long used);

}

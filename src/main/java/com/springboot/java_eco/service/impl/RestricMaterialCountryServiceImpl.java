package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.RestricMaterialCountryDAO;
import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.restricMaterialCountry.RestricMaterialCountryDto;
import com.springboot.java_eco.data.entity.RestricMaterialCountry;
import com.springboot.java_eco.service.RestricMaterialCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestricMaterialCountryServiceImpl implements RestricMaterialCountryService {
    private final RestricMaterialCountryDAO restricMaterialCountryDAO;

    @Autowired
    public RestricMaterialCountryServiceImpl(@Qualifier("restricMaterialCountryDAOImpl") RestricMaterialCountryDAO restricMaterialCountryDAO){
        this.restricMaterialCountryDAO = restricMaterialCountryDAO;
    }


    @Override
    public List<RestricMaterialCountry> getTotalRestricMaterialCountry(CommonSearchDto commonSearchDto){
        return restricMaterialCountryDAO.selectTotalRestricMaterialCountry(commonSearchDto);
    }

    @Override
    public List<RestricMaterialCountry> getRestricMaterialCountry(CommonSearchDto commonSearchDto){
        return restricMaterialCountryDAO.selectRestricMaterialCountry(commonSearchDto);
    }
    @Override
    public CommonResultDto saveRestricMaterialCountry(RestricMaterialCountryDto restricMaterialCountryDto,String clientIp) throws Exception {

        return restricMaterialCountryDAO.insertRestricMaterialCountry(restricMaterialCountryDto,clientIp);

    }

    @Override
    public void deleteRestricMaterialCountry(List<Long> uid) throws Exception {
        restricMaterialCountryDAO.deleteRestricMaterialCountry(uid);
    }


}

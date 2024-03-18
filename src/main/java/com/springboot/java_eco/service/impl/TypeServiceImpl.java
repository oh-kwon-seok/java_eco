package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.TypeDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.type.TypeDto;
import com.springboot.java_eco.data.entity.Type;
import com.springboot.java_eco.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeDAO typeDAO;

    @Autowired
    public TypeServiceImpl(@Qualifier("typeDAOImpl") TypeDAO typeDAO){
        this.typeDAO = typeDAO;
    }


    @Override
    public List<Type> getTotalType(CommonSearchDto commonSearchDto){
        return typeDAO.selectTotalType(commonSearchDto);
    }

    @Override
    public List<Type> getType(CommonSearchDto commonSearchDto){
        return typeDAO.selectType(commonSearchDto);
    }
    @Override
    public Type saveType(TypeDto typeDto) throws Exception {

        return typeDAO.insertType(typeDto);

    }
    @Override
    public Type updateType(TypeDto typeDto) throws Exception {
        return typeDAO.updateType(typeDto);
    }
    @Override
    public void deleteType(List<Long> uid) throws Exception {
        typeDAO.deleteType(uid);
    }

}

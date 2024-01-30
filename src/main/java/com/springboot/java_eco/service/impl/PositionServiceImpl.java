package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.PositionDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.position.PositionDto;
import com.springboot.java_eco.data.entity.Position;
import com.springboot.java_eco.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    private final PositionDAO positionDAO;

    @Autowired
    public PositionServiceImpl(@Qualifier("positionDAOImpl") PositionDAO positionDAO){
        this.positionDAO = positionDAO;
    }


    @Override
    public List<Position> getTotalPosition(CommonSearchDto commonSearchDto){
        return positionDAO.selectTotalPosition(commonSearchDto);
    }

    @Override
    public List<Position> getPosition(CommonSearchDto commonSearchDto){
        return positionDAO.selectPosition(commonSearchDto);
    }
    @Override
    public Position savePosition(PositionDto positionDto) throws Exception {

        return positionDAO.insertPosition(positionDto);

    }
    @Override
    public Position updatePosition(PositionDto positionDto) throws Exception {
        return positionDAO.updatePosition(positionDto);
    }
    @Override
    public void deletePosition(List<Long> uid) throws Exception {
        positionDAO.deletePosition(uid);
    }

}

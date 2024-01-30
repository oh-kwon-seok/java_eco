package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.position.PositionDto;
import com.springboot.java_eco.data.entity.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PositionService {

    List<Position> getTotalPosition(CommonSearchDto commonSearchDto);

    List<Position> getPosition(CommonSearchDto commonSearchDto);


    Position savePosition(PositionDto positionDto) throws Exception;

    Position updatePosition(PositionDto positionDto) throws Exception;

    void deletePosition(List<Long> uid) throws Exception;


}

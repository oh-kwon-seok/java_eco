package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.position.PositionDto;
import com.springboot.java_eco.data.entity.Position;

import java.util.List;


public interface PositionDAO {
    Position insertPosition(PositionDto positionDto);

    List<Position> selectTotalPosition(CommonSearchDto commonSearchDto);
    List<Position> selectPosition(CommonSearchDto commonSearchDto);

    Position updatePosition(PositionDto positionDto) throws Exception;

    String deletePosition(List<Long> uid) throws Exception;


}

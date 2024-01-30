package com.springboot.java_eco.data.repository.position;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Position;

import java.util.List;

public interface PositionRepositoryCustom {
    List<Position> findAll(CommonSearchDto commonSearchDto);
    List<Position> findInfo(CommonSearchDto commonSearchDto);

}

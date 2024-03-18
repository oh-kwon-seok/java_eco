package com.springboot.java_eco.data.repository.equipment;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Employment;
import com.springboot.java_eco.data.entity.Equipment;

import java.util.List;

public interface EquipmentRepositoryCustom {
    List<Equipment> findAll(CommonSearchDto commonSearchDto);
    List<Equipment> findInfo(CommonSearchDto commonSearchDto);

}

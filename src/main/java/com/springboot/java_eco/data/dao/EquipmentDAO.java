package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.equipment.EquipmentDto;
import com.springboot.java_eco.data.dto.equipment.EquipmentDto;
import com.springboot.java_eco.data.entity.Equipment;

import java.util.List;
import java.util.Map;


public interface EquipmentDAO {
    Equipment insertEquipment(EquipmentDto equipmentDto);

    List<Equipment> selectTotalEquipment(CommonSearchDto commonSearchDto);
    List<Equipment> selectEquipment(CommonSearchDto commonSearchDto);

    Equipment updateEquipment(EquipmentDto equipmentDto) throws Exception;

    String deleteEquipment(List<Long> uid) throws Exception;

    String excelUploadEquipment(List<Map<String, Object>> requestList) throws Exception;


}

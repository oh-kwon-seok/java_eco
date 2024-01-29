package com.springboot.java_eco.data.repository.car;

import com.springboot.java_eco.data.dto.car.CarSearchDto;
import com.springboot.java_eco.data.entity.Car;

import java.util.List;

public interface CarRepositoryCustom {
    List<Car> findAll(CarSearchDto carSearchDto);
    List<Car> findInfo(CarSearchDto carSearchDto);

}

package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.car.CarDto;
import com.springboot.java_eco.data.dto.car.CarSearchDto;
import com.springboot.java_eco.data.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<Car> getTotalCar(CarSearchDto carSearchDto);

    List<Car> getCar(CarSearchDto carSearchDto);


    Car saveCar(CarDto carDto) throws Exception;

    Car updateCar(CarDto carDto) throws Exception;

    void deleteCar(List<Long> uid) throws Exception;


}

package com.springboot.java_eco.data.repository.sensorRuntime;

import com.springboot.java_eco.data.entity.SensorRuntime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("sensorRuntimeRepositorySupport")
public interface SensorRuntimeRepository extends JpaRepository<SensorRuntime,Long>, SensorRuntimeRepositoryCustom {

    SensorRuntime findByUid(Long uid);


}

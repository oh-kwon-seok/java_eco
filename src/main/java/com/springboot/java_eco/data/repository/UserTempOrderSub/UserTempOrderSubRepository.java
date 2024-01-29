package com.springboot.java_eco.data.repository.UserTempOrderSub;

import com.springboot.java_eco.data.entity.UserTempOrderSub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userTempOrderSubRepositorySupport")
public interface UserTempOrderSubRepository extends JpaRepository<UserTempOrderSub,String>, UserTempOrderSubRepositoryCustom {


    List<UserTempOrderSub> findByUserTempOrderUid(Long uid);





}

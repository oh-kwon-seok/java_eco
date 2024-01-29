package com.springboot.java_eco.data.repository.UserOrder;


import com.springboot.java_eco.data.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userOrderRepositorySupport")
public interface UserOrderRepository extends JpaRepository<UserOrder,String>, UserOrderRepositoryCustom {

    UserOrder getById(String user_id);
    UserOrder findByUid(Long uid);

}

package com.springboot.java_eco.data.repository.User;

import com.springboot.java_eco.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepositorySupport")
public interface UserRepository extends JpaRepository<User,String>, UserRepositoryCustom {

    User getById(String id);
    User findByCodeAndPhone(String code, String phone);


}

package com.springboot.java_eco.data.repository.position;

import com.springboot.java_eco.data.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("positionRepositorySupport")
public interface PositionRepository extends JpaRepository<Position,Long>, PositionRepositoryCustom {

    Position findByUid(Long uid);
}

package com.springboot.java_eco.data.dao.impl;

import com.springboot.java_eco.data.dao.PositionDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.position.PositionDto;
import com.springboot.java_eco.data.entity.Position;
import com.springboot.java_eco.data.repository.position.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class PositionDAOImpl implements PositionDAO {

    private final PositionRepository positionRepository;
    @Autowired
    public PositionDAOImpl(PositionRepository positionRepository){
        this.positionRepository = positionRepository;

    }

    public Position insertPosition(PositionDto positionDto) {



        Position position = new Position();


        position.setName(positionDto.getName());
        position.setName2(positionDto.getName2());


        position.setUsed(Math.toIntExact(positionDto.getUsed()));

        position.setCreated(LocalDateTime.now());

        Position insertPosition = positionRepository.save(position);
        return insertPosition;

    }
    @Override
    public List<Position> selectTotalPosition(CommonSearchDto commonSearchDto) {
        return positionRepository.findAll(commonSearchDto);

    }

    @Override
    public List<Position> selectPosition(CommonSearchDto commonSearchDto) {
        return positionRepository.findInfo(commonSearchDto);

    }


    @Override
    public Position updatePosition(PositionDto positionDto) throws Exception {


        Optional<Position> selectedPosition = positionRepository.findById(positionDto.getUid());

        Position updatedPosition;

        if (selectedPosition.isPresent()) {
            Position position = selectedPosition.get();


            position.setName(positionDto.getName());
            position.setName2(positionDto.getName2());

            position.setUsed(Math.toIntExact(positionDto.getUsed()));

            position.setUpdated(LocalDateTime.now());
            updatedPosition = positionRepository.save(position);
        } else {
            throw new Exception();
        }
        return updatedPosition;
    }
    @Override
    public String deletePosition(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Position> selectedPosition = positionRepository.findById(uid);
            if (selectedPosition.isPresent()) {
                Position position = selectedPosition.get();
                position.setUsed(0);
                position.setDeleted(LocalDateTime.now());
                positionRepository.save(position);
            } else {
                throw new Exception("Position with UID " + uid + " not found.");
            }
        }
        return "Positions deleted successfully";
    }
}

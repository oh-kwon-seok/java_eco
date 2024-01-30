package com.springboot.java_eco.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.position.PositionDto;
import com.springboot.java_eco.data.entity.Position;
import com.springboot.java_eco.service.PositionService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/position")
@Controller
public class PositionController {
    private final PositionService positionService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(PositionController.class);

    @Autowired
    public PositionController(PositionService positionService){
        this.positionService = positionService;
    }

    @GetMapping(value= "/select")
    public ResponseEntity<List<Position>> getTotalPosition(@ModelAttribute CommonSearchDto commonSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Position> selectedTotalPosition = positionService.getTotalPosition(commonSearchDto);

        LOGGER.info("[getTotalPosition] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalPosition);

    }
    @GetMapping(value= "/info_select")
    public ResponseEntity<List<Position>> getPosition(@ModelAttribute CommonSearchDto commonSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Position> selectedTotalPosition = positionService.getPosition(commonSearchDto);

        LOGGER.info("[getTotalPosition] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalPosition);

    }

    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Position> createPosition(@RequestBody PositionDto positionDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[positionDto]  : {}", positionDto);
        Position insertPosition = positionService.savePosition(positionDto);
        LOGGER.info("[createPosition] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return ResponseEntity.status(HttpStatus.OK).body(insertPosition);
    }
    @PostMapping(value= "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Position> updatePosition(@RequestBody PositionDto positionDto)
            throws Exception{

        Position updatePosition = positionService.updatePosition(positionDto);
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[positionDto]  : {}", positionDto);

        LOGGER.info("[updatePosition] response Time : {}ms", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(updatePosition);
    }
    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deletePosition(@RequestBody Map<String, List<Long>> requestMap) throws Exception {
        List<Long> uid = requestMap.get("uid");
        positionService.deletePosition(uid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}

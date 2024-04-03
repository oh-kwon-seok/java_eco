package com.springboot.java_eco.controller;

import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.bom.BomDto;
import com.springboot.java_eco.data.entity.Bom;
import com.springboot.java_eco.service.BomService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bom")
@Controller
public class BomController {
    private final BomService bomService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(BomController.class);

    @Autowired
    public BomController(BomService bomService){
        this.bomService = bomService;
    }

    @GetMapping(value= "/select")
    public ResponseEntity<List<Bom>> getTotalBom(@ModelAttribute CommonSearchDto commonSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Bom> selectedTotalBom = bomService.getTotalBom(commonSearchDto);

        LOGGER.info("[getTotalBom] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalBom);

    }
    @GetMapping(value= "/info_select")
    public ResponseEntity<List<Bom>> getBom(@ModelAttribute CommonSearchDto commonSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Bom> selectedTotalBom = bomService.getBom(commonSearchDto);

        LOGGER.info("[getTotalBom] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalBom);

    }

    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public CommonResultDto createBom(@RequestBody BomDto bomDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[bomDto]  : {}", bomDto);
        CommonResultDto bomResultDto = bomService.saveBom(bomDto);
        LOGGER.info("[createBom] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return bomResultDto;
    }
    @PostMapping(value= "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Bom> updateBom(@RequestBody BomDto bomDto)
            throws Exception{

        Bom updateBom = bomService.updateBom(bomDto);
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[bomDto]  : {}", bomDto);

        LOGGER.info("[updateBom] response Time : {}ms", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(updateBom);
    }
    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deleteBom(@RequestBody Map<String, List<Long>> requestMap) throws Exception {
        List<Long> uid = requestMap.get("uid");
        bomService.deleteBom(uid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
//    @PostMapping(value= "/excel_upload", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<String> excelUploadUser(@RequestBody Map<String, List<Map<String, Object>>> requestMap) throws Exception {
//        List<Map<String, Object>> requestList = requestMap.get("data");
//        LOGGER.info("LIST : {}",requestList);
//
//        bomService.excelUploadBom(requestList);
//        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
//    }
}

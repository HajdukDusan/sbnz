package com.example.MusicRecc.controller;

import java.util.ArrayList;

import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.service.PesmeService;
import com.example.MusicRecc.service.ReportService;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import antlr.collections.Enumerator;

@RestController
@AllArgsConstructor
@RequestMapping("/report")
public class ReportController {


    private static Logger log = LoggerFactory.getLogger(ReportController.class);

    private ReportService reportService;

    private PesmeService pesmeService;


//    @RequestMapping(value = "/item", method = RequestMethod.GET, produces = "application/json")
//    public Item getQuestions(@RequestParam(required = false) String id, @RequestParam(required = false) String name,
//                             @RequestParam(required = false) double cost, @RequestParam(required = false) double salePrice) {
//
//        Item newItem = new Item(Long.parseLong(id), name, cost, salePrice);
//
//        log.debug("Item request received for: " + newItem);
//
//        Item i2 = reportService.getClassifiedItem(newItem);
//        System.out.println("AAAAAA"  + newItem.toString());
//        return i2;
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> test(@PathVariable Long id){
        return new ResponseEntity<Pesma>(reportService.calculateSongScore(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> testAll(){
        return new ResponseEntity<Object>(reportService.calculateAllSongScore(), HttpStatus.OK);
    }

    @GetMapping("/recommendation")
    public ResponseEntity<?> testRecommendation(){
        return new ResponseEntity<Object>(pesmeService.calculateAllSongsRecommendation(), HttpStatus.OK);
    }

    @GetMapping("/popularity")
    public void popularity(){
        reportService.popularitySongs();
    }

}

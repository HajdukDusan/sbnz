package com.example.MusicRecc.controller;

import com.example.MusicRecc.service.ReportService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/report")
public class ReportController {


    private static Logger log = LoggerFactory.getLogger(ReportController.class);

    private ReportService reportService;


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
    public void test(@PathVariable Long id){
        reportService.calculateSongScore(id);
    }
    @GetMapping("/all")
    public void testAll(){
        reportService.calculateAllSongScore();
    }
}

package com.example.MusicRecc.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.service.PesmeService;
import com.example.MusicRecc.service.ReportService;
import lombok.AllArgsConstructor;

import org.apache.tomcat.util.http.parser.HttpParser;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> test(@PathVariable Long id){
        return new ResponseEntity<Pesma>(reportService.calculateSongScore(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> testAll(){
        return new ResponseEntity<Object>(reportService.calculateAllSongScore(), HttpStatus.OK);
    }
    @GetMapping("/all/date")
    public ResponseEntity<?> testAllDate(){
        return new ResponseEntity<>(reportService.calculateAllSongScoreDate(), HttpStatus.OK);
    }
    @GetMapping("/recommendation")
    public ResponseEntity<?> testRecommendation(){
        return new ResponseEntity<Object>(pesmeService.calculateAllSongsRecommendation(), HttpStatus.OK);
    }

    @GetMapping("/allSongs")
    public ResponseEntity<List<Pesma>> getAllSong() {
        return new ResponseEntity<List<Pesma>>(pesmeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/popularity")
    public void popularity(){
        reportService.popularitySongs();
    }

    @GetMapping("/template")
    public ResponseEntity<List<Pesma>> template_test(){
        return new ResponseEntity<>(pesmeService.template_test(),HttpStatus.OK);
    }
}

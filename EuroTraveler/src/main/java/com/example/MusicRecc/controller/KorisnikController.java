package com.example.MusicRecc.controller;

import com.example.MusicRecc.model.Korisnik;
import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.service.KorisnikService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/korisnik")
public class KorisnikController {


    private KorisnikService korisnikService;

    @GetMapping("/{id}")
    public void korisnikFavoriteSongs(@PathVariable Long id){
        korisnikService.korisnikCalculateFavoriteSongs(id);
//        return new ResponseEntity<Korisnik>(korisnikService.korisnikCalculateFavoriteSongs(id), HttpStatus.OK);
    }
}

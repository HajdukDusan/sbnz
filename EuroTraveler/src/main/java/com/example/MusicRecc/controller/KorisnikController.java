package com.example.MusicRecc.controller;

import com.example.MusicRecc.dto.KorisnikPesmaDTO;
import com.example.MusicRecc.dto.KorisnikSlusanjeDTO;
import com.example.MusicRecc.model.Korisnik;
import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.service.KorisnikService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/korisnik")
public class KorisnikController {


    private KorisnikService korisnikService;
    private ModelMapper modelMapper;
    @GetMapping("/{id}")
    public void korisnikFavoriteSongs(@PathVariable Long id) throws Exception {
        korisnikService.korisnikCalculateFavoriteSongs(id);
//        return new ResponseEntity<Korisnik>(korisnikService.korisnikCalculateFavoriteSongs(id), HttpStatus.OK);
    }

    @GetMapping("/rate/{id}")
    public void korisnikRate(@PathVariable Long id){
        korisnikService.rateSong(id);
    }

    @GetMapping("/slusanja/{id}")
    public List<KorisnikPesmaDTO> slusanja(@PathVariable Long id){
        return korisnikService.korisnikFavoriteSongsSlusanje(id);
    }

    @GetMapping("/slusanja/all")
    public void slusanja(){
        korisnikService.calculateAllKorisnikSlusanje();
    }

    @GetMapping("/all")
    public void korisnikFavoriteSongs() throws Exception {
        korisnikService.korisnikCalculateFavoriteSongs(1L);
//        return new ResponseEntity<Korisnik>(korisnikService.korisnikCalculateFavoriteSongs(id), HttpStatus.OK);
    }
    @GetMapping("/simular/{id}")
    public List<KorisnikPesmaDTO> simularKorisnici(@PathVariable Long id){
//        return korisnikService.findSimularUsers(id);
        return korisnikService.findSimularUsers(id).stream().map(korisnik -> modelMapper.map(korisnik, KorisnikPesmaDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/songs/{id}")
    public Set<Pesma> simularSongsUserKorisnici(@PathVariable Long id) throws Exception {
        List<Korisnik> korisnici =  korisnikService.findSimularUsers(id);
        return korisnikService.findKorisnikSongReccomendation(id,korisnici);
    }
}

package com.example.MusicRecc.controller;

import com.example.MusicRecc.dto.*;
import com.example.MusicRecc.model.Korisnik;
import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.service.KorisnikService;
import com.example.MusicRecc.service.PesmeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/korisnik")
public class KorisnikController {

    private KorisnikService korisnikService;
    private PesmeService pesmeService;
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public void korisnikFavoriteSongs(@PathVariable Long id) throws Exception {
        korisnikService.korisnikCalculateFavoriteSongs(id);
        // return new
        // ResponseEntity<Korisnik>(korisnikService.korisnikCalculateFavoriteSongs(id),
        // HttpStatus.OK);
    }

    @GetMapping("/rate/{idKorisnik}/{idPesma}/{grade}")
    public void korisnikRate(@PathVariable Long idKorisnik, @PathVariable Long idPesma, @PathVariable Integer grade) {
        korisnikService.rateSong(idKorisnik, idPesma, grade);
    }

    @GetMapping("/slusanja/{id}")
    public List<KorisnikPesmaDTO> slusanja(@PathVariable Long id) {
        return korisnikService.korisnikFavoriteSongsSlusanje(id);
    }

    @GetMapping("/slusanja/all")
    public void slusanja() {
        korisnikService.calculateAllKorisnikSlusanje();
    }

    @GetMapping("/get/all")
    public List<KorisnikDTO> getAllKorisnik() {
        return korisnikService.findAll();
    }

    @GetMapping("/get/{id}")
    public KorisnikDTO getAllKorisnik(@PathVariable Long id) throws Exception {
        return korisnikService.findById(id);
    }

    @GetMapping("/all")
    public void korisnikFavoriteSongs() throws Exception {
        korisnikService.korisnikCalculateFavoriteSongs(1L);
    }

    @GetMapping("/simular/{id}")
    public List<KorisnikPesmaDTO> simularKorisnici(@PathVariable Long id) {
        return korisnikService.findSimularUsersDTO(id);
    }
    @GetMapping("/refresh")
    public void refreshKorisnik(){
        korisnikService.refreshKorisnike();
    }
    @GetMapping("/songs/{id}")
    public Set<Pesma> simularSongsUserKorisnici(@PathVariable Long id)
            throws Exception {
        List<Korisnik> korisnici = korisnikService.findSimularUsers(id);
        return korisnikService.findKorisnikSongReccomendation(id, korisnici);
    }
    @PostMapping("/songs/{id}")
    public Set<Pesma> simularSongsUserKorisniciQuery(@PathVariable Long id, @RequestBody SearchDTO searchDto)
            throws Exception {
        List<Korisnik> korisnici = korisnikService.findSimularUsers(id);
        Set<Pesma> pesme = korisnikService.findKorisnikSongReccomendation(id, korisnici);
        pesme = pesmeService.filter_pesme(pesme,searchDto);
        return pesme;
    }
}

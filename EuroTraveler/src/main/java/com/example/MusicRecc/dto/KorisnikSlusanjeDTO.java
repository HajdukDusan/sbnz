package com.example.MusicRecc.dto;


import com.example.MusicRecc.model.Korisnik;
import com.example.MusicRecc.model.Pesma;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KorisnikSlusanjeDTO {


    private Integer slusanja;

    @JsonIgnore
    private Pesma pesmaSlusanja;

    @JsonIgnore
    private Korisnik korisnik;
}

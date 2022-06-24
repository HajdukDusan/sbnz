package com.example.MusicRecc.dto;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.example.MusicRecc.model.Ocena;
import com.example.MusicRecc.model.Osobina;
import com.example.MusicRecc.model.Slusanje;
import com.example.MusicRecc.model.Zanr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PesmaDTO {

    protected Long id;

    protected Long duzina;

    private String naziv;

//    private Long izvodjac;
//
//    private List<Zanr> zanroviPesma;
//
//    private List<Ocena> ocene;
//
//    protected Date datumIzlaska;
//
//    private List<Slusanje> slusanja;

    protected BigInteger brojSlusanja;

//    private double points;
//
//    private double averageOcena;
//
//    protected Set<Osobina> osobine;
}

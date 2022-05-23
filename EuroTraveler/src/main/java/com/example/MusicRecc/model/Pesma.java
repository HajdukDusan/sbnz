package com.example.MusicRecc.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pesma {

    @Id
    @SequenceGenerator(name = "PesmaSeqGen", sequenceName = "PesmaSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PesmaSeqGen")
    protected Long id;

    @Column
    protected Long duzina;
    @Column
    private String naziv;
//    @Column
//    protected Izvodjac izvodjac;
//    @Column
//    protected List<String> zanrovi;
//    @Column
//    protected List<Integer> ocene;
//    @Column
//    protected Date datumIzlaska;
//    @Column
//    protected BigInteger brojSlusanja;
//    @Column
//    protected List<String> osobine;
}

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
public class Slusanje {

    @Id
    @SequenceGenerator(name = "SlusanjeSeqGen", sequenceName = "SlusanjeSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SlusanjeSeqGen")
    protected Long id;

    @Column
    protected Date datumSlusanja;

//    @Column
//    protected Pesma pesma;
//    @Column
//    protected Korisnik korisnik;
}
package com.example.MusicRecc.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
    protected LocalDateTime datumSlusanja;



    private Long pesma;

    private Long korisnik;
}
package com.example.model;

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
public class Izvodjac {

    @Id
    @SequenceGenerator(name = "IzvodjacSeqGen", sequenceName = "IzvodjacSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IzvodjacSeqGen")
    protected Long id;

    @Column
    protected String Ime;
    @Column
    protected List<Pesma> pesme;
    @Column
    protected List<String> zanrovi;
}

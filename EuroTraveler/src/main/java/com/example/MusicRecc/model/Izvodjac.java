package com.example.MusicRecc.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
//    @OneToMany
//    protected List<Pesma> pesme;
//    @ManyToMany
//    private List<String> zanrovi;
}

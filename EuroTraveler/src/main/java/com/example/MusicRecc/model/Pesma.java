package com.example.MusicRecc.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
public class Pesma {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected Long duzina;
    @Column
    private String naziv;

    private Long izvodjac;
    @ManyToMany(fetch =FetchType.EAGER)
    @JoinTable(name = "pesma_zanr",
            joinColumns = @JoinColumn(name = "pesma_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "zanr_id", referencedColumnName = "id"))
    private List<Zanr> zanroviPesma;


    @OneToMany(mappedBy="pesma")
    private List<Ocena> ocene;

    protected Date datumIzlaska;


    @OneToMany(mappedBy = "pesmaSlusanja")
    private List<Slusanje> slusanja;

    protected BigInteger brojSlusanja;

    @Column
    private double points;

    @Column
    private double averageOcena;

    @ManyToMany(fetch =FetchType.EAGER)
    @JoinTable(name = "pesma_osobina",
            joinColumns = @JoinColumn(name = "pesma_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "osobina_id", referencedColumnName = "id"))
    protected Set<Osobina> osobine;
}

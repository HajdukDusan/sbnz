package com.example.MusicRecc.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Izvodjac {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected String Ime;
    @OneToMany
    protected List<Pesma> pesme;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "izvodjac_zanr",
            joinColumns = @JoinColumn(name = "izvodjac_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "zanr_id", referencedColumnName = "id"))
    private Set<Zanr> zanrovi;

}

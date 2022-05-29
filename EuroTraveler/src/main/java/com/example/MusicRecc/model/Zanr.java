package com.example.MusicRecc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Zanr {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String naziv;

    @ManyToMany(mappedBy = "zanrovi", fetch = FetchType.LAZY)
    private Set<Izvodjac> izvodjaci;

    @ManyToMany(mappedBy = "zanroviPesma", fetch = FetchType.LAZY)
    private Set<Pesma> pesme;
}

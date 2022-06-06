package com.example.MusicRecc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ocena {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="korisnik_id", nullable=false)
    private Korisnik korisnik;

    @ManyToOne
    @JoinColumn(name="pesma_id", nullable=false)
    private Pesma pesma;

    private Integer ocena;

}

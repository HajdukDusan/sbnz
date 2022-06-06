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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected LocalDateTime datumSlusanja;

    @ManyToOne
    @JoinColumn(name="pesma_id")
    private Pesma pesmaSlusanja;
    @ManyToOne
    @JoinColumn(name="korisnik_id")
    private Korisnik korisnik;
}
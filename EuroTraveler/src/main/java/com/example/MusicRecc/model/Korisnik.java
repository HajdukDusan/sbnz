package com.example.MusicRecc.model;

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
public class Korisnik {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(unique = true)
    protected String username;
    @Column
    protected String password;
    @Column
    protected String email;

    @OneToMany(mappedBy = "korisnik")
    protected List<Slusanje> istorijaSlusanja;

    @OneToMany(mappedBy = "korisnik")
    protected List<Ocena> istorijaOcena;
}
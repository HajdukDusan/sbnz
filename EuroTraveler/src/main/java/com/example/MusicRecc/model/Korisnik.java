package com.example.MusicRecc.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "korisnik_pesma",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pesma_id", referencedColumnName = "id"))
    protected Set<Pesma> omiljenePesme;
}
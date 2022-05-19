package com.example.model;

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
public class Korisnik {

    @Id
    @SequenceGenerator(name = "KorisnikSeqGen", sequenceName = "KorisnikSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KorisnikSeqGen")
    protected Long id;

    @Column(unique = true)
    protected String username;
    @Column
    protected String password;
    @Column
    protected String email;

    @Column
    protected List<Slusanje> istorijaSlusanja;

    @Column 
    protected List<Integer> istorijaOcena;
}
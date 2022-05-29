package com.example.MusicRecc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ocena {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private Long korisnik;

    private Long pesma;
    private Integer ocena;

}

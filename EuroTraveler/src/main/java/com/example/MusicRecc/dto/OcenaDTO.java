package com.example.MusicRecc.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OcenaDTO {

    private Long id;

    private Long korisnik;

    private Long pesma;

    private Integer ocena;

}

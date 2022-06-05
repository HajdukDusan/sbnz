package com.example.MusicRecc.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.example.MusicRecc.model.Izvodjac;
import com.example.MusicRecc.model.Pesma;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ZanrDTO {

    private Long id;

    private String naziv;

    private Set<Izvodjac> izvodjaci;

    private Set<Pesma> pesme;
}

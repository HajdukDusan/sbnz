package com.example.MusicRecc.dto;

import javax.persistence.*;

import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.model.Zanr;

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
public class IzvodjacDTO {

    protected Long id;

    protected String Ime;

    protected List<Pesma> pesme;

    private Set<Zanr> zanrovi;

}

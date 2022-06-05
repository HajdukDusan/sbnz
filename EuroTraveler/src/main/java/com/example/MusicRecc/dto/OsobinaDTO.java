package com.example.MusicRecc.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.example.MusicRecc.model.Pesma;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OsobinaDTO {

    private Long id;

    private String naziv;

    private List<Pesma> pesme;
}

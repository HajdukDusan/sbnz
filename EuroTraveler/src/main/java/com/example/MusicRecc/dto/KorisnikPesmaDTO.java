package com.example.MusicRecc.dto;


import com.example.MusicRecc.model.Pesma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KorisnikPesmaDTO {

    private String naziv;
    private String username;
    private Long id;
    private Integer simularity;
}

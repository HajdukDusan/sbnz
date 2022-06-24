package com.example.MusicRecc.dto;

import java.util.List;

import javax.persistence.*;

import com.example.MusicRecc.model.Ocena;
import com.example.MusicRecc.model.Slusanje;
import com.example.MusicRecc.model.Zanr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KorisnikDTO {

    protected Long id;

    protected String username;

    protected String password;

    protected String email;

    protected List<Slusanje> istorijaSlusanja;

    protected List<Ocena> istorijaOcena;

    protected List<Zanr> omiljeniZanrovi;

    private List<PesmaDTO> omiljenePesme;
}
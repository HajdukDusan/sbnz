package com.example.MusicRecc.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.example.MusicRecc.model.Pesma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlusanjeDTO {

    protected Long id;

    protected LocalDateTime datumSlusanja;

    private Pesma pesma;

    private Long pesmaSlusanja;

    private Long korisnik;
}
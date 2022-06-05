package com.example.MusicRecc.service;

import com.example.MusicRecc.dto.KorisnikDTO;
import com.example.MusicRecc.dto.PesmaDTO;
import com.example.MusicRecc.model.Korisnik;
import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.repository.KorisnikRepository;
import com.example.MusicRecc.repository.PesmaRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PesmeService {

    private final KieContainer kieContainer;

    private final ModelMapper modelMapper;

    private final PesmaRepository pesmaRepository;

    private final KorisnikRepository korisnikRepository;

    public List<Pesma> calculateAllSongsRecommendation() {
        List<Pesma> pesme = pesmaRepository.findAll();
        List<Korisnik> korisnici = korisnikRepository.findAll();

        KieSession kieSession = kieContainer.newKieSession();

        kieSession.getAgenda().getAgendaGroup("recommendation_score").setFocus();

        for(Pesma pesma: pesme){
            kieSession.insert(modelMapper.map(pesma, PesmaDTO.class));
        }
        for(Korisnik korisnik: korisnici){
            kieSession.insert(modelMapper.map(korisnik, KorisnikDTO.class));
        }

        kieSession.fireAllRules();
        kieSession.dispose();

        korisnikRepository.saveAll(korisnici);
        pesmaRepository.saveAll(pesme);
        return pesme;
    }
}

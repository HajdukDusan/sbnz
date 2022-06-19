package com.example.MusicRecc.service;

import com.example.MusicRecc.dto.KorisnikDTO;
import com.example.MusicRecc.dto.PesmaDTO;
import com.example.MusicRecc.dto.SearchDTO;
import com.example.MusicRecc.model.Korisnik;
import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.repository.KorisnikRepository;
import com.example.MusicRecc.repository.PesmaRepository;
import lombok.AllArgsConstructor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import org.kie.internal.utils.KieHelper;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PesmeService {

    private final KieContainer kieContainer;
    private final KnowledgeService knowledgeService;
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

    public List<Pesma> template_test(){
        List<Pesma> result = new ArrayList<>();
        List<Pesma> pesme = pesmaRepository.findAll();


        InputStream template = PesmeService.class.getResourceAsStream("/sbnz/integracija/template/search.drt");
        ObjectDataCompiler converter = new ObjectDataCompiler();
        List<SearchDTO> data = new ArrayList<>();
        SearchDTO searchDTO = new SearchDTO("radiohead");
        data.add(searchDTO);
        String drl = converter.compile(data, template);

        KieSession kieSession = knowledgeService.createKieSessionFromDRL(drl);

        for(Pesma pesma: pesme){
            kieSession.insert(pesma);
        }
        kieSession.setGlobal("result", result);
        kieSession.fireAllRules();
        return result;
    }
}

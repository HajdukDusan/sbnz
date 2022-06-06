package com.example.MusicRecc.service;

import com.example.MusicRecc.event.RatingEvent;
import com.example.MusicRecc.model.Korisnik;
import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.repository.KorisnikRepository;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KorisnikService {
    private final KnowledgeService knowledgeService;

    private final ModelMapper modelMapper;

    private KorisnikRepository korisnikRepository;

    public void korisnikCalculateFavoriteSongs(Long id) {
        Korisnik korisnik = korisnikRepository.findById(id).get();
        KieSession kieSession = knowledgeService.getRulesSession();
        kieSession.getAgenda().getAgendaGroup("korisnik_rules").setFocus();
        kieSession.insert(korisnik);
        kieSession.fireAllRules();
        kieSession.dispose();
        korisnikRepository.save(korisnik);
//        return korisnik;
    }


    public void rateSong(Long id) {
        KieSession kieSession = knowledgeService.getEventsSession();
        kieSession.insert(new RatingEvent(id));
        kieSession.fireAllRules();
    }
}

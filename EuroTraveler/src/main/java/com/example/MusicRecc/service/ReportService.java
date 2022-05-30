package com.example.MusicRecc.service;

import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.repository.PesmaRepository;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReportService {

//    private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

    private final KieContainer kieContainer;

    private final PesmaRepository pesmaRepository;

//    public Integer userRatings(Long pesmaId){
//        KieSession kieSession = kieContainer.newKieSession();
//        kieSession.insert(pesmaRepository.findById(pesmaId));
//        kieSession.fireAllRules();
//        kieSession.dispose();
//        return i;
//    }
    public void calculateSongScore(Long id) {
        Pesma pesma = pesmaRepository.getById(id);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("song_score").setFocus();
        kieSession.insert(pesma);
        kieSession.fireAllRules();
        kieSession.dispose();
        pesmaRepository.save(pesma);

    }
}

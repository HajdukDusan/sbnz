package com.example.MusicRecc.service;

import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.repository.PesmaRepository;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {

    // private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

    private final KieContainer kieContainer;

    private final KnowledgeService knowledgeService;
    private final PesmaRepository pesmaRepository;

    // public Integer userRatings(Long pesmaId){
    // KieSession kieSession = kieContainer.newKieSession();
    // kieSession.insert(pesmaRepository.findById(pesmaId));
    // kieSession.fireAllRules();
    // kieSession.dispose();
    // return i;
    // }
    public Pesma calculateSongScore(Long id) {
        Pesma pesma = pesmaRepository.findById(id).get();
        KieSession kieSession = knowledgeService.getRulesSession();
        kieSession.getAgenda().getAgendaGroup("song_score").setFocus();
        kieSession.insert(pesma);
        kieSession.fireAllRules();
        kieSession.dispose();
        pesmaRepository.save(pesma);
        return pesma;
    }

    public List<Pesma> calculateAllSongScore() {
        List<Pesma> pesme = pesmaRepository.findAll();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("song_score").setFocus();
        for (Pesma pesma : pesme) {
            kieSession.insert(pesma);
        }
        kieSession.fireAllRules();
        kieSession.dispose();
        pesmaRepository.saveAll(pesme);
        return popularitySongs();
    }

    public List<Pesma> calculateAllSongScoreDate(Date fromDate) {

        LocalDateTime localDateTime = Instant.ofEpochMilli(fromDate.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        List<Pesma> pesme = pesmaRepository.findAll();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("song_score").setFocus();

        kieSession.insert(localDateTime);
        for (Pesma pesma : pesme) {
            kieSession.insert(pesma);
        }
        kieSession.fireAllRules();
        kieSession.dispose();
        pesmaRepository.saveAll(pesme);

        return popularitySongs();
    }

    public List<Pesma> popularitySongs() {
        List<Pesma> pesme = pesmaRepository.findAll();
        List<Pesma> rankedSongs = new ArrayList<Pesma>();

        KieSession kieSession = knowledgeService.getRulesSession();
        kieSession.getAgenda().getAgendaGroup("popularity").setFocus();
        kieSession.setGlobal("songs", rankedSongs);
        for (Pesma pesma : pesme) {
            kieSession.insert(pesma);
        }
        kieSession.fireAllRules();
        kieSession.dispose();

        return rankedSongs;
    }
}

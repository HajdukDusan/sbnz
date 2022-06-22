package com.example.MusicRecc.service;

import com.example.MusicRecc.dto.KorisnikDTO;
import com.example.MusicRecc.dto.KorisnikPesmaDTO;
import com.example.MusicRecc.dto.KorisnikSlusanjeDTO;
import com.example.MusicRecc.event.RatingEvent;
import com.example.MusicRecc.model.Korisnik;
import com.example.MusicRecc.model.Pesma;
import com.example.MusicRecc.model.Slusanje;
import com.example.MusicRecc.repository.KorisnikRepository;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KorisnikService {
    private final KnowledgeService knowledgeService;

    private final ModelMapper modelMapper;

    private KorisnikRepository korisnikRepository;


    public static HashMap<Long, Integer> sortByValue(Map<Long, Integer> map) {

        List<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        LinkedHashMap<Long, Integer> sortedMap = new LinkedHashMap<>();
        list.forEach(e -> sortedMap.put(e.getKey(), e.getValue()));
        return sortedMap;
    }

    public List<KorisnikSlusanjeDTO> calculateKorisnikSlusanja(Korisnik korisnik){
        List<Slusanje> slusanjeList = korisnik.getIstorijaSlusanja();
        Map<Pesma,KorisnikSlusanjeDTO> pesmaSlusanjeMap = new HashMap();
        for (Slusanje slusanje: slusanjeList){
            Pesma pesma = slusanje.getPesmaSlusanja();
            if(pesmaSlusanjeMap.containsKey(pesma)){
                KorisnikSlusanjeDTO slusanjeDTO = pesmaSlusanjeMap.get(pesma);
                slusanjeDTO.setSlusanja(slusanjeDTO.getSlusanja() + 1);
                pesmaSlusanjeMap.put(pesma,slusanjeDTO);
            }
            else{
                pesmaSlusanjeMap.put(pesma,new KorisnikSlusanjeDTO(1, pesma, korisnik));
            }
        }
        return new ArrayList<>(pesmaSlusanjeMap.values());
    }

    public void calculateAllKorisnikSlusanje(){
        List<Korisnik> korisnici = korisnikRepository.findAll();
        for(Korisnik korisnik: korisnici){
            korisnikFavoriteSongsSlusanje(korisnik.getId());
        }
    }


    public List<KorisnikPesmaDTO> korisnikFavoriteSongsSlusanje(Long id){
        Korisnik korisnik = korisnikRepository.findById(id).get();
        List<KorisnikSlusanjeDTO> slusanjeDTOS = calculateKorisnikSlusanja(korisnik);
        Set<Pesma> favoritePesme = new HashSet<>();
        KieSession kieSession = knowledgeService.getRulesSession();
        kieSession.getAgenda().getAgendaGroup("slusanje_rules").setFocus();
        for(KorisnikSlusanjeDTO slusanjeDTO: slusanjeDTOS){
            kieSession.insert(slusanjeDTO);
        }
        kieSession.insert(korisnik);
        kieSession.setGlobal("favoritePesme",favoritePesme);
        kieSession.fireAllRules();
        kieSession.dispose();
        List<KorisnikPesmaDTO> pesmaDTOS =korisnik.getOmiljenePesme().stream().map(pesma -> modelMapper.map(pesma, KorisnikPesmaDTO.class))
                .collect(Collectors.toList());


        korisnikRepository.save(korisnik);
        return pesmaDTOS;

    }
    public void korisnikCalculateFavoriteSongs(Long id) throws Exception {
        if(korisnikRepository.findById(id).isEmpty()){
            throw new Exception();
        }
        List<Korisnik> korisnici = korisnikRepository.findAll();

        KieSession kieSession = knowledgeService.getRulesSession();
        kieSession.getAgenda().getAgendaGroup("korisnik_rules").setFocus();
        for(Korisnik k : korisnici){
            kieSession.insert(k);
        }
        kieSession.fireAllRules();
        kieSession.dispose();


        korisnikRepository.saveAll(korisnici);
    }

    public List<Korisnik> findSimularUsers(Long id){

        Map<Long,Integer> simularityMap = new HashMap<>();

        KieSession kieSession = knowledgeService.getRulesSession();
        kieSession.getAgenda().getAgendaGroup("simularity_rules").setFocus();
        kieSession.setGlobal("userId",id);
        kieSession.setGlobal("simularityMap",simularityMap);

        List<Korisnik> korisnici = korisnikRepository.findAll();
        for(Korisnik k : korisnici){
            kieSession.insert(k);
        }

        kieSession.fireAllRules();
        kieSession.dispose();


        simularityMap = sortByValue(simularityMap);


        List<Korisnik> simularKorisnici = new ArrayList<>();

        for (Map.Entry<Long,Integer> pair : simularityMap.entrySet()) {
            if(korisnikRepository.findById(pair.getKey()).isPresent()){
                simularKorisnici.add(korisnikRepository.findById(pair.getKey()).get());
            }

        }
        return simularKorisnici;
    }
    public Set<Pesma> findKorisnikSongReccomendation(Long id,List<Korisnik> simularKorisnici) throws Exception {
        if(korisnikRepository.findById(id).isEmpty()){
            throw new Exception();
        }
        Korisnik targetKorisnik = korisnikRepository.findById(id).get();
        KieSession kieSession = knowledgeService.getRulesSession();
        kieSession.getAgenda().getAgendaGroup("simular_rules").setFocus();
        kieSession.setGlobal("userId",id);
        Set<Pesma> songs = new HashSet<>();
        kieSession.setGlobal("songReccomend",songs);
        kieSession.insert(targetKorisnik);
        for(Korisnik k: simularKorisnici){
            kieSession.insert(k);
        }
        kieSession.fireAllRules();
        kieSession.dispose();
        return songs;
    }
    public void rateSong(Long id) {
        KieSession kieSession = knowledgeService.getEventsSession();
        kieSession.insert(new RatingEvent(id));
        kieSession.fireAllRules();
    }

    public List<KorisnikDTO> findAll() {
        List<Korisnik> korisnici = korisnikRepository.findAll();
        return korisnici.stream().map(korisnik -> modelMapper.map(korisnik,KorisnikDTO.class)).collect(Collectors.toList());
    }
}

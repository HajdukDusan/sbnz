package com.example.MusicRecc.tests;

import com.example.MusicRecc.model.Ocena;
import com.example.MusicRecc.model.Pesma;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PesmeTest {



    private static KieContainer kieContainer;

    private static final String agenda = "song_score";

    private static List<Pesma> pesme = new ArrayList<>();


    @Before
    public void beforeClass() {
        KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz", "drools-spring-kjar", "0.0.1-SNAPSHOT"));

        Pesma p1 = new Pesma();
        p1.setId(1L);
        Pesma p2 = new Pesma();
        p2.setId(2L);
        Ocena o = new Ocena();
        o.setPesma(1L);
        o.setOcena(1);
        Ocena o1 = new Ocena();
        o.setPesma(1L);
        o.setOcena(1);
        Ocena o2 = new Ocena();
        o.setPesma(1L);
        o.setOcena(1);
    }
    @Test
    public void testScore(){
        KieBase kieBase = kieContainer.getKieBase();
        KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();

        Pesma p1 = pesme.get(0);
        Pesma p2 = pesme.get(1);

        System.out.println(kieSession.getFactCount());
        kieSession.insert(p1);
        kieSession.insert(p2);
        kieSession.fireAllRules();

//        assertEquals(0.7, e1.getPoints(), 0.01);
//        assertEquals(0.6, e2.getPoints(), 0.01);

        kieSession.dispose();
    }
}

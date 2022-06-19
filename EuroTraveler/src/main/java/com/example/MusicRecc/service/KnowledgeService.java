package com.example.MusicRecc.service;


import lombok.AllArgsConstructor;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeService {

    private final KieContainer kieContainer;
    private KieSession rulesSession;
    private KieSession eventsSession;


    public KnowledgeService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }


    public KieContainer getKieContainer() {
        return kieContainer;
    }

    public KieSession getRulesSession() {
        rulesSession = kieContainer.newKieSession();
        return rulesSession;
    }

    public void setRulesSession(KieSession kieSession) {
        this.rulesSession = kieSession;
    }

    public void releaseRulesSession(){
        this.rulesSession.dispose();
        this.rulesSession = null;
    }

    public KieSession getEventsSession() {
        if(eventsSession == null){
            eventsSession = kieContainer.newKieSession();
        }
        return eventsSession;
    }

    public void setEventsSession(KieSession kieSession) {
        this.eventsSession = kieSession;
    }
    public KieSession createKieSessionFromDRL(String drl) {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);

        Results results = kieHelper.verify();

        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)) {
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: " + message.getText());
            }

            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }

        return kieHelper.build().newKieSession();
    }

}
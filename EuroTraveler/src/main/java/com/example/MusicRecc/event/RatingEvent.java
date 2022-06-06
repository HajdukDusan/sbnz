package com.example.MusicRecc.event;


import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;


@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("2h30m")
@Getter
@Setter
public class RatingEvent implements Serializable{

    private static final long serialVersionUID = 1L;
    private Date executionTime;
    private Long korisnikId;
//    private Double totalAmount;

    public RatingEvent(Long korisnikId) {
        super();
        this.executionTime = new Date();
        this.korisnikId = korisnikId;
    }
}

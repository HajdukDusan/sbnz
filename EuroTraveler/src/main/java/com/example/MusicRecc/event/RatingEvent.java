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
@Expires("5m")
@Getter
@Setter
public class RatingEvent implements Serializable{

    private static final long serialVersionUID = 1L;
    private Date executionTime;
    private Long korisnikId;
    private Long pesmaId;
//    private Double totalAmount;

    public RatingEvent(Long korisnikId, Long pesmaId) {
        super();
        this.executionTime = new Date();
        this.korisnikId = korisnikId;
        this.pesmaId = pesmaId;
    }
}

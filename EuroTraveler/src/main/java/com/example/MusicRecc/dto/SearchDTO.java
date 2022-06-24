package com.example.MusicRecc.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchDTO {

    private String name;


    public SearchDTO() {
        // TODO Auto-generated constructor stub
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
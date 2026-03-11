package com.telemedicine.telemedicine_backend.dto;

import jakarta.validation.constraints.NotBlank;

public class SymptomRequestdto {

    @NotBlank(message = "Symptoms cannot not be blank")
    private String symptoms;

    public SymptomRequestdto(){}

    public SymptomRequestdto(String symptoms){
        this.symptoms = symptoms;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}

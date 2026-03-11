package com.telemedicine.telemedicine_backend.service;

import com.telemedicine.telemedicine_backend.dto.SymptomResponsedto;
import org.springframework.stereotype.Service;

@Service
public class SymptomService {

    public SymptomResponsedto analyzeSymptom(String symptoms){
        return new SymptomResponsedto("Symptoms Successfully Received","Unknown");
    }
}

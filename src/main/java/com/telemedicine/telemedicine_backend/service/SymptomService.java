package com.telemedicine.telemedicine_backend.service;

import com.telemedicine.telemedicine_backend.dto.AiAnalysisResponseDTO;
import com.telemedicine.telemedicine_backend.dto.SymptomResponsedto;
import com.telemedicine.telemedicine_backend.enums.SeverityLevel;
import org.springframework.stereotype.Service;

@Service
public class SymptomService {

    private final AiService aiService;
    private final SeverityService severityService;

    public SymptomService(AiService aiService, SeverityService severityService){
        this.aiService = aiService;
        this.severityService = severityService;
    }

    public SymptomResponsedto analyzeSymptom(String symptoms){
        AiAnalysisResponseDTO aiResult = aiService.aiSymptom(symptoms);
        SeverityLevel sevirityLevel = severityService.evaluateSeverity(symptoms);
        String message = "Possible condition: " + aiResult.getCondition() +"."+ " Advice: " + aiResult.getAdvice()+".";
        return new SymptomResponsedto(message,sevirityLevel.name());
    }
}

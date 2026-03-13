package com.telemedicine.telemedicine_backend.service;

import com.telemedicine.telemedicine_backend.enums.SeverityLevel;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SeverityService {

    private final Map<String, Integer> symptomScore = Map.ofEntries(
                    // moderate entries
                    Map.entry("vomit", 3),
                    Map.entry("high fever", 3),
                    Map.entry("severe headache", 3),
                    Map.entry("stomach pain", 3),
                    Map.entry("nausea", 3),
                    Map.entry("persistent cough", 3),
                    Map.entry("short fever", 3),
                    Map.entry("migraine", 3),
                    Map.entry("joint pain", 3),
                    Map.entry("muscle pain", 3),
                    Map.entry("ear pain", 3),
                    Map.entry("sinus pain", 3),
                    Map.entry("burning urination", 3),
                    Map.entry("abdominal discomfort", 3),
                    Map.entry("moderate dehydration", 3),
                    Map.entry("swelling", 3),
                    Map.entry("skin infection", 3),
                    Map.entry("inflamed throat", 3),
                    Map.entry("eye redness", 3),
                    Map.entry("frequent diarrhea", 3),
                    Map.entry("persistent dizziness", 3),
                    Map.entry("back pain", 3),

                    // mild entries
                    Map.entry("body pain", 1),
                    Map.entry("fatigue", 1),
                    Map.entry("cold", 1),
                    Map.entry("cough", 1),
                    Map.entry("runny nose", 1),
                    Map.entry("sneezing", 1),
                    Map.entry("mild headache", 1),
                    Map.entry("dry throat", 1),
                    Map.entry("itchy eyes", 1),
                    Map.entry("mild cough", 1),
                    Map.entry("slight fatigue", 1),
                    Map.entry("low appetite", 1),
                    Map.entry("minor rash", 1),
                    Map.entry("light dizziness", 1),
                    Map.entry("mild allergy", 1),
                    Map.entry("watery nose", 1),
                    Map.entry("minor throat irritation", 1),
                    Map.entry("mild stomach discomfort", 1),
                    Map.entry("sleepiness", 1),
                    Map.entry("light body ache", 1),
                    Map.entry("mild congestion", 1),
                    Map.entry("seasonal cold", 1)
    );

    public SeverityLevel evaluateSeverity(String symptoms) {
        String lower = symptoms.toLowerCase();

        // emergency override logic
        if(lower.contains("chest pain") ||
                lower.contains("difficulty breathing") ||
                lower.contains("unconscious") ||
                lower.contains("seizure") ||
                lower.contains("stroke symptoms") ||
                lower.contains("paralysis") ||
                lower.contains("cannot move") ||
                lower.contains("severe bleeding") ||
                lower.contains("internal bleeding") ||
                lower.contains("blood vomiting") ||
                lower.contains("vomiting blood") ||
                lower.contains("blackout") ||
                lower.contains("fainting repeatedly") ||
                lower.contains("severe burn") ||
                lower.contains("poisoning") ||
                lower.contains("allergic reaction") ||
                lower.contains("anaphylaxis") ||
                lower.contains("severe chest tightness") ||
                lower.contains("loss of vision") ||
                lower.contains("sudden confusion") ||
                lower.contains("head injury") ||
                lower.contains("skull injury") ||
                lower.contains("spinal injury")){
            return SeverityLevel.SEVERE;
        }

        int score = 0;

        for (Map.Entry<String, Integer> entry: symptomScore.entrySet()){
            if(lower.contains(entry.getKey()))
                score += entry.getValue();
        }

        if(score >= 7) return SeverityLevel.SEVERE;
        if(score >= 4 ) return SeverityLevel.MODERATE;

        return SeverityLevel.MILD;
        }
    }


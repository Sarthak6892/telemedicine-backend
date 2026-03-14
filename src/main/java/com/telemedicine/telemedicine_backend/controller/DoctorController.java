package com.telemedicine.telemedicine_backend.controller;

import com.telemedicine.telemedicine_backend.dto.ApiResponse;
import com.telemedicine.telemedicine_backend.entity.Doctors;
import com.telemedicine.telemedicine_backend.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Doctors>> addDoctor(@RequestBody Doctors doctors){
        Doctors savedoctor = doctorService.saveDoctors(doctors);
        ApiResponse<Doctors> response = new ApiResponse<>(true,savedoctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Doctors>>> getAllDoctors(){
        List<Doctors> doctors = doctorService.getAllDoctors();
        ApiResponse<List<Doctors>> response = new ApiResponse<>(true, doctors);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{specialization}")
    public ResponseEntity<ApiResponse<List<Doctors>>> getDoctorsBySpecialization(@PathVariable String specialization){
        List<Doctors> doctors = doctorService.getDoctorsBySpecialization(specialization);
        ApiResponse<List<Doctors>> response = new ApiResponse<>(true, doctors);
        return ResponseEntity.ok(response);
    }
}

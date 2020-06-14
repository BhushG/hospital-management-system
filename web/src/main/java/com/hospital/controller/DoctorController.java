package com.hospital.controller;

import com.hospital.model.Doctor;
import com.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/api/doctors")
    public List<Doctor> getDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/api/doctors/byName")
    public Doctor getDoctorByName(@RequestParam String name){
        return doctorService.findDoctorByName(name);
    }

    @GetMapping("/api/doctors/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable  int id){
        return doctorService.findDoctor(id);
    }



}

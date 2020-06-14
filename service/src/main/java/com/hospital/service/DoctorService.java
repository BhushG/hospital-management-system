package com.hospital.service;


import com.hospital.model.Doctor;
import com.hospital.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.print.Doc;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepo;

    @PostConstruct
    private void addData() {
        List<Doctor> doctors = Arrays.asList(new Doctor(1, "name1","spec1"),
                new Doctor(2, "name2","spec2"),
                new Doctor(3, "name3","spec3"));
        doctorRepo.saveAll(doctors);
    }


    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }


    public Optional<Doctor> findDoctor(int id) {
        return doctorRepo.findById(id);
    }


    public Doctor findDoctorByName(String name) {
        List<Doctor> thisDoctor = doctorRepo.findAll().stream().filter(doctor -> {
            return doctor.getName().equalsIgnoreCase(name);
        }).collect(Collectors.toList());
        if(thisDoctor.size() == 0)
            return null;
        else
            return thisDoctor.get(0);
    }


}

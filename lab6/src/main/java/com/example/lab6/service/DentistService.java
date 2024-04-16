package com.example.lab6.service;

import com.example.lab6.model.Dentist;
import com.example.lab6.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {
    private final DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    public Optional<Dentist> getDentistById(String id) {
        return dentistRepository.findById(id);
    }

    public Dentist saveDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    public void deleteDentist(String id) {
        dentistRepository.deleteById(id);
    }
}

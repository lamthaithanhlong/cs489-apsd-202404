package com.example.lab6.service;

import com.example.lab6.model.Surgery;
import com.example.lab6.repository.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {
    private final SurgeryRepository surgeryRepository;

    @Autowired
    public SurgeryService(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    public Optional<Surgery> getSurgeryById(String id) {
        return surgeryRepository.findById(id);
    }

    public Surgery saveSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    public void deleteSurgery(String id) {
        surgeryRepository.deleteById(id);
    }
}

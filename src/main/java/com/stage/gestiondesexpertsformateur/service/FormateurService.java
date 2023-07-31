package com.stage.gestiondesexpertsformateur.service;


import com.stage.gestiondesexpertsformateur.exception.UserNotFoundException;
import com.stage.gestiondesexpertsformateur.models.Formateur;
import com.stage.gestiondesexpertsformateur.repo.FormateurRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FormateurService {
    private final FormateurRepo formateurRepo;

    @Autowired
    public FormateurService(FormateurRepo formateurRepo) {
        this.formateurRepo = formateurRepo;
    }

    public Formateur addFormateur(Formateur formateur) {
        formateur.setFormateurCode(UUID.randomUUID().toString());
        return formateurRepo.save(formateur);
    }

    public List<Formateur> findAllFormateurs() {
        return formateurRepo.findAll();
    }

    public Formateur updateFormateur(Formateur formateur) {
        return formateurRepo.save(formateur);
    }

    public Formateur findFormateurById(Long id) {
        return formateurRepo.findFormateurById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteFormateur(Long id){
        formateurRepo.deleteFormateurById(id);
    }
}
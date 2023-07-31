package com.stage.gestiondesexpertsformateur.repo;

import com.stage.gestiondesexpertsformateur.models.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormateurRepo extends JpaRepository<Formateur, Long> {
    void deleteFormateurById(Long id);

    Optional<Formateur> findFormateurById(Long id);
}

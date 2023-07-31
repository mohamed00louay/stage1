package com.stage.gestiondesexpertsformateur.resource;


import com.stage.gestiondesexpertsformateur.models.Formateur;
import com.stage.gestiondesexpertsformateur.service.FormateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
public class FormateurResource {
    private final FormateurService formateurService;

    public FormateurResource(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Formateur>> getAllFormateurs () {
        List<Formateur> formateurs = formateurService.findAllFormateurs();
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Formateur> getFormateurById (@PathVariable("id") Long id) {
        Formateur formateur = formateurService.findFormateurById(id);
        return new ResponseEntity<>(formateur, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Formateur> addFormateur(@RequestBody Formateur formateur) {
        Formateur newFormateur = formateurService.addFormateur(formateur);
        return new ResponseEntity<>(newFormateur, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Formateur> updateFormateur(@RequestBody Formateur formateur) {
        Formateur updateFormateur = formateurService.updateFormateur(formateur);
        return new ResponseEntity<>(updateFormateur, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFormateur(@PathVariable("id") Long id) {
        formateurService.deleteFormateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

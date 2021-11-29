package br.com.forsales.controller;

import br.com.forsales.model.Candidate;
import br.com.forsales.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Class responsible for candidate rest end point
 *
 * Created by Diego Nascimento.
 */
@Controller
@RestController
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/candidate")
    public List<Candidate> getAllCandidates(){
        return candidateRepository.findAll();
    }


    @GetMapping("/candidate/{id}")
    public ResponseEntity<Candidate> getById(@PathVariable int id){
        Optional<Candidate> candidate = candidateRepository.findById(id);
        return candidate.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/candidate/save")
    public Candidate save(@Valid @RequestBody Candidate candidate){
        return candidateRepository.save(candidate);
    }

    @PutMapping(value = "/candidate/{id}")
    public ResponseEntity<Candidate> update(@PathVariable(value = "id") int id, @Valid @RequestBody Candidate newCandidate){
        final Optional<Candidate> oldCandidate = candidateRepository.findById(id);
        if(oldCandidate.isPresent()){
            final Candidate candidate = oldCandidate.get();
            candidate.setName(newCandidate.getName());
            candidate.setCreditCardList(newCandidate.getCreditCardList());
            candidateRepository.save(candidate);
            return new ResponseEntity<>(candidate, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/candidate/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if(candidate.isPresent()){
            candidateRepository.delete(candidate.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

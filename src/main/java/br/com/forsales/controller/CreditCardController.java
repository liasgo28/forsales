package br.com.forsales.controller;

import br.com.forsales.model.CreditCard;
import br.com.forsales.repositories.CreditCardRepository;
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
 * Class responsible for credit card rest end point
 *
 * Created by Diego Nascimento.
 */
@Controller
@RestController
public class CreditCardController {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @GetMapping("/creditcard")
    public List<CreditCard> getAll(){
        return creditCardRepository.findAll();
    }


    @GetMapping("/creditcard/{id}")
    public ResponseEntity<CreditCard> getById(@PathVariable int id){
        Optional<CreditCard> creditCard = creditCardRepository.findById(id);
        return creditCard.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/creditcard")
    public CreditCard save(@Valid @RequestBody CreditCard creditCard){
        return creditCardRepository.save(creditCard);
    }

    @PutMapping(value = "/creditcard/{id}")
    public ResponseEntity<CreditCard> update(@PathVariable(value = "id") int id, @Valid @RequestBody CreditCard newCreditCard){
        final Optional<CreditCard> oldCreditCard = creditCardRepository.findById(id);
        if(oldCreditCard.isPresent()){
            final CreditCard creditCard = oldCreditCard.get();
            creditCard.setCardFlag(newCreditCard.getCardFlag());
            creditCard.setCardNumber(newCreditCard.getCardNumber());
            creditCard.setCandidate(newCreditCard.getCandidate());
            creditCardRepository.save(creditCard);
            return new ResponseEntity<>(creditCard, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/creditcard/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int id) {
        Optional<CreditCard> creditCard = creditCardRepository.findById(id);
        if(creditCard.isPresent()){
            creditCardRepository.delete(creditCard.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

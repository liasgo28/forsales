package br.com.forsales.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity class for Candidate
 *
 * Created by Diego Nascimento
 */
@Entity
@Table(name="candidate")
@Getter
@Setter
public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int identification;

    @Column
    private String name;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("candidate")
    private List<CreditCard> creditCardList;


    /**
     * Method to add credicard
     *
     * @param creditCard
     *
     * @
     */
    public void addCreditCard(CreditCard creditCard) {
        if (this.creditCardList == null){
            creditCardList = new ArrayList<>();
        }
        creditCardList.add(creditCard);
        creditCard.setCandidate(this);
    }
}

package br.com.forsales.model;

import br.com.forsales.common.CardFlagEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity class for Credit Card
 *
 * Created by Diego Nascimento
 */
@Entity
@Table(name="credit_card")
@Getter
@Setter
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int identification;

    @Column(name = "card_number", nullable = false, length = 16)
    private long cardNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_flag", nullable = false)
    private CardFlagEnum cardFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"creditCardList", "hibernateLazyInitializer", "handler"})
    private Candidate candidate;

}

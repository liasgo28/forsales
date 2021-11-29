package br.com.forsales.repositories;

import br.com.forsales.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The repository interface for Credit Card database table.
 *
 * Created by Diego Nascimento.
 */
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
}

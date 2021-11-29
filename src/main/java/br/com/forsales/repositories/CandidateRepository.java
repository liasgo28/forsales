package br.com.forsales.repositories;

import br.com.forsales.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The repository interface for Candidate database table.
 *
 * Created by Diego Nascimento.
 */
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}

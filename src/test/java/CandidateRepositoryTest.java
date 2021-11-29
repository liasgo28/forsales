import br.com.forsales.Application;
import br.com.forsales.common.CardFlagEnum;
import br.com.forsales.model.Candidate;
import br.com.forsales.model.CreditCard;
import br.com.forsales.repositories.CandidateRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Test class for Candidate repository.
 *
 * Created by Diego Nascimento.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class CandidateRepositoryTest {
    @Autowired
    private CandidateRepository candidateRepository;

    @Test
    public void testGetAllCandidates(){
        final List<Candidate> all = candidateRepository.findAll();
        Assert.assertTrue(all.size() > 0);
    }

    @Test
    public void testGetCandidateById(){
        Candidate candidate = candidateRepository.findById(1).orElse(null);
        Assert.assertNotNull(candidate);
        Assert.assertEquals("Diego", candidate.getName());
        Assert.assertTrue(candidate.getCreditCardList().size() > 0);
    }

    @Test
    public void testSave(){
        Candidate candidate1 = new Candidate();
        candidate1.setName("teste");
        CreditCard creditCard = new CreditCard();
        creditCard.setCardFlag(CardFlagEnum.M);
        creditCard.setCardNumber(123456);
        candidate1.addCreditCard(creditCard);
        candidateRepository.save(candidate1);
        Assert.assertTrue(candidate1.getIdentification() > 0);

    }
}


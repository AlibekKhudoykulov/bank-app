package ecma.ai.transferapp.service;

import ecma.ai.transferapp.entity.Card;
import ecma.ai.transferapp.entity.Income;
import ecma.ai.transferapp.entity.Outcome;
import ecma.ai.transferapp.repository.CardRepository;
import ecma.ai.transferapp.repository.IncomeRepository;
import ecma.ai.transferapp.repository.OutcomeRepository;
import ecma.ai.transferapp.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@Service
public class IncomeService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    IncomeRepository incomeRepository;
    @Autowired
    OutcomeRepository outcomeRepository;

    public Collection<Income> getAll(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");

        token = token.substring(7);

        String username = jwtProvider.getUsernameFromToken(token);//username

        Collection<Income> allOutcome = incomeRepository.findByAllNative(username);
        return allOutcome;

    }

}

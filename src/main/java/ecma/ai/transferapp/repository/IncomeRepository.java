package ecma.ai.transferapp.repository;

import ecma.ai.transferapp.entity.Card;
import ecma.ai.transferapp.entity.Income;
import ecma.ai.transferapp.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Integer> {
    @Query(value = "select * " +
            "from income inner join card c on income.to_card_id  = c.id where c.username=?",nativeQuery = true)
    Collection<Income> findByAllNative(String username);
}

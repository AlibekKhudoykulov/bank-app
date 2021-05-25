package ecma.ai.transferapp.repository;

import ecma.ai.transferapp.entity.Card;
import ecma.ai.transferapp.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Integer> {


    @Modifying
    @Query(value = "select * " +
            "from outcome inner join card c on outcome.from_card_id = c.id where c.username=?",nativeQuery = true)
    Collection<Outcome> findByAllNative(String username);

}

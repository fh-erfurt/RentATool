package de.rat.repositories;

import de.rat.model.common.Account;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account,Integer> {

    Account findById(int id);
    Optional<Account> findByEmail(String email);
}

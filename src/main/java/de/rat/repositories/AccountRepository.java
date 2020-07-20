package de.rat.repositories;

import de.rat.model.common.Account;
import de.rat.model.common.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface AccountRepository extends CrudRepository<Account,Integer> {

    Account findById(int id);
    List<Account> findByRole(Role role); //TODO: delete?
    Optional<Account> findByEmail(String email);
}

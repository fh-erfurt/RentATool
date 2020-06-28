package de.rat.storage.repository;

import de.rat.model.common.Account;
import de.rat.model.common.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AccountRepository extends CrudRepository<Account,Integer> {

    Account findById(int id);
    Account findBy(int CustomerId);
    Account findByEmail(String email);  //ToDo test if it works

    List<Account> findByRole(Role role);
}

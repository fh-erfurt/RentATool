package de.rat.storage.repository;

import de.rat.model.tesrUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <tesrUser,Integer> {

}

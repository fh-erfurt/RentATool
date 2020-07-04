package de.rat.storage.repository;

import de.rat.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User,Integer> {

}

package de.rat.storage.repository;

import de.rat.model.UserDummy;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UserDummy,Integer> {

}

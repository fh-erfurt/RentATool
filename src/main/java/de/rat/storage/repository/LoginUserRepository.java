package de.rat.storage.repository;

import de.rat.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

    LoginUser findByUsername(String username);
}

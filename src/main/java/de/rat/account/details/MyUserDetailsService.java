//package de.rat.account.details;
//
//import de.rat.model.common.Person;
//import de.rat.storage.repository.AccountRepository;
//import de.rat.storage.repository.PersonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    PersonRepository personRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<Person> user = personRepository.findByEmail(email);
//
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));
//
//        return user.map(MyUserDetails::new).get();
//    }
//}

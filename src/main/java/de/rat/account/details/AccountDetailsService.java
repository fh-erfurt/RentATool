package de.rat.account.details;

import de.rat.model.common.Account;
import de.rat.storage.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

/** Provides specific user information
 *  It is used throughout the framework as a user DAO and is the strategy used by the DaoAuthenticationProvider.
 *  The interface requires only one read-only method, which simplifies support for new data-access strategies.

 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */

@Service
public class AccountDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    /**
     * load the account by the email
     * @param  email String
     * @return AccountDetails
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> user = accountRepository.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));

        return user.map(AccountDetails::new).get();
    }
}

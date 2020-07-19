package de.rat.account.details;

import de.rat.model.common.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/** Provides core user information
 * They simply store user information which is later encapsulated into Authentication objects. <br>
 * This allows non-security related user information (such as email addresses, telephone numbers etc) to be stored in a convenient location.
 *
 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
public class AccountDetails implements UserDetails {

    private Integer id;
    private String email;
    private String password;
    private List<GrantedAuthority> authorities;


    /**
     * set the AccountDetails
     * @param  account Account
     */
    public AccountDetails(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.password = account.getPassword();
        this.authorities = Arrays.stream(account.getRolesForAuthority().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    /**
     * @return authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * @return email
     */
    @Override
    public String getUsername() {return email;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {return true;}
}

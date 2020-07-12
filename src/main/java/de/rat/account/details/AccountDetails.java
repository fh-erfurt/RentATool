package de.rat.account.details;

import de.rat.model.common.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AccountDetails implements UserDetails {

    private Integer id;
    private String email;
    private String password;
    private List<GrantedAuthority> authorities;

    public AccountDetails(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.password = account.getPassword();
        this.authorities = Arrays.stream(account.getRolesForAuthority().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

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

//package de.rat.account.details;
//
//import de.rat.model.common.Account;
//import de.rat.model.common.Address;
//import de.rat.model.common.Person;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;;
//import java.time.LocalDate;
//import java.util.Collection;
//
//
//public class PersonDetails implements UserDetails {
//
//    private String lastname;
//    private String firstname;
//    private LocalDate birthday;
//    private Address address;
//    private Account account;
//
//
//    public PersonDetails(Person person) {
//        this.lastname = person.getLastname();
//        this.firstname = person.getFirstname();
//        this.birthday = person.getBirthday();
//        this.address = person.getAddress();
//        this.account = person.getAccount();
//
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.account.getPassword();
//    }
//
//    @Override
//    public String getUsername() {return this.account.getEmail();}
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {return true;}
//}

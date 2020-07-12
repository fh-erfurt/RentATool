//package de.rat.account.details;
//
//import de.rat.model.common.Account;
//import de.rat.model.common.Address;
//import de.rat.model.common.Person;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class MyUserDetails implements UserDetails {
//
//
//    // Person
//    private String lastname;
//    private String firstname;
//    private LocalDate birthday;
//    private Account account;
//    private Address address;
//
//    // Account
//    private String email;
//    private String password;
//    private List<GrantedAuthority> authorities;
//
//    // Address
//    private String street;
//    private String houseNr;
//    private String zip;
//    private String city;
//    private String country;
//
//    public MyUserDetails(Person person) {
//        this.lastname = person.getLastname();
//        this.firstname = person.getFirstname();
//        this.birthday = person.getBirthday();
//        this.account = person.getAccount();
//        this.address = person.getAddress();
//
//
//        this.email = account.getEmail();
//        this.password = account.getPassword();
//        this.authorities = Arrays.stream(account.getRolesForAuthority().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//
//        this.street = address.getStreet();
//        this.houseNr = address.getHouseNr();
//        this.zip = address.getZip();
//        this.city = address.getCity();
//        this.country = address.getCountry();
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {return email;}
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
//
//}

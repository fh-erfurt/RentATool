package de.rat.model.common;

import de.rat.model.BaseModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**Represents a class account.
 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */

@Entity
public class Account extends BaseModel {

    @NotEmpty
    @Column(unique = true)
    @Email(message = "Gib eine gültige Emailadresse ein.")
    private String email;
    @NotEmpty(message="Gib ein gültiges Passwort ein")
    private String password;
    private Role role;

    public Account(){ }

    public Account (Role role, String email, String password){
        this.role= role;
        this.email= email;
        this.password= password;
    }

    public Role getRole() {
        return this.role;
    }

    public String getRolesForAuthority() {
        return "ROLE_" + role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

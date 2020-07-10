package de.rat.model.common;

import de.rat.model.BaseModel;
import javax.persistence.Entity;
import javax.validation.constraints.*;

/**Represents a class account.
 * @author Marco Petzold, Christian König, Danny Steinbrecher, Bilal Alnani
 */

@Entity
public class Account extends BaseModel {
    @NotEmpty
    @Email(message = "Enter a valid email address.")
    private String email;   //TODO: should this be declared as unique?
    @NotEmpty(message="Enter a valid password")
    private String password;
    private Role role;      //TODO: how does it look like in the database

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

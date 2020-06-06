package de.rat.model.common;

import de.rat.model.BaseModel;
import javax.persistence.Entity;

/**Represents a class account.
 * @author Marco Petzold, Christian König, Danny Steinbrecher, Bilal Alnani
 */

@Entity
public class Account extends BaseModel {
    private Role role;
    private String email;
    private String password;

    public Account(){ }

    public Account(Role role,String email) {
        this.email = email;
        this.role=role ;
        this.password="ddd";
    }


    public Account (Role role, String email, String password){
        this.role= role;
        this.email= email;
        this.password= password;
    }


    public Role getRole() {
        return this.role;
    }


    public String getEmail() {
        return email;
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

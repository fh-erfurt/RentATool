package de.rat.common;

import java.time.LocalDate;


public class Account {
    private Role role;
    private String email;
    private String password;
    private LocalDate changed;

    public Account(Role role,String email) {
        this.email = email;
        this.changed = LocalDate.now();
        this.role=role ;
        this.password="ddd";
    }

//    public Account (String role, String lastname, String firstname){
//        this.role= role;
//        this.email= lastname+"."+firstname+"@rat.de";
//        this.password= "ddd";
//    }

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

    public LocalDate getChanged() {
        return changed;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = this.password;
    }


    public void setChanged()
    {
        this.changed = LocalDate.now();
    }


    public void changeAccount(Role role, String email, Person person){
        this.setRole(role);
        this.setEmail(email);

        this.setPassword(person.createPassword(person.getFirstname(),person.getLastname(),person.getBirthday()));
        this.setChanged();

    }




}

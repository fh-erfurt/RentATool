package de.rat;

import java.time.LocalDate;

public class Account {
    private String role;
    private String email;
    private String password;
    private LocalDate changed;

    public Account(String email) {
        this.email = email;
        this.changed = LocalDate.now();
        this.role="customer";
        this.password="ddd";
    }

//    public Account (String role, String lastname, String firstname){
//        this.role= role;
//        this.email= lastname+"."+firstname+"@rat.de";
//        this.password= "ddd";
//    }

    public Account (String role, String email, String password){
        this.role= role;
        this.email= email;
        this.password= password;
    }

    public String getRole() {
        return role;
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

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = this.password;
    }

    /*public void setPassword(Customer customer) {
        this.password = this.createPasswort(customer);
    }*/

    public void setChanged()
    {
        this.changed = LocalDate.now();
    }


    public void changeAccount(String role, String email, Employee person){
        this.setRole(role);
        this.setEmail(email);
       // this.setPassword(person);
        this.setChanged();

    }

    public void changeAccount(String role, String email, Customer person){
        this.setRole(role);
        this.setEmail(email);
        //this.setPassword(person);
        this.setChanged();

    }
  /*  public String createPasswort()
    {
            String password= "abc"+123;

        return password;
    }*/

}

package de.rat;

import java.time.LocalDate;

public class Account {
    private String role;
    private String email;
    private String password;
    private LocalDate changed;

    public Account(String role, String email, String password) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.changed = LocalDate.now();
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

    public void setPassword(Employee employee) {
        this.password = this.createPasswort(employee);
    }

    public void setPassword(Customer customer) {
        this.password = this.createPasswort(customer);
    }

    public void setChanged()
    {
        this.changed = LocalDate.now();
    }


    public void changeAccount(String role, String email, Employee person){
        this.setRole(role);
        this.setEmail(email);
        this.setPassword(person);
        this.setChanged();

    }

    public void changeAccount(String role, String email, Customer person){
        this.setRole(role);
        this.setEmail(email);
        this.setPassword(person);
        this.setChanged();

    }
    public String createPasswort(Employee person)
    {
    String password = person.getFirstname()+person.getLastname()+person.getBirthday();

        return password;
    }


    public String createPasswort(Customer person)
    {
        String password = person.getFirstname()+person.getLastname()+person.getBirthday();

        return password;
    }
}

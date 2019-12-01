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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setChanged() {
        this.changed = LocalDate.now();
    }
    public void changeAccount(String role, String email, String password){
        this.setRole(role);
        this.setEmail(email);
        this.setPassword(password);
        this.setChanged();

    }
    public boolean createPasswort(){
        return true;
    }
}

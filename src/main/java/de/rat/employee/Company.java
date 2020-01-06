package de.rat.employee;

import java.util.ArrayList;

public class Company {

    private String companyName;
    private ArrayList<Employee> employees= new ArrayList<Employee>();


    /*Getter*/
    public Company(String companyName) {
        this.companyName=companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }


}


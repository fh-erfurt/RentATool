package de.rat;

import java.util.ArrayList;

public class Warehouse {

    private String CompanyName;
    private ArrayList<Bill>openbills = new ArrayList<Bill>();
    private ArrayList<Bill>closedbills = new ArrayList<Bill>();
    private ArrayList<Tool> Stock= new ArrayList<Tool>();
    private ArrayList<Employee> employees= new ArrayList<Employee>();


    public Warehouse(String CompanyName) {
        this.CompanyName=CompanyName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public ArrayList<Bill> getOpenbills() {
        return openbills;
    }

    public void setOpenbills(ArrayList<Bill> openbills) {
        this.openbills = openbills;
    }

    public ArrayList<Bill> getClosedbills() {
        return closedbills;
    }

    public void setClosedbills(ArrayList<Bill> closedbills) {
        this.closedbills = closedbills;
    }

    public ArrayList<Tool> getStock() {
        return Stock;
    }

    public void setStock(ArrayList<Tool> stock) {
        Stock = stock;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public boolean closeBill(Customer customer){

        int i= 3*4;

        return true;
    }
}


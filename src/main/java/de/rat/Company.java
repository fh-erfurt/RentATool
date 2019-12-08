package de.rat;

import java.util.ArrayList;

public class Company {

    private String CompanyName;
    private ArrayList<Bill>openBills = new ArrayList<Bill>();
    private ArrayList<Bill>closedBills = new ArrayList<Bill>();
    private ArrayList<Tool> Stock= new ArrayList<Tool>();
    private ArrayList<Employee> employees= new ArrayList<Employee>();


    /*Getter*/
    public Company(String CompanyName) {
        this.CompanyName=CompanyName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public ArrayList<Bill> getOpenBills() {
        return openBills;
    }
    public ArrayList<Bill> getClosedBills() {
        return closedBills;
    }

    /*Setter*/
    public void setOpenbills(ArrayList<Bill> openBills) {
        this.openBills= openBills;
    }



    public void setClosedBills(ArrayList<Bill> closedbills) {
        this.closedBills = closedbills;
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

        for (Bill foundedBill : this.openBills)
        {
            if (foundedBill.getCustomer().equals(this))
            {
                foundedBill.getListOfRentProcesses().add(rentedTool);
                return true;
            }
        }
        return true;
    }


}


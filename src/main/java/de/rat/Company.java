package de.rat;

import java.util.ArrayList;

public class Company {

    private String companyName;
    private ArrayList<Bill>openBills = new ArrayList<Bill>();
    private ArrayList<Bill>closedBills = new ArrayList<Bill>();
    private ArrayList<Tool> Stock= new ArrayList<Tool>();
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

    public boolean closeBill(Customer customer, int discount){

        for (Bill foundedBill :openBills)
        {
            if (foundedBill.getCustomer().equals(customer))
            {
                for (RentProcess foundedProcesses :foundedBill.getListOfRentProcesses())
                {
                    if (foundedProcesses.getReturnStation() == null)  //ToDo über Date anpassen
                    {
                        return false;
                    }
                }
                foundedBill.setDiscount(discount);
                foundedBill.setFullRentPrice();
                openBills.remove(foundedBill);
                closedBills.add(foundedBill);
                return true;
            }
        }

        return true;
    }


}


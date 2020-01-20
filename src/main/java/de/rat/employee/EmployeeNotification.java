package de.rat.employee;

import de.rat.billing.Bill;

import java.util.ArrayList;

public class EmployeeNotification {

private ArrayList  <Employee> employees=new ArrayList <Employee>();

public EmployeeNotification()
{

}

public String sendNotificationToAllEmployees()
{
    for (Employee employee : this.employees) {
        //ToDo Postfach bei employee?
    }

}

}

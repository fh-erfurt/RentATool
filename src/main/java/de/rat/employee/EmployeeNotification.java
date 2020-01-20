package de.rat.employee;

import de.rat.billing.Bill;

import java.util.ArrayList;

public class EmployeeNotification {

static private ArrayList  <Employee> employees=new ArrayList <Employee>();

public static void sendNotificationToAllEmployees()
{
    for (Employee employee : employees) {
        employee.printNotification();
    }

}

}

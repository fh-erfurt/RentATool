package de.rat.employee;

import de.rat.billing.Bill;
import de.rat.customer.Customer;

import java.util.ArrayList;

public class EmployeeNotification {

static private ArrayList  <Employee> employees=new ArrayList <Employee>();

    public static void addEmployee(Employee employee)
    {
        employees.add(employee);

    }

    public static void sendNotificationToAllEmployees()
    {
        for (Employee employee : employees) {
            employee.printNotification();
        }

    }

    public static void sendNotificationToAllEmployeesToCheckTheOpenBills(Customer customer)
    {
        for (Employee employee : employees) {
            employee.printNotificationCheckOpenBills(customer);
        }

    }

}

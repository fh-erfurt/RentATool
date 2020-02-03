package de.rat.employee;

import de.rat.customer.Customer;

import java.util.ArrayList;
/**Represents an EmployeeNotification.
 * @author Danny Steinbrecher, Marco Petzold, Christian König,Bilal Alnani
 */
public class EmployeeNotification {

static private ArrayList  <Employee> employees= new ArrayList<>();

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

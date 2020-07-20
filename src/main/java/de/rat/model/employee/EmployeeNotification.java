package de.rat.model.employee;

import de.rat.model.customer.Customer;
import java.util.ArrayList;
import java.util.List;

/**Represents an EmployeeNotification.
 * @author Danny Steinbrecher, Marco Petzold, Christian König
 */
public class EmployeeNotification {

static private List<Employee> employees= new ArrayList<>();

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

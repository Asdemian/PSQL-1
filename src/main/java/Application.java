import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import model.Employee;

import java.awt.datatransfer.FlavorListener;
import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee(5, "Дарья", "Российская", "Ж", 27, 4);
        employeeDao.create(employee);


        System.out.println(employeeDao.readById(5));

        EmployeeDao employeeDao1 = new EmployeeDaoImpl();
        List<Employee> employees = employeeDao1.readAll();
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }

        Employee employee1 = new Employee(5, "Дарья", "Российская", "Ж", 27, 4);
        employeeDao.update(employee1);

        Employee employee2 = new Employee(21, "", "", "", 0, 0);
        employeeDao.delete(employee2);

    }
}




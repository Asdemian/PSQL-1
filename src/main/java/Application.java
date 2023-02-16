import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import jdbc.ConnectionManager;
import model.Employee;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.readById(10);

        EmployeeDao employeeDao1 = new EmployeeDaoImpl();
        employeeDao1.readAll().forEach(System.out::println);

        EmployeeDao employeeDao2 = new EmployeeDaoImpl();
        employeeDao2.create(new Employee("Vitia", "First", "M", 50, 5));

        EmployeeDao employeeDao3 = new EmployeeDaoImpl();
        employeeDao3.deleteById(14);

        EmployeeDao employeeDao4 = new EmployeeDaoImpl();
        employeeDao4.updateById("Vitiya", "Firstin", "M", 30, 5, 15);

    }
}




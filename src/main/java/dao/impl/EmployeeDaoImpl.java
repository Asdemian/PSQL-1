package dao.impl;

import dao.EmployeeDao;
import jdbc.ConnectionManager;
import model.City;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {


    @Override
    public void create(Employee employee) {

        try (final Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO employee (first_name, last_name, gender, age, city_id ) VALUES ((?), (?), (?), (?), (?))")) {

            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity_id());

            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Employee readById(int id) {

        Employee employee = new Employee();
        // Формируем запрос к базе с помощью PreparedStatement
        try (final Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id AND id=(?)")) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                // и присваиваем их полим объекта
                employee.setId(Integer.parseInt(resultSet.getString("id")));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(Integer.parseInt(resultSet.getString("age")));
                employee.setCity_name(resultSet.getString("city_name"));

                System.out.println(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> readAll() {

        // Создаем список, в который будем укладывать объекты
        List<Employee> employeeList = new ArrayList<>();

        try (final Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id");

             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                // Employee employee = new Employee

                int id = Integer.parseInt(resultSet.getString("id"));
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String city_name = resultSet.getString("city_name");
                String city = resultSet.getString("city_name");

                employeeList.add(new Employee(id, first_name, last_name, gender, age, city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }


    @Override
    public void updateById(String first_name, String last_name, String gender, int age, int city_id, int id) {

        try (final Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE employee SET first_name=(?), last_name=(?), gender=(?), age=(?), city_id=(?) WHERE id=(?)")) {


            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, city_id);
            statement.setInt(6, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {

        try (final Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM employee WHERE id=(?)")) {

            statement.setInt(1, id);
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



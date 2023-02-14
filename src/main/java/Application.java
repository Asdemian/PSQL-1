import java.sql.*;

public class Application {

    public static void main(String[] args)

            throws SQLException {

        final String user = "postgres";
        final String password = "1";
        final String url = "jdbc:postgresql://localhost:5432/skypro";


        // Создаем соединение с базой с помощью Connection
        // Формируем запрос к базе с помощью PreparedStatement
        try (final Connection connection = DriverManager
                .getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement
                     ("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id AND id=(?)")) {

            // Подставляем значение вместо wildcard
            statement.setInt(1, 6);

            // Делаем запрос к базе и результат кладем в ResultSet
            final ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                String idOfEmployee = "№ " + resultSet.getString("id");
                String first_nameOfEmployee = "Имя: " + resultSet.getString("first_name");
                String last_nameOfEmployee = "Фамилие: " + resultSet.getString("last_name");
                int ageOfEmployee = resultSet.getInt(5);
                String city_nameOfCity = resultSet.getString("city_name");

                // Выводим данные в консоль
                System.out.println(idOfEmployee);
                System.out.println(first_nameOfEmployee);
                System.out.println(last_nameOfEmployee);
                System.out.println("Годиков: " + ageOfEmployee);
                System.out.println("Город: " + city_nameOfCity);

            }
        }
    }
}




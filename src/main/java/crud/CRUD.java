package crud;

import connector.MySQLConnector;
import model.Student;
import runner.Main;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

    private static final String INSERT_STUDENT = "INSERT INTO student (name, surname, location) VALUES (?, ?, ?)";
    private static final String GET_STUDENT = "SELECT * FROM student";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE id = ?";
    private PreparedStatement preparedStatement = null;
    private MySQLConnector connector = null;

    // добавить студента, нужно ввести: имя, фамилию, город проживания
    public boolean createStudent() {
        try {
            connector = new MySQLConnector();
            preparedStatement = connector.getConnection().prepareStatement(INSERT_STUDENT);

            System.out.print("Введите данные для добавления студента: ");

            // здесь добавляются данные студента в бд, через консоль
            int x = 1;
            while (x < 4) {
                preparedStatement.setString(x, Main.scanner());
                x++;
            }
            preparedStatement.executeUpdate();
            return true;

        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    // вывести в консоль список всех студентов(все данные студентов)
    public boolean getAllStudents() {
        try {
            connector = new MySQLConnector();
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(GET_STUDENT);

            System.out.println("Список всех студентов:");
            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setLocation(resultSet.getString("location"));

                System.out.println(student);
            }
            return true;

        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    // удалить студента по id(это номер под которым был добавлен в бд)
    public boolean deleteStudent() {
        try {
            connector = new MySQLConnector();
            preparedStatement = connector.getConnection().prepareStatement(DELETE_STUDENT);

            System.out.print("Укажите индекс для удаления студента: ");
            preparedStatement.setInt(1, Integer.parseInt(Main.scanner()));

            preparedStatement.executeUpdate();
            return true;

        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

}

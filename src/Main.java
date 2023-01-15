import java.sql.*;
import java.util.ArrayList;

public class Main {
    static final String URL = "jdbc:mysql://localhost:3306/newdb";
    static final String USER = "developer";
    static final String PASSWORD = "userpasw";
    static final String SELECT_FROM_STUDENTS = "SELECT last_name, first_name FROM students";


    public static void main(String[] args) {

        ArrayList<String> surnames = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_FROM_STUDENTS)) {

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                System.out.println("Extracted name: " + result.getString("first_name"));
                surnames.add(result.getString("last_name"));
            }

            System.out.println("All Surnames: " + surnames);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
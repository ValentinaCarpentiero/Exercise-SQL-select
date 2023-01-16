import java.sql.*;
import java.util.ArrayList;

public class Main {
    static final String DB_NAME = "newdb";
    static final String URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
    static final String USER = "developer";
    static final String PASSWORD = "userpasw";



    public static void main(String[] args) {

        ArrayList<String> surnames = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement()) {

            ResultSet result = statement.executeQuery("SELECT last_name, first_name FROM students");

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
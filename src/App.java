import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sample"; // Change 'your_database' to your DB name
        String user = "root"; // Change to your MySQL username
        String password = "root"; // Change to your MySQL password

        // SQL statement to create a table
        String sql = "CREATE TABLE IF NOT EXISTS data (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "value VARCHAR(100)" +
                ")";

        // Connect and execute
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'data' created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AppDelete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample"; // your DB
        String user = "root";       // your MySQL username
        String password = "root";   // your MySQL password

        String deleteSql = "DELETE FROM student WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in);
             PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {

            System.out.print("Enter student ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No student found with ID " + id);
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AppUpdate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "root";

        String updateSql = "UPDATE student SET name = ?, email = ?, marks = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Scanner scanner = new Scanner(System.in);
                PreparedStatement pstmt = conn.prepareStatement(updateSql)) {

            System.out.print("Enter Student ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new email: ");
            String email = scanner.nextLine();

            System.out.print("Enter new marks: ");
            int marks = Integer.parseInt(scanner.nextLine());

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, marks);
            pstmt.setInt(4, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student record updated successfully.");
            } else {
                System.out.println("No student found with ID " + id);
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

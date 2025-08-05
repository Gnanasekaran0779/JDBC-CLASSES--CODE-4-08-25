import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppRead {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample"; // Replace 'sample' if needed
        String user = "root";
        String password = "root";

        String selectSql = "SELECT id, name, email, marks FROM student";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(selectSql);
                ResultSet rs = pstmt.executeQuery()) {

            System.out.println("ID\tName\tEmail\tMarks");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int marks = rs.getInt("marks");
                System.out.printf("%d\t%s\t%s\t%d%n", id, name, email, marks);
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
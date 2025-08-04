import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner; // ✅ Must import from java.util, not java.sql.util

public class Appcreate {

    public static void main(String[] args) {
        // ▶︎ Change these if your DB credentials differ
        String url = "jdbc:mysql://localhost:3306/sample?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";

        // Better to include an AUTO_INCREMENT 'id' field
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS STUDENT (
                  id INT AUTO_INCREMENT PRIMARY KEY,
                  name VARCHAR(100) NOT NULL,
                  mobile VARCHAR(15),
                  info VARCHAR(100)
                );
                """;

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                Scanner scanner = new Scanner(System.in) // java.util.Scanner
        ) {
            // Create table (if not exists)
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'STUDENT' ensured.");

            // Read user input
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter mobile number: ");
            String mobile = scanner.nextLine().trim();

            System.out.print("Enter info: ");
            String info = scanner.nextLine().trim();

            // Insert data using parameterized PreparedStatement
            String insertSQL = "INSERT INTO STUDENT(name, mobile, info) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, name);
                pstmt.setString(2, mobile.isEmpty() ? null : mobile);
                pstmt.setString(3, info.isEmpty() ? null : info);

                int count = pstmt.executeUpdate();
                System.out.printf("Inserted %d row%s successfully.%n",
                        count, count > 1 ? "s" : "");
            }

        } catch (Exception e) {
            System.err.println("Database error: ");
            e.printStackTrace();
        }
    }
}
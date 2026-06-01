import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

    private static final String URL = "jdbc:mysql://localhost:3306/feedback_db";
    private static final String USER = "root";
    private static final String PASSWORD = "T9!rA#2Z@L7p$Q";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database!");
            insertStudent(conn, "Alice", "alice@gmil.com");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn, String name, String email) {
        String sql = "INSERT INTO student (name,email) VALUES ('" + name + "','" + email + "')";

        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println("INSERTED: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
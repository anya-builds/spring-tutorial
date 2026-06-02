import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionDemo {
    private static final String URL="jdbc:mysql://localhost:3306/feedback_db";
    private static final String USER="root";
    private static final String PASSWORD="T9!rA#2Z@L7p$Q";
 public static void main(String[] args) {
     try (Connection conn= DriverManager.getConnection(URL,USER,PASSWORD)){
         System.out.println("Connected to the database");
     }catch (SQLException e){
         e.printStackTrace();
     }


 }
}

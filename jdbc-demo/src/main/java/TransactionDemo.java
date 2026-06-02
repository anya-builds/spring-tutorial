import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {
    private static final String URL="jdbc:mysql://localhost:3306/feedback_db";
    private static final String USER="root";
    private static final String PASSWORD="T9!rA#2Z@L7p$Q";
 public static void main(String[] args) {
     try (Connection conn= DriverManager.getConnection(URL,USER,PASSWORD)){
         System.out.println("Connected to the database");

         //order , orderItems
         //insert into order
         int orderId= insertOrder(conn,101,"Alice01",2000.0);
         //insert into order item
         insertOrderItem(conn, orderId,"Laptop01",1,2000.0);
     }catch (SQLException e){
         e.printStackTrace();
     }


 }

    private static int insertOrder(Connection conn, int customerId, String customerName, double price) {
     String sql="INSERT INTO orders (user_id,customer_name, total_amount) values (?,?,?)";
     try (PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1,customerId);
            pstmt.setString(2,customerName);
            pstmt.setDouble(3,price);
     }catch (SQLException e){
         e.printStackTrace();
     }
    }
}

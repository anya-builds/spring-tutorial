import java.sql.*;

public class TransactionDemo {
    private static final String URL="jdbc:mysql://localhost:3306/feedback_db";
    private static final String USER="root";
    private static final String PASSWORD="T9!rA#2Z@L7p$Q";
 public static void main(String[] args) {
     try (Connection conn= DriverManager.getConnection(URL,USER,PASSWORD)){
         System.out.println("Connected to the database");
        //turned off auto commit == no auto save
         conn.setAutoCommit(false);
        try {
            //order , orderItems
            //insert into order
            int orderId= insertOrder(conn,101,"Alice01",2000.0);
            //insert into order item
            insertOrderItem(conn, orderId,"Laptop01",1,2000.0);

            //manual commit
            conn.commit();
            System.out.println("Transaction committed successfully");
        }catch (SQLException e){
            e.printStackTrace();
            conn.rollback();
            System.out.println("Operation rollback successfully");
        }finally {
            conn.setAutoCommit(true);
        }

     }catch (SQLException e){
         e.printStackTrace();
     }


 }

    private static void insertOrderItem(Connection conn, int orderId, String productName, int quantity, double price) {
        String sql="INSERT INTO order_items (order_id,product_name, quantity,price) values (?,?,?,?)";
        try (PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1,orderId);
            pstmt.setString(2,productName);
            pstmt.setInt(3,quantity);
            pstmt.setDouble(4,price);
            int x=10/0;
            int rows=pstmt.executeUpdate();
            System.out.println("INSERTED into order items: "+rows);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static int insertOrder(Connection conn, int customerId, String customerName, double price) {
        String sql = "INSERT INTO orders (user_id,customer_name, total_amount) values (?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, customerId);
            pstmt.setString(2, customerName);
            pstmt.setDouble(3, price);
            int rows = pstmt.executeUpdate();
            System.out.println("INSERTED into users: " + rows);
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int orderId = rs.getInt(1);
                    System.out.println("ORDER ID: " + orderId);
                    return orderId;
                } else {
                    throw new SQLException("Order ID not generated");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

}

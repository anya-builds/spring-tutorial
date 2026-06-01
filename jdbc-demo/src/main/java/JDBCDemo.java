import java.sql.*;

public class JDBCDemo {

    private static final String URL = "jdbc:mysql://localhost:3306/feedback_db";
    private static final String USER = "root";
    private static final String PASSWORD = "T9!rA#2Z@L7p$Q";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database!");
//            insertStudent(conn, "Alice", "alice@gmil.com");
            updateStudent(conn,1,"Bob","alice@gmail.com");
            selectStudent(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn, String name, String email) {
        String sql = "INSERT INTO student (name,email) VALUES ('" + name + "','" + email + "')";

        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println("INSERTED: " + rows);
            selectStudent(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectStudent(Connection conn){
        String sql="SELECT * FROM student";
        try (Statement stmt=conn.createStatement()){
           ResultSet resultSet=stmt.executeQuery(sql);
            System.out.println("Student List: ");
            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email= resultSet.getString("email");
                System.out.println(id + " : " + name + " : "+ email);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private  static void updateStudent(Connection conn,int id,String name,String email){
        String sql = "UPDATE student SET name = '" + name + "', email = '" + email + "' WHERE id = " + id;
        // UPDATE student set name ='Alice',email='email@gmail.com'
        // where id=10;
        try (Statement stmt = conn.createStatement()){
            int rows=stmt.executeUpdate(sql);
            System.out.println("UPDATED: "+rows);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
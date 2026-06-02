import java.sql.*;

public class JDBCDemo {

    private static final String URL = "jdbc:mysql://localhost:3306/feedback_db";
    private static final String USER = "root";
    private static final String PASSWORD = "T9!rA#2Z@L7p$Q";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database!");
//            insertStudent(conn, "Java\"); DROP TABLE student; --", "hack@example.com");
            insertStudent(conn,"Alice","alice@gmail.com");
            updateStudent(conn,2,"Bob","alice@gmail.com");
            selectStudent(conn);
//            deleteStudent(conn,1);
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
//        String sql = "UPDATE student SET name = '" + name + "', email = '" + email + "' WHERE id = " + id;
        String sql = "UPDATE student SET name = ?, email = ? WHERE id = ?";
        // UPDATE student set name ='Alice',email='email@gmail.com'
        // where id=10;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setInt(3,id);
            int rows=pstmt.executeUpdate();
            System.out.println("UPDATED: "+rows);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void deleteStudent(Connection conn,int id){
        String sql="DELETE FROM student WHERE id= "+id;
        try (Statement stmt=conn.createStatement()){
            int rows=stmt.executeUpdate(sql);
            System.out.println("DELETED: "+rows);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
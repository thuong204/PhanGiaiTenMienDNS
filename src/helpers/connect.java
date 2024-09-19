package helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
	    private static final String DB_URL = "jdbc:mysql://localhost:3306/dnsdomain";
	    
	    private static final String USER = "root";
	    private static final String PASS = "";

	    public static Connection connect() {
	        Connection connection = null;
	        try {
	            // Đăng ký driver MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Tạo kết nối tới MySQL
	            connection = DriverManager.getConnection(DB_URL, USER, PASS);
	            System.out.println("Kết nối thành công!");

	        } catch (SQLException | ClassNotFoundException e) {
	        	e.printStackTrace();
	            System.out.println("Kết nối thất bại: " + e.getMessage());
	        }
	        return connection;
	    }

	    public static void main(String[] args) {
	        // Kiểm tra kết nối
	        Connection conn = connect.connect();
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

}

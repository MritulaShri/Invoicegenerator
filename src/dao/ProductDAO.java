package dao;
import java.sql.*;

public class ProductDAO {
	public void addProduct(String name, double price) throws SQLException {
        String query = "INSERT INTO Product (name, price) VALUES (?, ?)";
        Connection conn = DbConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.setDouble(2, price);
        pstmt.executeUpdate();
         
    }

}

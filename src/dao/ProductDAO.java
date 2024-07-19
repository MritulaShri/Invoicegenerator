package dao;
import java.sql.*;


import models.Product;

public class ProductDAO {
	public void addProduct(String name, double price) throws SQLException {
        String query = "INSERT INTO Product (name, price) VALUES (?, ?)";
        Connection conn = DbConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.setDouble(2, price);
        pstmt.executeUpdate();
         
    }
	
	public Product getProductById(int productId) {
        String query = "SELECT * FROM Product WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Product product=new Product(rs.getString(2),rs.getBigDecimal(3));
                product.setProductId(rs.getInt(1));
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

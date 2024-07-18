package dao;

import java.sql.*;

public class InvoiceItemDAO {
	
	public void addInvoiceItem(int invoiceId, int productId, int quantity) throws SQLException {
        String query = "INSERT INTO InvoiceItem (invoice_id, product_id, quantity) VALUES (?, ?, ?)";
        Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, invoiceId);
            pstmt.setInt(2, productId);
            pstmt.setInt(3, quantity);
            pstmt.executeUpdate();        
    }
	
	public void topSellingItemWithinASpanOfTime(String startDate, String endDate) throws SQLException {
        String query = "SELECT product_id, SUM(quantity) AS total_quantity " +
                "FROM InvoiceItem " +
                "JOIN Invoice ON InvoiceItem.invoice_id = Invoice.id " +
                "WHERE date BETWEEN ? AND ? " +
                "GROUP BY product_id " +
                "ORDER BY total_quantity DESC LIMIT 1";
        Connection conn = DbConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, startDate);
        pst.setString(2, endDate);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            System.out.println("Top Selling Item ID: " + rs.getInt(1));
            System.out.println("Total quantity: " + rs.getInt(2));
        }
        
    }
	
	public void highestSoldProduct(String range, String type) throws SQLException {
        String query = "SELECT product_id, SUM(quantity) AS total_quantity " +
                "FROM InvoiceItem " +
                "JOIN Invoice ON InvoiceItem.invoice_id = Invoice.id " +
                "WHERE " + type + " = ? " +
                "GROUP BY product_id " +
                "ORDER BY total_quantity DESC LIMIT 1";
        Connection conn = DbConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, range);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("Highest Sold Product ID: " + rs.getInt(1));
            System.out.println("Total quantity: " + rs.getInt(2));
        }       
	}
	
	public void viewUnitsSoldByProductId(int productId) throws SQLException {
        String query = "SELECT SUM(quantity) AS total_quantity FROM InvoiceItem WHERE product_id = ?";
        Connection conn = DbConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, productId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("Total Units Sold: " + rs.getInt("total_quantity"));
        }
        
    }

}

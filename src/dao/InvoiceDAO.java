package dao;

import java.sql.*;

public class InvoiceDAO {
	public void addInvoice(int customerId, String date, double discountPercentage) throws SQLException {
        String query = "INSERT INTO Invoice (customer_id, date, discount) VALUES (?, ?, ?)";
        Connection conn = DbConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, customerId);
        pstmt.setString(2, date);
        pstmt.setDouble(3, discountPercentage);
        pstmt.executeUpdate();        
    }
	public void display(ResultSet rs) throws SQLException {
		while(rs.next()) {
			System.out.println();
        	System.out.println("Invoice ID: " + rs.getInt(1));
        	System.out.println("Customer ID: " + rs.getInt(2));
        	System.out.println("Date: " + rs.getDate(3));
        	System.out.println("Total: " + rs.getBigDecimal(4));
        	System.out.println("Discount: " + rs.getBigDecimal(5));
        	System.out.println("Final amount: " + rs.getBigDecimal(6));
        	System.out.println("Status: " + rs.getString(7));
        	
        }
	}
	
	public void viewAllInvoices() throws SQLException {
        String query = "SELECT * FROM Invoice";
        Connection conn = DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(query);
        display(rs);
//        while(rs.next()) {
//        	System.out.println("Invoice ID: " + rs.getInt(1));
//        	System.out.println("Customer ID: " + rs.getInt(2));
//        	System.out.println("Date: " + rs.getDate(3));
//        	System.out.println("Total: " + rs.getBigDecimal(4));
//        	System.out.println("Discount: " + rs.getBigDecimal(5));
//        	System.out.println("Final amount: " + rs.getBigDecimal(6));
//        	System.out.println("Status: " + rs.getString(7));
//        	
//        }
    }
	
	public void viewUnpaidInvoices() throws SQLException {
        String query = "SELECT * FROM Invoice WHERE status = 'UNPAID'";
        Connection conn = DbConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        display(rs);
//        while (rs.next()) {
//        	System.out.println("Invoice ID: " + rs.getInt(1));
//        	System.out.println("Customer ID: " + rs.getInt(2));
//        	System.out.println("Date: " + rs.getDate(3));
//        	System.out.println("Total: " + rs.getBigDecimal(4));
//        	System.out.println("Discount: " + rs.getBigDecimal(5));
//        	System.out.println("Final amount: " + rs.getBigDecimal(6));
//        	System.out.println("Status: " + rs.getString(7));
//            }
    }
	
	public void getInvoiceDetailsbyid(int invoiceId) throws SQLException {
        String query = "SELECT * FROM Invoice WHERE id = ?";
        Connection conn = DbConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, invoiceId);
        ResultSet rs = pst.executeQuery();
        display(rs);
//        if (rs.next()) {
//        	System.out.println("Invoice ID: " + rs.getInt(1));
//        	System.out.println("Customer ID: " + rs.getInt(2));
//        	System.out.println("Date: " + rs.getDate(3));
//        	System.out.println("Total: " + rs.getBigDecimal(4));
//        	System.out.println("Discount: " + rs.getBigDecimal(5));
//        	System.out.println("Final amount: " + rs.getBigDecimal(6));
//        	System.out.println("Status: " + rs.getString(7));
//        }        
    }
	
//	public void viewCustomerUnpaidInvoices(int customerId) {
//        String query = "SELECT * FROM Invoice WHERE customer_id = ? AND status= 'UNPAID'";
//        try (Connection conn = DbConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query)) {
//            pstmt.setInt(1, customerId);
//            ResultSet rs = pstmt.executeQuery();
//            double totalAmount = 0.0;
//            while (rs.next()) {
////                System.out.println("Invoice ID: " + rs.getInt("id"));
//                // Print other invoice details
//                // Calculate total amount
//                totalAmount += calculateFinalAmount(rs.getInt("id"));
//            }
//            System.out.println("Total Amount: " + totalAmount);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    private double calculateFinalAmount(int invoiceId) {
//        String query = "SELECT SUM(price * quantity * (1 - discount / 100)) AS final_amount " +
//                "FROM InvoiceItem " +
//                "JOIN Product ON InvoiceItem.product_id = Product.product_id " +
//                "JOIN Invoice ON InvoiceItem.invoice_id = Invoice.id " +
//                "WHERE InvoiceItem.invoice_id = ?";
//        try (Connection conn = DbConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query)) {
//            pstmt.setInt(1, invoiceId);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
//                return rs.getDouble("final_amount");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0.0;
//    }

	
	

}

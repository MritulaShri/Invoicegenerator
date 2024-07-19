package dao;
import java.sql.*;


import models.Customer;

public class CustomerDAO {
	
	public void addCustomer(String name,String phoneNumber,String email) throws SQLException {
		String query ="insert into Customer(name,phone,email) values(?,?,?);";
		Connection con=DbConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, name);
		pst.setString(2,phoneNumber);
		pst.setString(3, email);
		pst.executeUpdate();
		
	}
	
	public Customer getCustomerById(int customerId) {
        String query = "SELECT * FROM Customer WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Customer customer=new Customer(rs.getString(2),rs.getString(4),rs.getString(3));
                customer.setCustomerId(rs.getInt(1));
                System.out.println();
                System.out.println("Customer Id:"+rs.getInt(1));
                System.out.println("Name:"+rs.getString(2));
                System.out.println("Email:"+rs.getString(3));
                System.out.println("Phone number:"+rs.getString(4));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	
	
	

}

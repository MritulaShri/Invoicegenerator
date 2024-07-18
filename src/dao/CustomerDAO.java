package dao;
import java.sql.*;

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
	
	
	

}

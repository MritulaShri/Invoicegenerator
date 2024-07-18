package models;

public class Customer {
	
	    private int id;
	    private String name;
	    private String email;
	    private String phone;
	    private String address;
	    
	    public int getCustomerId() {
	        return id;
	    }

	    public void setCustomerId(int customerId) {
	        this.id = customerId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPhoneNumber() {
	        return phone;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phone = phoneNumber;
	    }
	    
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    
}

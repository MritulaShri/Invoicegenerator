package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Invoice {
	Customer customer;
	   private int id;
	    private String date;
	    private BigDecimal total;
	    private BigDecimal discount;
	    private BigDecimal finalAmount;
	    private boolean isPaid;
	    private List<InvoiceItem> items;
	    
	    Invoice(String date,BigDecimal discount,boolean ispaid){
	    	this.date=date;
	    	this.discount=discount;
	    	this.isPaid=ispaid;
	    }
	    
	    public int getInvoiceId() {
	        return id;
	    }

	    public void setInvoiceId(int invoiceId) {
	        this.id = invoiceId;
	    }

	    public int getCustomerId() {
	        return customer.getCustomerId();
	    }

	    

	    public String getDate() {
	        return date;
	    }

	    public void setDate(String date) {
	        this.date = date;
	    }

	    public boolean isPaid() {
	        return isPaid;
	    }

	    public void setPaid(boolean isPaid) {
	        this.isPaid = isPaid;
	    }

	    public BigDecimal getDiscountPercentage() {
	        return discount;
	    }

	    public void setDiscountPercentage(BigDecimal discountPercentage) {
	        this.discount = discountPercentage;
	    }


}

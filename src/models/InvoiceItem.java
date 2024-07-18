package models;

import java.math.BigDecimal;

public class InvoiceItem {
	
	Invoice invoice=new Invoice();
	Product product=new Product();
	
	private int id;
    private int quantity;
    private BigDecimal price;
    
    public int getInvoiceItemId() {
        return id;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.id = invoiceItemId;
    }

    public int getInvoiceId() {
        return invoice.getInvoiceId();
    }

    public int getProductId() {
        return product.getProductId();
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public BigDecimal price() {
        return product.getPrice();
    }


 
}

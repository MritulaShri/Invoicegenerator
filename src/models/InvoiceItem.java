package models;

import java.math.BigDecimal;

public class InvoiceItem {
	
	Invoice invoice;
	Product product;
	
	private int id;
	private int invoice_id=invoice.getCustomerId();
	private int product_id=product.getProductId();
    private int quantity;
    private BigDecimal price;
    
    InvoiceItem(int invoice_id,int product_id,int quantity){
    	this.invoice_id=invoice_id;
    	this.product_id=product_id;
    	this.quantity=quantity;
    }
    
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

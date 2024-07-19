package models;

import java.math.BigDecimal;

public class Product {
	private int id;
    private String name;
    private BigDecimal price;
    
    public Product(String name,BigDecimal price){
    	this.name=name;
    	this.price=price;
    }
    
    public int getProductId() {
        return id;
    }

    public void setProductId(int productId) {
        this.id = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}

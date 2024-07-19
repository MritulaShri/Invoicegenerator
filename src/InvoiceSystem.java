import dao.CustomerDAO;
import dao.InvoiceDAO;
import dao.InvoiceItemDAO;
import dao.ProductDAO;
import models.Customer;

public class InvoiceSystem {
	public static void main(String[] args){
		
		
		
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        InvoiceDAO invoiceDAO = new InvoiceDAO();
        InvoiceItemDAO invoiceItemDAO = new InvoiceItemDAO();
        
        try {

	        customerDAO.addCustomer("John Doe", "1234567890","xyz@gmail.com");
	        customerDAO.addCustomer("Johnny depp", "1234567809","zzz@gmail.com");
	        productDAO.addProduct("Product 1", 100.00);
	        productDAO.addProduct("Product 2", 200.00);
	
	        invoiceDAO.addInvoice(1, "2024-07-17", 10.0);
	        invoiceItemDAO.addInvoiceItem(1, 1, 2);
	        invoiceItemDAO.addInvoiceItem(1, 2, 3);

	        invoiceDAO.viewAllInvoices();
	        invoiceDAO.viewUnpaidInvoices();
	        invoiceDAO.getInvoiceDetailsbyid(1);
	        invoiceItemDAO.topSellingItemWithinASpanOfTime("2024-01-01", "2024-12-31");
	        invoiceItemDAO.highestSoldProduct("2024", "YEAR(date)");
	        invoiceItemDAO.viewUnitsSoldByProductId(1);
	        customerDAO.getCustomerById(1);
        
        }catch(Exception e) {
        	System.out.println(e);
        }
	}

}

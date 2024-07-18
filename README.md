# Invoicegenerator
Table design
Customer:
    id INT (PK)
    name VARCHAR(255) 
    email VARCHAR(255) 
    phone VARCHAR(20)
    address VARCHAR(255)


Product:
    id INT (PK)
    name VARCHAR(255)
    price DECIMAL(10, 2)

Invoice:
    id INT (PK)
    customer_id INT (FK)
    date DATE 
    total DECIMAL(10, 2)
    discount DECIMAL(5, 2)
    final_amount DECIMAL(10, 2)
    status ENUM('PAID', 'UNPAID') 

InvoiceItem:
    id INT (PK)
    invoice_id INT (FK)
    product_id INT (FK)
    quantity INT
    price DECIMAL(10, 2) 

Module description: 

This project is a simple Invoice Management System built using Java and JDBC for database interaction. The system allows users to create, manage, and view invoices. It supports various functionalities like viewing all invoices, viewing unpaid invoices, printing invoices, viewing unpaid invoices for a customer, and generating reports on top-selling products and sales data.


Models contains the classes that represent the entities in the system.

Customer.java: Represents a customer with properties such as ID, name, email, phone number, and address.
Invoice.java: Represents an invoice with properties such as ID, customer ID, date, total amount, discount, final amount, status, and list of invoice items.
InvoiceItem.java: Represents an item in an invoice with properties such as ID, invoice ID, product ID, quantity, and price.
Product.java: Represents a product with properties such as ID, name, and price.
InvoiceStatus.java: An enumeration representing the status of an invoice (PAID or UNPAID).

DAO (Data Access Object) module handles all the database operations.

CustomerDAO.java: Provides CRUD operations for the Customer entity.
InvoiceDAO.java: Provides CRUD operations for the Invoice entity and includes methods to retrieve invoices by status and by customer ID and status.
InvoiceItemDAO.java: Provides CRUD operations for the InvoiceItem entity.
ProductDAO.java: Provides CRUD operations for the Product entity.
DbConnection.java: Contains methods for establishing a connection to the database.
    

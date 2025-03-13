package controller;

import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// Database Connection Singleton
class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_NAME = "miniproject";
    private static final String SERVER_ADDRESS = "hildur.ucn.dk";
    private static final int SERVER_PORT = 1433;
    private static final String USERNAME = "DMA-CSD-S243_10632120";
    private static final String PASSWORD = "Password1!";

    private DBConnection() {
        try {
            Class.forName(DRIVER_CLASS);
            String url = "jdbc:sqlserver://" + SERVER_ADDRESS + ":" + SERVER_PORT +
                         ";databaseName=" + DB_NAME + ";encrypt=true;trustServerCertificate=true;";
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            System.out.println("✅ Connected to SQL Server!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Connection failed.");
        }
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}

// Order Database Operations
class OrderDB {
    private Connection getConnection() {
        return DBConnection.getInstance().getConnection();
    }

    public boolean insertOrder(int customerId) {
        String query = "INSERT INTO orders (customer_id) VALUES (?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertOrderLine(int orderId, int productId, int quantity) {
        String query = "INSERT INTO order_lines (order_id, product_id, quantity) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

// Order Controller
class OrderController {
    private CustomerController custCtrl;
    private ProductController prodCtrl;
    private OrderDB ordCont;

    public OrderController() {
        this.custCtrl = new CustomerController();
        this.prodCtrl = new ProductController();
        this.ordCont = new OrderDB();
    }

    public boolean createOrder(int customerId) {
        return ordCont.insertOrder(customerId);
    }

    public boolean addOrderLineOnGivenOrder(int orderId, int productId, int quantity) {
        return ordCont.insertOrderLine(orderId, productId, quantity);
    }

    public Product getProduct(int productId) {
        return prodCtrl.getProductById(productId);
    }

    public Customer getCustomer(int customerId) {
        return custCtrl.getCustomerById(customerId);
    }
}

// Customer Database Operations
class CustomerDB {
    private Connection getConnection() {
        return DBConnection.getInstance().getConnection();
    }

    public Customer findCustomerById(int customerId) {
        String query = "SELECT * FROM customers WHERE customer_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt("customer_id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// Product Database Operations
class ProductDB {
    private Connection getConnection() {
        return DBConnection.getInstance().getConnection();
    }

    public Product findProductById(int productId) {
        String query = "SELECT * FROM products WHERE product_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("product_id"), rs.getString("name"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// Customer Controller
class CustomerController {
    private CustomerDB customerDB;

    public CustomerController() {
        this.customerDB = new CustomerDB();
    }

    public Customer getCustomerById(int customerId) {
        return customerDB.findCustomerById(customerId);
    }
}

// Product Controller
class ProductController {
    private ProductDB productDB;

    public ProductController() {
        this.productDB = new ProductDB();
    }

    public Product getProductById(int productId) {
        return productDB.findProductById(productId);
    }
}

// Customer Model
class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Product Model
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }



}

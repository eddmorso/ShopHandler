import com.mysql.jdbc.Driver;

import java.sql.*;
import com.mysql.jdbc.*;
import java.util.List;

public abstract class Shop {

    private Connection connection;
    private Statement statement;

    public Shop(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShopHandler", "test", "test");
            statement = connection.createStatement();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    private List<Category> categories;

    public abstract List<Product> getAllProductsFromDB() throws SQLException;

    public abstract void addProductsToDB(Product product);

    public abstract void addProductsToDB(List<Product> products);

    public abstract void setPriceOfProducts(Product product);

    public abstract void setPriceOfProducts(List<Product> products);

    public abstract void setStatusOfProducts(Product product);

    public abstract void setStatusOfProducts(List<Product> products);

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }
}

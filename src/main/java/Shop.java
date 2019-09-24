import java.sql.*;
import java.util.List;

public abstract class Shop {

    private Connection connection;
    private Statement statement;
    private List<Category> categories;
    private List<Product> products;

    public Shop(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_handler", "test", "test");
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

    public abstract List<Product> getAllProductsFromDB() throws SQLException;

    public abstract void addProductsToDB(Product product) throws SQLException;

    public abstract void addProductsToDB(List<Product> products) throws SQLException;

    public abstract void setPriceOfProducts(Product product) throws SQLException;

    public abstract void setPriceOfProducts(List<Product> products) throws SQLException;

    public abstract void setStatusOfProducts(Product product) throws SQLException;

    public abstract void setStatusOfProducts(List<Product> products) throws SQLException;

    public void setCategories(List<Category> categories) throws SQLException {
        this.categories = categories;
    }

    public List<Category> getCategories() throws SQLException {
        return categories;
    }
}

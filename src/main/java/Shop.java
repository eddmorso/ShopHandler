import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Shop {
    private Statement statement;
    private Connection connection;
    private List<Category> categories;
    private List<Product> products;
    private final String URL = "jdbc:mysql://localhost:3306/shop_handler";
    private final String USER = "test";
    private final String PASSWORD = "test";
    private final String SELECT_ALL = "SELECT * FROM table";
    private final String INSERT_INTO = "INSERT INTO table (Product title, Category, Availability, Price) VALUES (?,?,?,?)";

    public Shop(){
        categories = new ArrayList<>();
        products = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!connection.isClosed()){
                System.out.println("Connection established");
            }
            statement = connection.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public List<Product> getAllProductsFromDB(String tableName){
        products.clear();
        String statement = SELECT_ALL.replaceAll("table", tableName);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                products.add(new Product(resultSet.getString(1), new Category(resultSet.getString(2)), resultSet.getString(3), resultSet.getInt(4)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public abstract List<Product> getProducts();

    public void addProductsToDB(String tableName, Product product) {
        String statement = INSERT_INTO.replaceAll("table", tableName);
        if (product != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(statement);
                preparedStatement.setString(1, product.getTitle());
                preparedStatement.setString(2, product.getCategory().getName());
                preparedStatement.setString(3, product.getStatus());
                preparedStatement.setInt(4, product.getPrice());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("Null input while adding product to DB");
        }
    }

    public void addProductsToDB(String tableName, List<Product> products){
        for (Product product : products){
            addProductsToDB(tableName, product);
        }
    }

    public abstract void addProducts(Product product);

    public abstract void addProducts(List<Product> products);

    public abstract void setPriceOfProducts(Product product) throws SQLException;

    public abstract void setPriceOfProducts(List<Product> products) throws SQLException;

    public abstract void setStatusOfProducts(Product product) throws SQLException;

    public abstract void setStatusOfProducts(List<Product> products) throws SQLException;

    public List<Category> getCategories(String tableName) {
        if (products.isEmpty()){
            getAllProductsFromDB(tableName);
        }
        for (Product product : products){
            categories.add(product.getCategory());
        }
        return categories;
    }

    public void setCategories(List<Category> categories) throws SQLException {
        this.categories = categories;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

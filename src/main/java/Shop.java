import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Shop extends Thread {

    private Connection connection;
    private List<Category> categories;
    private List<Product> products;
    private String tableName;
    private final String URL = "jdbc:mysql://localhost:3306/shop_handler";
    private final String USER = "test";
    private final String PASSWORD = "test";
    private final String SELECT_ALL = "SELECT * FROM $table";
    private final String SELECT_PRODUCT = "SELECT * FROM $table WHERE Product_title = ?";
    private final String INSERT_INTO = "INSERT INTO $table (Product_title, Category, Availability, Price) VALUES (?,?,?,?)";
    private final String UPDATE_PRICE = "UPDATE $table SET Price = ? WHERE Product_title = ?";
    private final String UPDATE_STATUS = "UPDATE $table SET Availability = ? WHERE Product_title = ?";

    public Shop(String tableName){
        this.tableName = tableName;
        categories = new ArrayList<>();
        products = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!connection.isClosed()){
                System.out.println("Connection established");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Product> getProductsFromDB(){
        products.clear();

        String statement = SELECT_ALL.replace("$table", tableName);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                products.add(new Product(resultSet.getString(1), new Category(resultSet.getString(2)), Status.valueOf(resultSet.getString(3).toUpperCase()), resultSet.getInt(4)));
            }
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> getProductsFromDB(String title){
        String statement = SELECT_PRODUCT.replace("$table", tableName);
        List<Product> res = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                res.add(new Product(resultSet.getString(1), new Category(resultSet.getString(2)),
                        Status.valueOf(resultSet.getString(3)), resultSet.getInt(4)));
            }
            preparedStatement.close();
         }catch (SQLException e){
            e.printStackTrace();
        }

        return res;
    }

    public List<Product> getProductsFromDB(Product product){
        return getProductsFromDB(product.getTitle());
    }

    public void addProductsToDB(Product product) {
        String statement = INSERT_INTO.replace("$table", tableName);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2, product.getCategory().getName());
            preparedStatement.setString(3, product.getStatus().toString());
            preparedStatement.setDouble(4, product.getPrice());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProductsToDB(List<Product> products){
        for (Product product : products){
            addProductsToDB(product);
        }
    }

    public void setPriceInDB(double price, Product product) {
        String statement = UPDATE_PRICE.replace("$table", tableName);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setDouble(1, price);
            preparedStatement.setString(2, product.getTitle());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPriceInDB(double price, List<Product> products){
        for (Product product : products){
            setPriceInDB(price, product);
        }
    }

    public void setStatusInDB(Status status, Product product){
        String statement = UPDATE_STATUS.replace("$table", tableName);
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, status.toString());
            preparedStatement.setString(2, product.getTitle());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void setStatusInDB(Status status, List<Product> products){
        for (Product product : products){
            setStatusInDB(status, product);
        }
    }

    public List<Category> getCategories() {
        categories.clear();
        if (products.isEmpty()){
            getProductsFromDB();
        }
        for (Product product : products){
            categories.add(product.getCategory());
        }
        return categories;
    }

    public void closeConnection(){
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
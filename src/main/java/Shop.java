import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Shop {
    private Connection connection;
    private List<Category> categories;
    private List<Product> products;
    private String tableName;
    private final String URL = "jdbc:mysql://localhost:3306/shop_handler";
    private final String USER = "test";
    private final String PASSWORD = "test";
    private final String SELECT_ALL = "SELECT * FROM table";
    private final String INSERT_INTO = "INSERT INTO table (Product_title, Category, Availability, Price) VALUES (?,?,?,?)";
    private final String UPDATE_PRICE = "UPDATE table SET Price = ? WHERE Product_title = ?";
    private final String UPDATE_STATUS = "UPDATE table SET Availability = ? WHERE Product_title = ?";

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

    public List<Product> getAllProductsFromDB(){
        products.clear();
        categories.clear();

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

    public void addProductsToDB(Product product) {
        String statement = INSERT_INTO.replaceAll("table", tableName);
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
    }

    public void addProductsToDB(List<Product> products){
        for (Product product : products){
            addProductsToDB(product);
        }
    }

    public void setPriceInDB(int price, Product product) {
        String statement = UPDATE_PRICE.replaceAll("table", tableName);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, price);
            preparedStatement.setString(2, product.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPriceInDB(int price, List<Product> products){
        for (Product product : products){
            setPriceInDB(price, product);
        }
    }

    public void setStatusInDB(String status, Product product){
        String statement = UPDATE_STATUS.replaceAll("table", tableName);
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, product.getTitle());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void setStatusInDB(String status, List<Product> products){
        for (Product product : products){
            setStatusInDB(status, product);
        }
    }

//    public List<Category> getCategories() {
//        if (products.isEmpty()){
//            getAllProductsFromDB(tableName);
//        }
//        for (Product product : products){
//            categories.add(product.getCategory());
//        }
//        return categories;
//    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

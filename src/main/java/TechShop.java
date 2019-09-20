import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TechShop extends Shop {

    private static TechShop techShop;

    private TechShop(){
        super();
    }

    public static TechShop getInstance() {
        if (techShop == null){
            techShop = new TechShop();
        }
        return techShop;
    }
    
    @Override
    public void addProductsToDB(List<Product> products) {

    }

    @Override
    public void addProductsToDB(Product product) {

    }

    @Override
    public List<Product> getAllProductsFromDB() throws SQLException {
        ResultSet resultSet = getStatement().executeQuery("SELECT * FROM TechShop");

        return null;
    }

    @Override
    public void setPriceOfProducts(List<Product> products) {

    }

    @Override
    public void setPriceOfProducts(Product product) {

    }

    @Override
    public void setStatusOfProducts(Product product) {

    }

    @Override
    public void setStatusOfProducts(List<Product> products) {

    }
}

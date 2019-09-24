import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechShop extends Shop {

    private static TechShop techShop;
    private final String TABLE_NAME = "tech_shop";

    private TechShop(){
        super();

        getAllProductsFromDB(TABLE_NAME);
        getCategories(TABLE_NAME);
    }

    public static TechShop getInstance() {
        if (techShop == null){
            techShop = new TechShop();
        }
        return techShop;
    }

    @Override
    public List<Product> getProducts() {
        return getAllProductsFromDB(TABLE_NAME);
    }

    @Override
    public void addProducts(Product product) {
        super.addProductsToDB(TABLE_NAME, product);
    }

    @Override
    public void addProducts(List<Product> products) {
        super.addProductsToDB(TABLE_NAME, products);
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

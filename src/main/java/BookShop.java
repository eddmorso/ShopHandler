import java.util.List;

public class BookShop extends Shop {

    private static BookShop bookShop;

    private BookShop(){
        super();
    }

    public static BookShop getInstance() {
        if (bookShop == null) {
            bookShop = new BookShop();
        }
        return bookShop;
    }

    @Override
    public void addProductsToDB(List<Product> products) {

    }

    @Override
    public void addProductsToDB(Product product) {

    }

    @Override
    public List<Product> getAllProductsFromDB() {
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

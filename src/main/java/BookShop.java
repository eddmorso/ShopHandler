import java.util.List;

public class BookShop extends Shop {

    private static BookShop bookShop;
    public final String TABLE_NAME = "book_shop";

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

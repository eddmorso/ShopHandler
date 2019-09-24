import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookShop extends Shop {

    private static BookShop bookShop;

    private BookShop(){
        super("book_shop");
        getProductsFromDB();
    }

    public static BookShop getInstance() {
        if (bookShop == null) {
            bookShop = new BookShop();
        }
        return bookShop;
    }

    @Override
    public void run() {
        Category category = new Category("Advanture");
        List<Product> buff = new ArrayList<>();
        List<Product> products = Arrays.asList(new Product("Book 1", new Category("Advanture"), Status.ABSENT, 300),
            new Product("Book 2", new Category("Advanture"), Status.AVAILABLE, 360),
            new Product("Book 3", new Category("Advanture"), Status.AVAILABLE, 200),
            new Product("Book 4", new Category("Detective"), Status.AVAILABLE, 100),
            new Product("Book 5", new Category("Detective"), Status.AVAILABLE, 30),
            new Product("Book 6", new Category("Detective"), Status.AVAILABLE, 330),
            new Product("Book 7", new Category("Programming"), Status.AVAILABLE, 330),
            new Product("Book 8", new Category("Programming"), Status.AVAILABLE, 330),
            new Product("Book 9", new Category("Programming"), Status.AVAILABLE, 330));

        addProductsToDB(products);

        products = getProductsFromDB();

        products.stream().filter(product -> product.getCategory().equals(category)).
                forEach(product -> {setStatusInDB(Status.ABSENT, product);
                    buff.add(product);});
        products.removeAll(buff);

        products.forEach(product -> setStatusInDB(Status.EXPECTED, product));

        products = getProductsFromDB();

        products.stream().filter(product -> product.getStatus().equals(Status.AVAILABLE)).
                forEach(product -> setStatusInDB(Status.EXPECTED, product));
    }
}

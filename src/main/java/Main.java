import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TechShop techShop = TechShop.getInstance();
        BookShop bookShop = BookShop.getInstance();

        List<Product> products = Arrays.asList(new Product("IPhone 5", new Category("Smartphones"), "Expected", 900),
                new Product("IPhone 7", new Category("Smartphones"), "Expected", 10000));
        techShop.addProducts(products);
        techShop.getProducts().forEach(System.out :: println);
    }
}

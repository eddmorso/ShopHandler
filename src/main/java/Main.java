import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        TechShop techShop = TechShop.getInstance();
        BookShop bookShop = BookShop.getInstance();

        techShop.getProducts().forEach(System.out :: println);
        Product product = new Product("IPhone 4", new Category("Smartphones"), "Expected", 900);
        techShop.addProductsToDB(product);
    }
}

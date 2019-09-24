import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TechShop extends Shop {

    private static TechShop techShop;

    private TechShop(String url, String user, String password){
        super("tech_shop", url, user, password);
        getProductsFromDB();
    }

    public static TechShop getInstance(String url, String user, String password) {
        if (techShop == null){
            techShop = new TechShop(url, user, password);
        }
        return techShop;
    }

    @Override
    public void run() {
        Category category = new Category("Smartphones");
        List<Product> buff = new ArrayList<>();
        List<Product> products = Arrays.asList(new Product("Phone 1", new Category("Smartphones"), Status.ABSENT, 300),
            new Product("Phone 2", new Category("Smartphones"), Status.AVAILABLE, 360),
            new Product("Phone 3", new Category("Smartphones"), Status.AVAILABLE, 200),
            new Product("Tablet 1", new Category("Tablets"), Status.AVAILABLE, 100),
            new Product("Tablet 2", new Category("Tablets"), Status.AVAILABLE, 30),
            new Product("Tablet 3", new Category("Tablets"), Status.AVAILABLE, 330));

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

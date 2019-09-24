import java.util.List;

public class Category {

    private String name;
    private List<Product> products;

    public Category (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Category){
            Category category = (Category) obj;

            return name.equalsIgnoreCase(category.name);
        }
        return false;
    }
}

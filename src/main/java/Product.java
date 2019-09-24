public class Product {

    private String title;
    private int price;
    private String status;
    private Category category;

    public Product(String title, Category category, String status, int price){
        this.title = title;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return title + " " + category.getName() + " " + status + " " + price;
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product){
            Product product = (Product) obj;

            return title.equals(product.title);
        }
        return false;
    }
}

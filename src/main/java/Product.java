public class Product {

    private String title;
    private double price;
    private Status status;
    private Category category;

    public Product(String title, Category category, Status status, double price){
        this.title = title;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public Product(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

            return title.equalsIgnoreCase(product.title);
        }
        return false;
    }
}

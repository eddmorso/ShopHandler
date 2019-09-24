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
}

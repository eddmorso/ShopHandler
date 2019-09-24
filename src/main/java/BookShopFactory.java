public class BookShopFactory extends ShopFactory<BookShop>{

    public BookShopFactory(String url, String user, String password){
        super(url, user, password);
    }

    @Override
    public BookShop createShop(String tableName) {
        return null;
    }
}

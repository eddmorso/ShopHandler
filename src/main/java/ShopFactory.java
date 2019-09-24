public abstract class ShopFactory <T extends Shop> {
    private String url;
    private String user;
    private String password;

    public ShopFactory(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public abstract T createShop(String tableName);
}

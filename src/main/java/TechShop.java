public class TechShop extends Shop {

    private static TechShop techShop;

    private TechShop(){
        super("tech_shop");
        getProductsFromDB();
    }

    public static TechShop getInstance() {
        if (techShop == null){
            techShop = new TechShop();
        }
        return techShop;
    }
}

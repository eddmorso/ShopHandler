import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechShop extends Shop {

    private static TechShop techShop;

    private TechShop(){
        super("tech_shop");
        getAllProductsFromDB();
    }

    public static TechShop getInstance() {
        if (techShop == null){
            techShop = new TechShop();
        }
        return techShop;
    }
}

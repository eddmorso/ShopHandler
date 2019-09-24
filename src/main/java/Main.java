public class Main {
    public static void main(String[] args) {

        final String URL = "jdbc:mysql://localhost:3306/shop_handler";
        final String USER = "test";
        final String PASSWORD = "test";

        TechShop techShop = TechShop.getInstance(URL, USER, PASSWORD);
        BookShop bookShop = BookShop.getInstance(URL, USER, PASSWORD);

        techShop.start();

        try {
            TechShop.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        bookShop.start();

        try {
            techShop.join();
            bookShop.join();

            System.out.println("Job is done");
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            techShop.closeConnection();
            bookShop.closeConnection();
        }
    }
}

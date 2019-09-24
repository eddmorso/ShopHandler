public class Main {
    public static void main(String[] args) {

        TechShop techShop = TechShop.getInstance();
        BookShop bookShop = BookShop.getInstance();

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
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Job is done");

        techShop.closeConnection();
        bookShop.closeConnection();
    }
}

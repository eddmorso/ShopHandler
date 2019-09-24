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

            System.out.println("Job is done");
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            techShop.closeConnection();
            bookShop.closeConnection();
        }
    }
}

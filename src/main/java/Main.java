public class Main {
    public static void main(String[] args) {

        TechShop techShop = TechShop.getInstance();
        BookShop bookShop = BookShop.getInstance();

        techShop.start();
        try {
            TechShop.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bookShop.start();
        System.out.println("Job's done");
    }
}

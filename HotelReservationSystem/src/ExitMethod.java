
public class ExitMethod {
    public static void exit()throws InterruptedException{
        int i=5;
        System.out.print("Exiting System");
        while(i>=0){
            System.out.print(".");
            Thread.sleep(450);
            i--;
        }
        System.out.println();
    }
}

import java.util.concurrent.TimeUnit;

public class Multiple_Threads {

    public static void main(String[] args) throws InterruptedException {

        Runnable taskOne = () -> {
            for ( int i = 0; i <=3 ; i++  ){
                System.out.println("Hello from Task 1");
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Bye Bye from Task 1");
        };

        Runnable taskTwo = () -> {
            for ( int i = 1; i <=3 ; i++  ){
                System.out.println("Hello from  Task 2");
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Bye Bye from Task 2");
        };
        Thread taskOneThread = new Thread( taskOne, "Task one Thread" );
        Thread taskTwoThread = new Thread( taskTwo, "Task two Thread" );

        taskOneThread.start();
        taskTwoThread.start();

        taskOneThread.join();
        taskTwoThread.join();

        System.out.println("Bye Bye from main");
    }
}

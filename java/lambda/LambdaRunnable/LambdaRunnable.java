package lambda.LambdaRunnable;

/**
 * Created by zohn on 2017/11/15.
 */
public class LambdaRunnable {

    public static void main(String[] args) {
        new Thread(
                () -> {
                    System.out.println("with lambda is so easy");
                }

        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("before JAVA8,the code is too much");
                    }
                }
        ).start();
    }

    private String name;

}

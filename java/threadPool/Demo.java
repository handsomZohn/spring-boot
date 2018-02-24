package threadPool;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by zohn on 2018/1/9.
 */
public class Demo {
    //初始化一个包含10个线程的线程池
    private static Executor executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            // 提交任务
            executor.execute(new Task());
        }
    }

    /**
     * 执行任务的线程的生命周期都有Executor
     */
    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

}

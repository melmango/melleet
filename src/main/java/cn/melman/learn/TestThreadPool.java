package cn.melman.learn;

import java.util.concurrent.*;

/**
 * @author Melman
 * @date 2021/4/20 3:21 PM
 */
public class TestThreadPool {

    public static void main(String[] args) {
//        ThreadPoolExecutor executor =
        ExecutorService service = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });

        new ThreadPoolExecutor(10, 20, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        });

    }

}

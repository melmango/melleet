package com.example.demo;

import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Melman
 * @date 2021/4/21 2:49 PM
 */
public class MSTest {

    public void test() throws InterruptedException {
        StringBuffer buffer = new StringBuffer();
        buffer.append(1);
        StringBuilder sb = new StringBuilder();
        sb.append("1");

        Semaphore semaphore = new Semaphore(10);
        semaphore.release(10);
        semaphore.acquire(10);


        CountDownLatch latch = new CountDownLatch(10);
        latch.countDown();
        latch.await();

        try {
            MSTest test = MSTest.class.newInstance();
            Method method = MSTest.class.getMethod("test", MSTest.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        ThreadPoolExecutor executor;
    }

}

package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExecutorTest {

    @Test
    public void testThreadPoolAsync() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                10,
                100,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        int c = 100;

        while(c > 0) {
            for (int i = 0; i < 10 && c > 0; i++, c--) {
                final int a = c;
                executor.execute(new Runnable() {
                    @Override
                    public void run() {

                        log.info("running in {}, task count = {}, active count= {}", a, executor.getTaskCount(), executor.getActiveCount());
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}

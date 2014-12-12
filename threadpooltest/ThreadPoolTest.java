/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadpooltest;

import static java.lang.Thread.sleep;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author eegyedzsigmond
 */
public class ThreadPoolTest {

    static final int CORE_POOL_SIZE=4;
    static final int MAX_POOL_SIZE=4;
    static final long KEEP_ALIVE_TIME = 0; //Long.MAX_VALUE;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Integer threadCounter = 0;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
 
        ImageSignatureThreadPoolExecutor executor = new ImageSignatureThreadPoolExecutor(CORE_POOL_SIZE,
                                            MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.NANOSECONDS, blockingQueue);
 
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r,
                    ThreadPoolExecutor executor) {
                System.out.println("DemoTask Rejected : "
                        + ((PoolThread) r).getName());
                System.out.println("Waiting for a second !!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Lets add another time : "
                        + ((PoolThread) r).getName());
                executor.execute(r);
            }
        });
        // Let start all core threads initially
        executor.prestartAllCoreThreads();
        while (true) {
            threadCounter++;
            // Adding threads one by one
            System.out.println("Adding DemoTask : " + threadCounter);
            executor.execute(new PoolThread(threadCounter.toString()));
 
            if (threadCounter == 30)
                break;
        }
        executor.shutdown();
        while (!executor.isTerminated()){
        try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("terminated fini");
    }
    
    
}

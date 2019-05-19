

import java.util.concurrent.ThreadFactory;

/**
 * Created by Kor on 26.02.2019.
 */
public class ThreadFactoryT {
    //аналог абстрактной фабрики
    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };
        factory.newThread(new MyRun()).start();
    }
    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}

package notifyWait;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Kor on 24.02.2019.
 */
public class NotifyWaitExaple {
    public static void main(String[] args) throws InterruptedException {
        ThreadB threadB = new ThreadB();
        threadB.start();
        synchronized (threadB){
            //метод wait заставляет ждать поток в котором он вызван, т.е. main ждет от threadB notify
            threadB.wait();
        }
        System.out.println(threadB.total);
    }
    static class ThreadB extends Thread{
        int total;
        @Override

        public void run() {
            synchronized(this) {
                for (int i = 0; i < 5; i++) {
                    total += i;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
            }
        }
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                             wait and notify
//notify - текущий поток сообщает что закончил свою работу
//wait - поток пошел курить и джет notify другого потока
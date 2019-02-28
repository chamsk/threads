import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ScheduledExecutirServiceT {
    public static void main(String[] args) {
        //нужен для планирования срабатывания потоков
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(new MyThread(),3, SECONDS);
        //Упорядоченное завершение работы, при котором ранее отправленные задачи выполняются, а новые задачи не принимаются
        service.shutdown();
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            // to do
        }
    }
}
import java.util.concurrent.CountDownLatch;

public class CountDownLatchT {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
      //  countDownLatch.countDown(); //понижение счетчика
     //   countDownLatch.await(); //метод ожидает пока счетчик закончится в объекте
        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);

        countDownLatch.await(); //после выполнения 3х потоков счетчик достигает нуля и тело медода продолжает выполнение
        System.out.println("all job done");
    }
}
class Work extends Thread{
    CountDownLatch countDownLatch;

    public Work(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(300);
        } catch (InterruptedException e) {

        }
        System.out.println("done work");
        countDownLatch.countDown();
    }
}
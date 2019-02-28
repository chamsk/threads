import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierT {
    public static void main(String[] args) {
        //нужен для того чтоб собрать сколько то потоков и запустить/продолжить их одновременно
        //3 в конструкторе-кол-во потоков которые мы ждем, второй парамерт вызываемый поток
        //пример: олимпийцы бегут дистанцию, они должны начиннать вместе
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new Run());
        new Sportsman(cyclicBarrier);
        new Sportsman(cyclicBarrier);
        new Sportsman(cyclicBarrier);

    }
    static class Run extends Thread{
        CyclicBarrier cyclicBarrier;

        @Override
        public void run() {
            System.out.println("Run is begin");
        }
    }
    static class Sportsman extends Thread{
        CyclicBarrier cyclicBarrier;

        public Sportsman(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
            start();
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {

            }
        }
    }
}
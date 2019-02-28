import java.util.concurrent.Phaser;

public class PhaserT {
    public static void main(String[] args) {
        //нужен если в процессе жизненного цикла потока его нужно разбить на фазы и работать с объектом одновременно
        //???
        Phaser phaser = new Phaser(2);
        new Washer(phaser);
        new Washer(phaser);
    }

    static class Washer extends Thread{
        Phaser phaser;

        public Washer(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " washing the car");
                phaser.arriveAndAwaitAdvance();
            }

        }
    }
}
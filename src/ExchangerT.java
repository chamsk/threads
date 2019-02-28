import java.util.concurrent.Exchanger;

public class ExchangerT {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Mike(exchanger);
        new Anket(exchanger);

    }
    static class Mike extends Thread{
        //требуется для передачи между потоками
        Exchanger<String> exchanger;

        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("Hi my name is Mike");
                sleep(2000);
                exchanger.exchange("I'm 20 years old");
            } catch (InterruptedException e) {
            }
        }
    }
    static class Anket extends Thread{
        Exchanger<String> exchanger;

        public Anket(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println( exchanger.exchange(null));
                System.out.println( exchanger.exchange(null));
            } catch (InterruptedException e) {

            }
        }
    }
}
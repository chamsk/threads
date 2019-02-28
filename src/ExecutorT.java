import java.util.concurrent.*;

public class ExecutorT {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2); //создается пул потоков - 2 потока.
        //за счет executer'a потоки переиспользуются, как view в recyclerView
        executorService.submit(new MyRunnable());
        System.out.println(executorService.submit(new MyCallable()).get());
        executorService.shutdown();
    }

    static class  MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println(1);
        }
    }

    static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
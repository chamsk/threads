import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFuturetask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Cll cll = new Cll();
        FutureTask futureTask = new FutureTask(cll);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
    //интерфейс callable наследуется от Runnable - поэтому его можно использовать как поток
    // у него есть полезные методы такие как cancel() , iscancel() и другие
    static class Cll implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            int a = 0;
            for (int i = 0; i < 10; i++) {
                a++;
                Thread.sleep(200);
            }
            return a;
        }
    }
}
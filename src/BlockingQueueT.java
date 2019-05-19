import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Kor on 26.02.2019.
 */
public class BlockingQueueT {
    public static void main(String[] args) {
        //потокобезопасная очередь
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(queue.take()); //аналог remove() - удаляет элемент.
                    // Если в очереди нет элементов поток уходит в спящий режим -
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                queue.add("this is string");
            }
        }.start();
    }
}

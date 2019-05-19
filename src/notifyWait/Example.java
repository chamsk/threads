package notifyWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * чет не работает
 */
public class Example {
    static List<String> list = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args) {
        new Operator().start();
        new Machine().start();
    }
    static class Operator extends Thread{
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true){
                //синхронизируем по объектуу листю после добавления в лист сообщаем другому потоку что мы закончили
                synchronized(list) {
                    list.add(scanner.nextLine());
                    list.notify();
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class Machine extends Thread{
        @Override
        public void run() {
            while (list.isEmpty()){
                synchronized (list){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(list.remove(0));
                }
            }
        }
    }


}



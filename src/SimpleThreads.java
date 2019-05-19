import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kor on 21.02.2019.
 */
public class SimpleThreads {
    public static void main(String[] args) throws Exception{
        //первый способ
        MyThread thread = new MyThread();
        thread.start();
        //вход в поток - завершение потока после выполнения сценария этого потока
        thread.join();
        //имя треда
        System.out.println(Thread.currentThread().getName());

        //второй способ
        MyRunneble runneble = new MyRunneble();
        Thread thread2 = new Thread(runneble);
        thread2.start();


        //deadLock наступает если 2 потока пытаются обратиться к заблокированным мютексом ресурсам друг друга

        //потокобезопасные коллекции. работая с таким листом так же необходимо использовать synhronised методы
        List list = Collections.synchronizedList(new ArrayList<>());

        // interupt - прерывание потока

        //передача текущего метода из состояния Running в состояние Runnable
        //Thread.yield();

        //сон текущего потока
        //Thread.sleep(100);

        //назначение преоритета потоку от 1 до 10
        //thread.setPriority();

        //synhronysed - потокобезопасность вешается на медод, в блок синхронизации

        //нельзя в одном классе создать два блока synhronysed если один из них статический, а другой обычный
        //static synhronized ставит мютекс на весь класс, а обычный на объект класса

        //volotile - ключевое слово применяется к переменным, говорит потоку не записывать значение переменной
        // себе в кеш, а изменять переменную в основной памяти
        // так же используются атомарные переменные из пакета java.util.cuncurrent например AtomicInteger
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("to do");
    }
}

class MyRunneble implements Runnable{
    @Override
    public void run() {
        System.out.println("to do");
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                             wait and notify
//notify - текущий поток сообщает что закончил свою работу
//wait - поток пошел курить и джет notify другого потока


//ReentrantLock - может использоваться вместо synchronized плюсом является то, что мы может залочить несколько методов
//Lock lock = new ReentrantLock();
//    public void run() {
//        lock.lock();
//            for (int i = 0; i < 5; i++) {
//                total += i;
//                try {
//                    sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            notify();
//        lock.unlock();
//    }

// метод trylock объекта lock из примера выше позволяет проверять находится ли обеъкт залоченным
// Condition - аналог wait и notify для объекта lock
// Condition condition = lock.newCondition();
// condition.await() и condition.signal
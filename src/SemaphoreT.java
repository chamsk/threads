import java.util.concurrent.Semaphore;

public class SemaphoreT {
    public static void main(String[] args) {
        //семафор предназначен для предоставления доступа к русурсам.
        // Например потоки- это посетители, а столики в ресторане - это ресурсы
        Semaphore table = new Semaphore(2);         //создаем семафор из 2х столиков

        Person person = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();
        Person person7 = new Person();


        person.table = table;
        person2.table = table;
        person3.table = table;
        person4.table = table;
        person5.table = table;
        person6.table = table;
        person7.table = table;

        person.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
        person7.start();

    }

}
class Person extends Thread{
    Semaphore table;

    @Override
    public void run() {
        System.out.println(this.getName() + " waiting for table");
        try {
            table.acquire();                           //запрос на столик, ставим лок на ресурс
            System.out.println(this.getName() + " eat at the table");
            this.sleep(200);
            System.out.println(this.getName() + " release table");
            table.release();               //отпускаем лок на ресурс
        } catch (InterruptedException e) {

        }
    }
}
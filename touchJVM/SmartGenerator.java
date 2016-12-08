import java.util.LinkedList;
import java.util.List;

/**
 * Created by Max Shalavin on 08.12.2016.
 */
public class SmartGenerator extends Thread {
    // флаг остановки генерации.false перестает генерировать объекты
    public volatile boolean stopStartGeneration = true;
    private volatile String command = "0";//команда введенная с консоли
    List listObject = new LinkedList();//для сохранения ссылки на обьекты которые мы создали

    @Override
    public void run() {
        while (!command.equals("exit")) {
            if (command.equals("1")) {
                stopStartGeneration = true;
                createSimpleObject();
            }
            if (command.equals("2")) {
                stopStartGeneration = true;
                linkedcreateSimpleObject();
            }
            if (command.equals("clean")) {
                cleanCash();
            }
            //ставим wait что бы не прогонял цикл снова и снова пока пользователь не определился что ему запустить
            synchronized (Thread.currentThread()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        this.stopStartGeneration = false;
    }

    public void changeModeGeneration(String command) {
        this.command = command;
    }

    /**
     * Создаем наши обьекты в бесконечном цикле.Но при этом не сохраняем ссылки на них
     * Наш garbage collector будет их чистить.Так как ссылок на них нет
     */
    private void createSimpleObject() {
        while (stopStartGeneration) {
            new SimpleObject();
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Создаем обьекты но при этом сохраняем ссылки на них с помощью linkedList
     * Garbage Collector не иммеет права очищать эти обьекты так как на них есть ссылки
     */
    public void linkedcreateSimpleObject() {

        while (stopStartGeneration) {
            listObject.add(new SimpleObject());
        }
    }

    /**
     * Очищаем listObject тем самым разрешая Garbage Collector-у удалить обьекты
     */

    public void cleanCash() {
        listObject.clear();
    }
}

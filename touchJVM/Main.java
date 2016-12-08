import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Max Shalavin on 28.11.2016.
 */

/**
 * Для начала необходимо установить программу VisualVM и установить плагин VisualGС
 * для того что бы увидеть визуальное отображение памяти JVM
 */
public class Main {


    public static void main(String[] args) {
        /*Запускаем SmartGenerator отдельным потоком что бы MenegerConsole
        смог принимать команды во время генерации
        */
        SmartGenerator SmartGenerator = new SmartGenerator();
        SmartGenerator.start();
        ManagerConsole managerConsole = new ManagerConsole(SmartGenerator);
        managerConsole.readCommand();
    }

}

/**
 * Created by Max Shalavin on 28.11.2016.
 */

import java.util.Scanner;

/**
 * Этот класс будет отвечать за работу с пользователем(принимать команды) и управлять другими классами
 */
public class ManagerConsole {

    SmartGenerator smartGenerator;

    public ManagerConsole(SmartGenerator smartGenerator) {
        this.smartGenerator = smartGenerator;
    }

    public void readCommand() {
        System.out.println("1-objects withOUT links");
        System.out.println("2-objects with links");
        System.out.println("clean - allow to remove objects the Garbage Collector ");
        Scanner in = new Scanner(System.in);
        String s = "";
        while (!s.equals("exit")) {
            s = in.next();
            synchronized (smartGenerator) {
                smartGenerator.notify();
            }
            changeModeGeneration(s);
        }

        smartGenerator.changeModeGeneration("exit");
}

    private void changeModeGeneration(String s) {
        smartGenerator.stopStartGeneration = false;
        smartGenerator.changeModeGeneration(s);
    }

}

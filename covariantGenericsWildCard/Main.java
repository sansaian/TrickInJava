import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Shalavin on 23.11.2016.
 */

/**
 * Пример ковариации в массиве
 */
class MainA {
    public static void main(String[] args) {
        Cat [] cats = new Cat[2];
        Animal[] animals;
        animals = cats;
        Dog dog1 = new Dog();
        animals[0] = dog1;// ошибка при попытки выполнения
        /**
         * Так как наш массив является массивом обьекта Cat
         */



}
}

package tasks;

/**
 * Created by maksimsalavin on 13.11.2017.
 */
public class MainA {
    public static void main(String[] args)  {
        Integer i1 = Integer.valueOf(129);
        Integer i2 = Integer.valueOf(129);
        System.out.println(i1 == i2);

        Integer i3 = 2;
        Integer i4 = 2;
        System.out.println(i3 == i4);

    }
}
/* выведет false & tree при условии что по умолчанию java настроена.так у инта до 128 значения объекты кешируются */
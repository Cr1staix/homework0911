import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Integer countE = 1000000;
    static Integer RANDOM_VALUE = 100000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long resultAddStartElemArrList = addStartElements(arrayList);
        System.out.println("Время затраченное на добавление элементов в начало списка ArrayList - " + resultAddStartElemArrList);
        long resultAddStartElemLinkList = addStartElements(linkedList);
        System.out.println("Время затраченное на добавление элементов в начало списка LinkedList - " + resultAddStartElemLinkList);


        long resultEndElemArrList = addEndElements(arrayList);
        System.out.println("Время затраченное на добавление элементов в конец списка ArrayList - " + resultEndElemArrList);
        long resultEndElemLinkList = addEndElements(linkedList);
        System.out.println("Время затраченное на добавление элементов в конец списка LinkedList - " + resultEndElemLinkList);


        long resultGetRandomElemArrList = getRandomElement(arrayList);
        System.out.println("Время затраченное на выбор 100000 случайных элементов списка ArrayList - " + resultGetRandomElemArrList);
        long resultGetRandomElemLinkList = getRandomElement(linkedList);
        System.out.println("Время затраченное на выбор 100000 случайных элементов списка LinkedList - " + resultGetRandomElemLinkList);


        long[] values = new long[]{resultAddStartElemArrList, resultAddStartElemLinkList, resultEndElemArrList, resultEndElemLinkList,
                resultGetRandomElemLinkList, resultGetRandomElemArrList};

        System.out.println(getTimeResult(values));

    }

    public static long addEndElements(List<Integer> list) {
        LocalTime startTime = LocalTime.now();

        for (int i = 0; i <= countE; i++) {
            list.add(i);
        }
        LocalTime endTime = LocalTime.now();
        Duration time = Duration.between(startTime, endTime);
        long duration = time.toMillis();
        return duration;
    }

    public static long addStartElements(List<Integer> list) {
        LocalTime startTime = LocalTime.now();

        for (int i = 0; i <= countE; i++) {
            list.add(0, i);
        }
        LocalTime endTime = LocalTime.now();
        Duration time = Duration.between(startTime, endTime);
        long duration = time.toMillis();
        list.clear();
        return duration;
    }

    public static long getRandomElement(List<Integer> list) {
        LocalTime startTime = LocalTime.now();
        Random r = new Random();
        for (int i = 0; i < RANDOM_VALUE; i++) {
            list.get(r.nextInt(list.size()));
        }
        LocalTime endTime = LocalTime.now();
        Duration time = Duration.between(startTime, endTime);
        long duration = time.toMillis();
        return duration;
    }

    public static String getTimeResult(long[] values) {
        long min = values[0];
        long max = values[0];
        for (long elem : values) {
            if (elem > max) {
                max = elem;
            } else if (elem < min) {
                min = elem;
            }
        }
        return "Минимальное количество времени затраченное на операцию - " + min
                + "\nМаксимальное количество времени затраченное на операцию - " + max;
    }
}
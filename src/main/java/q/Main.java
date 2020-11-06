package q;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<MyCallable> taskList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            MyCallable myCallable = new MyCallable();
            taskList.add(myCallable);
        }

       /*
        List<Future<Integer>> resultList = null;   //для демонстрации ответа от всех задач
        try {
            resultList = threadPool.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < resultList.size(); i++) {
            int y = i + 1;
            System.out.println("Поток-" + y + " " + resultList.get(i).get() + " сообщения");
        }
        */


           int resultList2 = 0;  //для демонстрации ответа от одной задачи
        try {
            resultList2 = threadPool.invokeAny(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Самый быстрый поток-" + " " + resultList2 + " сообщения");

    }
}

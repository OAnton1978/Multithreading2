package q;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        int i = 0;
        int countMessage = 0;
        try {
            while (i < 2) {
                i++;
                Thread.sleep(2500);
                System.out.println("Всем привет! Я поток " + Thread.currentThread().getName());
                countMessage = countMessage + 1;
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        return countMessage;
    }
}
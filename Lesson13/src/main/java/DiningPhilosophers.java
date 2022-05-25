import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiningPhilosophers {
    public static void main(String[] args) {
        int cyclesCount = 1;
        int expectedPhilosopher = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < cyclesCount; i++) {
            executorService.execute(new Philosopher(expectedPhilosopher));
            executorService.execute(new Philosopher((expectedPhilosopher + 2)%5));
            executorService.execute(new Philosopher((expectedPhilosopher + 1)%5));
            executorService.execute(new Philosopher((expectedPhilosopher + 3)%5));
            executorService.execute(new Philosopher((expectedPhilosopher + 4)%5));
            expectedPhilosopher = (expectedPhilosopher + 1)%5;
        }

        executorService.shutdown();
    }
}

class Philosopher implements Runnable {
    private int index;
    static private ArrayList forks = new ArrayList(List.of(0, 1, 2, 3, 4));

    Philosopher(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        synchronized (forks.get(index% 5)) {
            System.out.println("Философ " + index + " берёт вилку № " + (index));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (forks.get((index + 1) % 5)) {
                System.out.println("Философ " + index + " берёт вилку № " + (index + 1)%5);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Философ " + index + " ест ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Философ " + index + " кладёт вилку № " + (index + 1)%5);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Философ " + index + " кладёт вилку № " + (index));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

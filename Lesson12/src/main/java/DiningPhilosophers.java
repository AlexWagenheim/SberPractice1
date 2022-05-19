import java.util.ArrayList;
import java.util.LinkedList;

public class DiningPhilosophers implements Runnable{
    static private ArrayList forks = new ArrayList();
    static private LinkedList<Thread> philosophers = new LinkedList();
    static private ArrayList<Integer> score = new ArrayList<>();
    static private int expectedPhilosopher;
    static private Object valve;

    static void runPhilosopher(int n) {
        philosophers.get(n).start();
    }

    static synchronized void incScore(int n) {
        score.set(n, score.get(n) + 1);
    }

    @Override
    public void run() {
         if (((expectedPhilosopher + 1)%5 == Integer.parseInt(Thread.currentThread().getName())) ||
                 ((expectedPhilosopher + 4)%5 == Integer.parseInt(Thread.currentThread().getName())) ||
                 ((expectedPhilosopher + 3)%5 == Integer.parseInt(Thread.currentThread().getName()))) {
            try {
                Thread.sleep(4000);
                if ((expectedPhilosopher + 4)%5 == Integer.parseInt(Thread.currentThread().getName())) {
                    Thread.sleep(4000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (forks.get((Integer.parseInt(Thread.currentThread().getName())) % 5)) {
            int current = Integer.parseInt(Thread.currentThread().getName());
            System.out.println("Философ " + current + " берёт вилку № " + (current));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (forks.get((current + 1) % 5)) {
                System.out.println("Философ " + current + " берёт вилку № " + (current + 1)%5);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Философ " + current + " ест ");
                incScore(current);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Философ " + current + " кладёт вилку № " + (current + 1)%5);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Философ " + current + " кладёт вилку № " + (current));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        forks.add(new Object());
        forks.add(new Object());
        forks.add(new Object());
        forks.add(new Object());
        forks.add(new Object());
        valve = new Object();
        expectedPhilosopher = 0;

        DiningPhilosophers dinner = new DiningPhilosophers();

        score.add(0);
        score.add(0);
        score.add(0);
        score.add(0);
        score.add(0);

        int cyclesCount = 5;

        for (int i = 0; i < cyclesCount; i++) {

            for (int j = 0; j < 5; j++) {
                philosophers.add(new Thread(dinner, Integer.toString(j)));
            }

            for (int j = 0; j < 5; j++) {
                runPhilosopher(j);
            }

            for (int j = 0; j < 5; j++) {
                philosophers.get(j).join();
            }

            philosophers.clear();
            expectedPhilosopher = (expectedPhilosopher + 1)%5;
        }

        System.out.println();
        System.out.println("Обед завершён");
        System.out.println();
        System.out.println("Количество приёмов пищи: ");

        for (int i = 0; i < score.size(); i++) {
            System.out.println("Философ " + i + ": " + score.get(i));
        }
    }
}

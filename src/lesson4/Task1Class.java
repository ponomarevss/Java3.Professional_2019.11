package lesson4;

public class Task1Class {

    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';
    private static final int RUNS = 5;

    public static void main(String[] args) {
        Task1Class w = new Task1Class();
        Thread t1 = new Thread(() -> {
            w.print('A', 'B');
        });
        Thread t2 = new Thread(() -> {
            w.print('B', 'C');
        });
        Thread t3 = new Thread(() -> {
            w.print('C', 'A');
        });
        t1.start();
        t2.start();
        t3.start();
    }

/*
    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < RUNS; i++) {
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < RUNS; i++) {
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < RUNS; i++) {
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
*/

    public void print(char currentLetter0, char currentLetter1) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < RUNS; i++) {
                    while (currentLetter != currentLetter0) {
                        monitor.wait();
                    }
                    System.out.print(currentLetter0);
                    currentLetter = currentLetter1;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

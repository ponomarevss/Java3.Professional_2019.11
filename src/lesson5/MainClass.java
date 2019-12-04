package lesson5;


import javax.sound.midi.Soundbank;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static String winnerName;
    public static final CountDownLatch getReady = new CountDownLatch(CARS_COUNT);
    public static final CyclicBarrier raceStart = new CyclicBarrier(CARS_COUNT + 1);
    public static final CountDownLatch raceWinner = new CountDownLatch(1);
    public static final CyclicBarrier raceOver  = new CyclicBarrier(CARS_COUNT + 1);
    public static final Semaphore smp = new Semaphore(CARS_COUNT / 2);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            getReady.await();
            Thread.sleep(1000);
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            raceStart.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        try {
            raceWinner.await();
            System.out.println(winnerName + " WIN");
            raceOver.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

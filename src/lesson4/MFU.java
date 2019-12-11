package lesson4;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MFU {
    private int toPrint;
    private int toScan;
    private final Object output = new Object();
    private ExecutorService printES = Executors.newCachedThreadPool();
    private ExecutorService scanES = Executors.newCachedThreadPool();
    private Semaphore printSmp = new Semaphore(1);
    private Semaphore scanSmp = new Semaphore(1);


    @FXML
    public TextField printField;

    @FXML
    public TextField scanField;

    @FXML
    private void print() {
            toPrint = 0;
        if (!printField.getText().trim().isEmpty()) {
            try {
                toPrint = Integer.parseInt(printField.getText());
            } catch (NumberFormatException e) {
                System.err.println("Введите количество страниц от 1");
                //            e.printStackTrace();
            } finally {
                printField.clear();
            }
            System.out.println(String.format("Получено задание на печать %s страниц", toPrint));
            printES.execute(new Runnable() {
                @Override
                public void run() {
                    int pagesToPrint = toPrint;
                    try {
                        printSmp.acquire();
                        System.out.println(String.format("Выполняется печать %s страниц", pagesToPrint));
                        for (int i = 1; i <= pagesToPrint; i++) {
                            synchronized (output) {
                                System.out.println(String.format("Печать страницы %s из %s", i, pagesToPrint));
                                Thread.sleep(500);
                            }
                            Thread.sleep(1);
                        }
                        System.out.println(String.format("Печать %s страниц окончена", pagesToPrint));
                        printSmp.release();
                    } catch (InterruptedException e) {
    //                e.printStackTrace();
                        System.err.println("Печать прервана");
                    }
                }
            });
        }
    }

    @FXML
    private void scan() {
        toScan = 0;
        if (!scanField.getText().trim().isEmpty()) {
            try {
                toScan = Integer.parseInt(scanField.getText());
            } catch (NumberFormatException e) {
                System.err.println("Введите количество страниц от 1");
                //            e.printStackTrace();
            } finally {
                scanField.clear();
            }
            System.out.println(String.format("Получено задание на сканирование %s страниц", toScan));
            scanES.execute(new Runnable() {
                @Override
                public void run() {
                    int pagesToScan = toScan;
                    try {
                        scanSmp.acquire();
                        System.out.println(String.format("Выполняется сканирование %s страниц", pagesToScan));
                        for (int i = 1; i <= pagesToScan; i++) {
                            synchronized (output) {
                                System.out.println(String.format("Сканирование страницы %s из %s", i, pagesToScan));
                                Thread.sleep(500);
                            }
                            Thread.sleep(1);
                        }
                        System.out.println(String.format("Сканирование %s страниц окончено", pagesToScan));
                        scanSmp.release();
                    } catch (InterruptedException e) {
                        System.err.println("Сканирование прервано");
                    }
                }
            });
        }
    }

    void shutdown() {
        printES.shutdownNow();
        scanES.shutdownNow();
    }
}

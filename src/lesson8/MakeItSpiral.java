package lesson8;

import java.util.Arrays;
import java.util.Scanner;

public class MakeItSpiral {

    private static int stepCounter; //счетчик шагов
    private static int counter; //счетчик
    private static int ic; // текущий индекс строки
    private static int jc; // текущий индекс столбца
    private static final int[][] k = new int[][] {{0, 1},{1, 0},{0, -1},{-1, 0}}; //массив коэффициентов инкрементирования
    private static boolean run = true;

    public static void main(String[] args) {
        while (run) {
            makeItSpiral();
        }
    }

    private static void makeItSpiral() {
        stepCounter = 0;
        counter = 0;
        ic = 0;
        jc = 0;

        int[] size = getSize();
        int horizontalLength = size[1];
        int verticalLength = size[0];
        int[][] arrBySize = new int[size[0]][size[1]];

        fillWithZeroes(arrBySize);

        while (horizontalLength > 0 && verticalLength > 0) {
            switch (stepCounter % 4) {
                case 0:
                    fillWithCounter(arrBySize, horizontalLength);
                    ic++;
                    verticalLength--;
                    break;
                case 1:
                    fillWithCounter(arrBySize,verticalLength);
                    jc--;
                    horizontalLength--;
                    break;
                case 2:
                    fillWithCounter(arrBySize, horizontalLength);
                    ic--;
                    verticalLength--;
                    break;
                case 3:
                    fillWithCounter(arrBySize, verticalLength);
                    jc++;
                    horizontalLength--;
                    break;
            }
            stepCounter++;
        }
        print(arrBySize);
    }

    private static void fillWithCounter(int[][] arrBySize, int length) {
        for (int i = 0; i < length; i++) {
            counter++;
            arrBySize[ic][jc] = counter;
            ic = ic + k[stepCounter % 4][0];
            jc = jc + k[stepCounter % 4][1];
        }
        ic = ic - k[stepCounter % 4][0];
        jc = jc - k[stepCounter % 4][1];
    }

    private static void fillWithZeroes(int[][] arrBySize) {
        for (int[] ints : arrBySize) {
            Arrays.fill(ints, 0);
        }
    }


    private static int[] getSize() {
        Scanner scanner = new Scanner(System.in);
        int[] size = new int[]{0, 0};
        do {
            System.out.println("Введите размер двухмерного массива в формате [столбцов]х[строк]: ");
            String input;
            input = scanner.nextLine().toLowerCase();
            if (input.equals("q")) {
                scanner.close();
                run = false;
                break;
            }
            String[] strCoords = input.split("x");
            try {
                size[1] = Integer.parseInt(strCoords[0]);
                size[0] = Integer.parseInt(strCoords[1]);
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат данных!");
//                e.printStackTrace();
            }
        } while (!(size[0] > 0 && size[1] > 0));
        return size;
    }

    private static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print(System.lineSeparator());
        }
    }
    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "\t");
        }
        System.out.print(System.lineSeparator());

    }



}

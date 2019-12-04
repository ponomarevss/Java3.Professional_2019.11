package lesson6;

public class Task2 {

    public static void main(String[] args) {
        int arr[] = new int[]{23, 46, 1, 7, 11, 456, 4, 4, 123, 156, 75, 46, 1, 11};
        int newArr[] = modifyIt(arr);
        int arrToCheck[] = new int[]{1, 1, 1, 4, 4, 4, 1};


        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + "\t");
        }
        System.out.println();
        System.out.println(isPresent(arrToCheck));
    }

    public static int[] modifyIt(int[] arr) {
        int lastFourIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                lastFourIndex = i;
            }
        }
        if (lastFourIndex == -1){
            throw new RuntimeException("Массив не содержит элемента со значением 4");

        }
        int[] newArr = new int[arr.length - (lastFourIndex + 1)];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[(lastFourIndex + 1) + i];
        }
        return newArr;
    }

    public static boolean isPresent(int[] arr) {
        boolean checkOne = false;
        boolean checkFour = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                throw new RuntimeException("Массив содержит недопустимые данные");
            }
            if (arr[i] == 1) {
                checkOne = true;
            }
            if (arr[i] == 4) {
                checkFour = true;
            }
        }
        return checkOne && checkFour;
    }
    
}

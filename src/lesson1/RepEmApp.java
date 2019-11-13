package lesson1;

public class RepEmApp {
    public static void main(String[] args) {
        TaskGeneric<Integer> integerRep = new TaskGeneric<>(1, 2, 3, 4, 5);
        TaskGeneric<Double> doubleRep = new TaskGeneric<>(1.0, 2.0, 3.3, 4.4, 5.5);
        TaskGeneric<Float> floatRep = new TaskGeneric<>(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        TaskGeneric<String> stringRep = new TaskGeneric<>("1", "2", "3", "4", "5");

        integerRep.replaceThem(1, 3);
        integerRep.show();
        System.out.println(integerRep.toArrayList());

        doubleRep.replaceThem(0, 2);
        doubleRep.show();
        System.out.println(doubleRep.toArrayList());

        floatRep.replaceThem(4, 0);
        floatRep.show();
        System.out.println(floatRep.toArrayList());

        stringRep.replaceThem(4, 3);
        stringRep.show();
        System.out.println(stringRep.toArrayList());
    }

}

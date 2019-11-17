package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskGeneric<T> {
    private T[] object;

    public TaskGeneric(T... object) {
        this.object = object;
    }

    public T[] getObject() {
        return object;
    }


    public T[] replaceThem(int i0, int i1) {
        try {
            T buffer = object[i1];
            object[i1] = object[i0];
            object[i0] = buffer;
        } catch (Exception e) {
            System.err.println(String.format("incorrect index. maximum index is %s", object.length - 1));
//            e.printStackTrace();
        }
        return object;
    }

    public void show() {
        for (T o : object) System.out.print(o + "\t");
        System.out.println();
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> objectArrayList = new ArrayList<>(Arrays.asList(object));
        return objectArrayList;
    }

}

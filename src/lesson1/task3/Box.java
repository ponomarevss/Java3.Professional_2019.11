package lesson1.task3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> list;

    public Box(T... fruits) {
        list = new ArrayList<>(Arrays.asList(fruits));
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void addFruit (T fruit) {
        list.add(fruit);
    }

    public float getWeight() {
        return list.get(0).getWeight() * list.size();
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void transfer (Box anotherBox) {
        anotherBox.list.clear();
//        for (T o: this.list) {
//            anotherBox.list.add(o);
//        }
        anotherBox.list.addAll(this.list);
        this.list.clear();
    }
}

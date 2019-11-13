package lesson1;

public class ReplaceThem<T> {
    private T[] object;

    public ReplaceThem(T... object) {
        this.object = object;
    }

    public T[] getObject() {
        return object;
    }

}

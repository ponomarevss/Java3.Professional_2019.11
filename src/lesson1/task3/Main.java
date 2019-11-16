package lesson1.task3;

public class Main {
    public static void main(String[] args) {
        Box<Apple>  box1 = new Box<>();
        Box<Orange> box2 = new Box<>();

        for (int i = 0; i < 3; i++) {
            box1.addFruit(new Apple());
        }
        for (int i = 0; i < 2; i++) {
            box2.addFruit(new Orange());
        }

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box1.compare(box2));

        System.out.println(box1.getList());
        System.out.println(box2.getList());
        box1.transfer(box2);
        System.out.println(box1.getList());
        System.out.println(box2.getList());

    }
}

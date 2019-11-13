package lesson1;

public class RepEmApp {
    public static void main(String[] args) {
        ReplaceThem<Integer> integerRep = new ReplaceThem<>(1, 2, 3, 4, 5);
        ReplaceThem<Double> doubleRep = new ReplaceThem<>(1.0, 2.0, 3.3, 4.4, 5.5);
        ReplaceThem<Float> floatRep = new ReplaceThem<>(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        ReplaceThem<String> stringRep = new ReplaceThem<>("1", "2", "3", "4", "5");

        replaceThem(integerRep, 1, 3);
    }

    public static ReplaceThem[] replaceThem(ReplaceThem[] replaceThem, int i0, int i1) {
        try {
            ReplaceThem<?> buffer = replaceThem[i1];
            replaceThem[i1] = replaceThem[i0];
            replaceThem[i0] = buffer;
        } catch (Exception e) {
            System.err.println("incorrect index");
//            e.printStackTrace();
        }
        return replaceThem;
    }

}

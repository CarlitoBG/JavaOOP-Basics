package p05_random_arraylist;

public class Main {
    public static void main(String[] args) {

        RandomArrayList ral = new RandomArrayList();
        ral.add("a");
        ral.add(3);
        ral.add("b");
        ral.add(4);
        ral.add("c");
        ral.add(5);
        ral.add("d");
        ral.add(6);
        System.out.println(ral.getRandomElement());
        System.out.println(ral);
    }
}
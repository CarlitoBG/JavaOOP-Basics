package p05_random_arraylist;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<Object> extends ArrayList{
    Random rnd = new Random();

    public Object getRandomElement(){
        int index = rnd.nextInt(super.size());
        Object element = (Object) super.get(index);
        super.set(index, super.remove(super.size() - 1));
        return element;
    }
}
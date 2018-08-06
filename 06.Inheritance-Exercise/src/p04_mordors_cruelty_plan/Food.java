package p04_mordors_cruelty_plan;

import java.util.HashMap;
import java.util.Map;

public class Food {

    private static final int EVERYTHING_ELSE = - 1;
    private static final Map<String, Integer> FOOD_IMPACT = new HashMap<>();
    static {
        FOOD_IMPACT.put("cram", 2);
        FOOD_IMPACT.put("lembas", 3);
        FOOD_IMPACT.put("apple", 1);
        FOOD_IMPACT.put("melon", 1);
        FOOD_IMPACT.put("honeycake", 5);
        FOOD_IMPACT.put("mushrooms", -10);
    }

    private String name;

    Food(String name) {
        this.name = name;
    }

    int getHappiness(){
        if (FOOD_IMPACT.containsKey(this.name.toLowerCase())){
            return FOOD_IMPACT.get(this.name.toLowerCase());
        }
        return EVERYTHING_ELSE;
    }
}
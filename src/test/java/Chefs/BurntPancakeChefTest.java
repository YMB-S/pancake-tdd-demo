package Chefs;

import BakedGoods.BurntPancake;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BurntPancakeChefTest {
    @Test
    void burntPancakesAllFaceDownWhenSorted(){
        BurntPancakeChef chef = new BurntPancakeChef();
        chef.prepare();
        ArrayList<BurntPancake> pancakes = chef.serveSorted();

        for(int i = 0; i < pancakes.size(); i++){
            if(!pancakes.get(i).isBurntSideDown()) { fail("Not all burnt pancakes are burnt side down.\n" +
                    "Pancakes: " + pancakes.toString()); }
        }
    }

    @Test
    @EnabledIf("distinctSizes")
    void burntPancakesHaveDistinctSizes(){
        BurntPancakeChef chef = new BurntPancakeChef();
        chef.prepare();
        ArrayList<BurntPancake> pancakes = chef.getPlate();

        ArrayList<Integer> encounteredSizes = new ArrayList<>();
        for(BurntPancake pancake : pancakes){
            if(encounteredSizes.contains(pancake.getSize())) { fail("Encountered same pancake size twice: " + pancake.getSize()); }

            encounteredSizes.add(pancake.getSize());
        }
    }

    boolean distinctSizes(){
        return BurntPancakeChef.hasDistinctSizes();
    }
}

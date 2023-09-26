package Chefs;

import BakedGoods.BakedGood;
import BakedGoods.Pancake;
import Sorters.PancakeSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PancakeChef implements IChef<Pancake>{

    public final static boolean COOK_DISTINCT_SIZES = true;
    private final static int MIN_PANCAKE_AMOUNT = 1;
    private final static int MAX_PANCAKE_AMOUNT = 25;

    private ArrayList<Pancake> pancakes;

    @Override
    public void prepare() {
        pancakes = new ArrayList<>();
        Random r = new Random(100);                                        // We have a deterministic pancake chef! She is very skilled
        int amtOfPancakes = r.nextInt(MIN_PANCAKE_AMOUNT, MAX_PANCAKE_AMOUNT);  // Make a random amount of pancakes

        for(int i = 0; i< amtOfPancakes; i++){                                  // Create each pancake with a different size
            pancakes.add(new Pancake(i + 1));
        }

        Collections.shuffle(pancakes);                                          // Our chef is sloppy, so we shuffle the stack of pancakes
    }

    @Override
    public ArrayList<Pancake> serveSorted() {
        return PancakeSorter.getInstance().sort(pancakes);
    }

    @Override
    public ArrayList<Pancake> getPlate() {
        return pancakes;
    }
}

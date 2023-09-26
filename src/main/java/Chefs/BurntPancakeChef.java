package Chefs;

import BakedGoods.BakedGood;
import BakedGoods.BurntPancake;
import BakedGoods.Pancake;
import Sorters.BurntPancakeSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BurntPancakeChef implements IChef<BurntPancake>{

    private final static boolean COOK_DISTINCT_SIZES = false;
    public static boolean hasDistinctSizes() { return COOK_DISTINCT_SIZES;}
    private final static int MIN_PANCAKE_AMOUNT = 1;
    private final static int MAX_PANCAKE_AMOUNT = 100;

    private ArrayList<BurntPancake> pancakes;
    @Override
    public void prepare() {
        pancakes = new ArrayList<>();
        Random r = new Random(100);                                        // We have a deterministic pancake chef! She is very skilled
        int amtOfPancakes = r.nextInt(MIN_PANCAKE_AMOUNT, MAX_PANCAKE_AMOUNT);  // Make a random amount of pancakes

        for(int i = 0; i< amtOfPancakes; i++){                                  // Create each pancake with a different size
            BurntPancake pancake = new BurntPancake(getNextSize(i));
            if(r.nextBoolean()){ pancake.flip(); }                              // This chef is kinda bad, she burns every pancake and randomly flips them!
            pancakes.add(pancake);
        }

        Collections.shuffle(pancakes);                                          // Our chef is sloppy, so we shuffle the stack of pancakes
    }

    @Override
    public ArrayList<BurntPancake> serveSorted() {
        return BurntPancakeSorter.getInstance().sort(this.pancakes);
    }

    @Override
    public ArrayList<BurntPancake> getPlate() { return this.pancakes; }

    private int getNextSize(int index){
        if(COOK_DISTINCT_SIZES){
            return index + 1;
        }
        else{
            return (index % 3) + 1;
        }
    }
}

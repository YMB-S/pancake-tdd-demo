package Sorters;

import BakedGoods.BurntPancake;
import BakedGoods.BakedGood;
import BakedGoods.Pancake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class BurntPancakeSorter implements IBakedGoodSorter<BurntPancake>{

    private static BurntPancakeSorter instance = null;
    public static BurntPancakeSorter getInstance() {
        if(instance == null){
            instance = new BurntPancakeSorter();
        }
        return instance;
    }

    @Override
    public ArrayList<BurntPancake> sort(ArrayList<BurntPancake> toSort) {
        for ( int i = toSort.size() - 1; i >= 0; i-- ) {
            // Find the index of the largest Pancake in our current substack
            int index = IntStream.rangeClosed(0, i).boxed().max(Comparator.comparing(toSort::get)).get();

            // If the biggest Pancake isn't at the end yet, place it at the end
            if ( index != i ) {
                flip(toSort, index); // First put the largest Pancake at the top
                flip(toSort, i);     // Then flip the stack so that the largest currently unsorted pancake is at the bottom of our substack
            }
        }

        // We also have to make sure each pancake is facing with its burnt side down
        for(BurntPancake pancake : toSort){
            if(!pancake.isBurntSideDown()){ pancake.flip();}
        }

        return toSort;
    }

    private void flip(ArrayList<BurntPancake> toFlip, int index) {
        if (index > 0 ) {
            Collections.reverse(toFlip.subList(0, index + 1));  // Flip a selection of a stack of Pancakes
        }
    }
}

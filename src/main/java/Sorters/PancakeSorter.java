package Sorters;

import BakedGoods.BakedGood;
import BakedGoods.Pancake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

public class PancakeSorter implements IBakedGoodSorter<Pancake> {

    private static PancakeSorter instance = null;
    public static PancakeSorter getInstance() {
        if(instance == null){
            instance = new PancakeSorter();
        }
        return instance;
    }

    @Override
    public ArrayList<Pancake> sort(ArrayList<Pancake> toSort) {
        for ( int i = toSort.size() - 1; i >= 0; i-- ) {
            // Find the index of the largest Pancake that is currently unsorted
            int index = IntStream.rangeClosed(0, i).boxed().max(Comparator.comparing(toSort::get)).get();

            // If the biggest Pancake isn't at the end yet, place it at the end
            if ( index != i ) {
                flip(toSort, index); // First put the largest Pancake at the top
                flip(toSort, i);     // Then flip the stack so that the largest currently unsorted pancake is at the bottom of our substack
            }
        }
        return toSort;
    }

    private void flip(ArrayList<Pancake> toFlip, int index) {
        if (index > 0 ) {
            Collections.reverse(toFlip.subList(0, index + 1));  // Flip a selection of a stack of Pancakes
        }
    }
}

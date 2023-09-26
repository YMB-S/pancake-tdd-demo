package Sorters;

import BakedGoods.Pizza;

import java.util.ArrayList;

public class PizzaSorter implements IBakedGoodSorter<Pizza> {

    private static PizzaSorter instance = null;
    public static PizzaSorter getInstance() {
        if(instance == null){
            instance = new PizzaSorter();
        }
        return instance;
    }

    @Override
    public ArrayList<Pizza> sort(ArrayList<Pizza> toSort) {
        // Pizzas cannot be flipped, as it would cause their toppings to fall off...
        // Pizzas instead swap places with one another

        int n = toSort.size();
        Pizza temp = null;

        for(int i = 0; i < n; i++){                 // Bubble sort for Pizzas
            for(int j = 1; j < (n - i); j++){

                Pizza current = toSort.get(j-1);
                Pizza next = toSort.get(j);

                if(Integer.compare(current.getSize(), next.getSize()) > 0){
                    temp = current;
                    toSort.set(j-1, next);
                    toSort.set(j, temp);
                }
            }
        }
        return toSort;
    }
}

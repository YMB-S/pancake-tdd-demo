package Chefs;

import BakedGoods.Pizza;
import Sorters.PizzaSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PizzaChef implements IChef<Pizza> {

    private static final int AMT_OF_PIZZAS = 100; // Who doesn't like pizza?
    private static final int MIN_PIZZA_SIZE = 5;
    private static final int MAX_PIZZA_SIZE = 50;
    private ArrayList<Pizza> pizzas;
    @Override
    public void prepare() {
        pizzas = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < AMT_OF_PIZZAS; i++){
            pizzas.add(new Pizza(random.nextInt(MIN_PIZZA_SIZE, MAX_PIZZA_SIZE)));
        }
        Collections.shuffle(pizzas);
    }

    @Override
    public ArrayList<Pizza> serveSorted() {
        return PizzaSorter.getInstance().sort(pizzas);
    }

    @Override
    public ArrayList<Pizza> getPlate() {
        return pizzas;
    }
}

package Chefs;

import BakedGoods.BakedGood;

import java.util.ArrayList;

public interface IChef<T extends BakedGood> {
    public void prepare();

    public ArrayList<T> serveSorted();

    public ArrayList<T> getPlate();
}

package Sorters;

import BakedGoods.BakedGood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IBakedGoodSorter<T extends BakedGood> {

    ArrayList<T> sort(ArrayList<T> toSort);
}
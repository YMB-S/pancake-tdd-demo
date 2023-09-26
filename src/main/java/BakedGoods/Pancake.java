package BakedGoods;

public class Pancake extends BakedGood {

    public Pancake(int size) {
        super(size);
    }

    @Override
    public String toString(){
        return "Pancake" + super.toString();
    }
}

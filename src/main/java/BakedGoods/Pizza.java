package BakedGoods;

public class Pizza extends BakedGood{
    public Pizza(int size) {
        super(size);
    }

    @Override
    public String toString(){
        return "Pizza" + super.toString();
    }
}

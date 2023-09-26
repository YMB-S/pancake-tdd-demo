package BakedGoods;

public class BurntPancake extends BakedGood {

    private boolean isBurntSideDown;

    public BurntPancake(int size) {
        super(size);
    }

    public void flip(){
        isBurntSideDown = !isBurntSideDown;
    }

    @Override
    public String toString(){
        return "Burnt Pancake" + super.toString() + " burnt side " + (isBurntSideDown? "down" : "up");
    }

    public boolean isBurntSideDown() { return isBurntSideDown; }
}

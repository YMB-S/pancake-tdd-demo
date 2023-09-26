package BakedGoods;

public abstract class BakedGood implements Comparable<BakedGood>{

    private int size;

    public BakedGood (int size){
        if(size <= 0){
            throw new IllegalArgumentException("Baked Good cannot have zero or negative size");
        }
        this.size = size;
    }

    public int getSize() { return this.size; }

    @Override
    public int compareTo(BakedGood o) {
        return Integer.compare(this.size, o.size);
    }

    @Override
    public String toString(){
        return " size " + getSize();
    }
}

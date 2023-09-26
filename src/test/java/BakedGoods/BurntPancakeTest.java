package BakedGoods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BurntPancakeTest {
    @Test
    void burntPancakeCanBeFlipped(){
        BurntPancake pancake = new BurntPancake(10);

        boolean initialState = pancake.isBurntSideDown();

        pancake.flip();
        boolean flippedState = pancake.isBurntSideDown();

        assertNotEquals(initialState, flippedState);
    }
}

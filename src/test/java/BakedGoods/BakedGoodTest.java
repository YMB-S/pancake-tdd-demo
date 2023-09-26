package BakedGoods;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class BakedGoodTest {

    private static final int TEST_PANCAKE_SIZE = 5;
    private static final int TEST_BURNT_PANCAKE_SIZE = 10;
    private static final int TEST_PIZZA_SIZE = 20;

    @ParameterizedTest
    @MethodSource("provideBakedGoodsUnderTest")
    public void bakedGoodsHaveCorrectSize(List<BakedGood> bakedGoods){
        assertEquals(TEST_PANCAKE_SIZE,         bakedGoods.get(0).getSize());
        assertEquals(TEST_BURNT_PANCAKE_SIZE,   bakedGoods.get(1).getSize());
        assertEquals(TEST_PIZZA_SIZE,           bakedGoods.get(2).getSize());
    }

    @ParameterizedTest
    @MethodSource("provideBakedGoodsUnderTest")
    public void bakedGoodsCanBeCompared(List<BakedGood> bakedGoods){
        Pancake pancake = (Pancake) bakedGoods.get(0);
        BurntPancake burntPancake = (BurntPancake) bakedGoods.get(1);
        Pizza pizza = (Pizza) bakedGoods.get(2);

        int smaller = pancake.compareTo(burntPancake);
        int equal = burntPancake.compareTo(burntPancake);
        int larger = pizza.compareTo(burntPancake);

        assertEquals(-1, smaller);
        assertEquals(0, equal);
        assertEquals(1, larger);
    }

    @ParameterizedTest
    @MethodSource("provideBakedGoodsUnderTest")
    public void bakedGoodsCannotHaveNegativeSize(List<BakedGood> bakedGoods) {

        // We copy the class of whatever BakedGood gets passed in, and we try to instantiate a new object of that class
        // In case an illegal constructor argument gets passed, this fails and it throws an InvocationTargetException
        Exception exception = assertThrows(InvocationTargetException.class, () -> {
            for(BakedGood bakedGood : bakedGoods){
                BakedGood newGood = bakedGood.getClass().getDeclaredConstructor(int.class).newInstance(-1);
            }
        });

        String expected = "Baked Good cannot have zero or negative size";

        assertTrue(exception.getCause().toString().contains(expected));
    }

    static Stream<List<BakedGood>> provideBakedGoodsUnderTest(){
        return Stream.of(
                List.of(
                    new Pancake(TEST_PANCAKE_SIZE),
                    new BurntPancake(TEST_BURNT_PANCAKE_SIZE),
                    new Pizza(TEST_PIZZA_SIZE))
        );
    }
}

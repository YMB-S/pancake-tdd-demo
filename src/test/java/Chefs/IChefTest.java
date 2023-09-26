package Chefs;

import BakedGoods.BakedGood;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class IChefTest {

    @ParameterizedTest
    @MethodSource("provideChefUnderTest")
    public void chefsSortBakedGoodsCorrectly(IChef chefUnderTest){
        chefUnderTest.prepare();
        ArrayList<BakedGood> bakedGoods = chefUnderTest.serveSorted();  // Prepare the baked goods

        String sortedByChef = bakedGoods.toString();                    // Have the Chef sort them
        Collections.sort(bakedGoods);                                   // And also get the baked goods sorted by Collections
        String sortedByCollections = bakedGoods.toString();

        assertEquals(sortedByChef, sortedByCollections);                // The two are equal to each other if the Chef sorts correctly
    }

    @ParameterizedTest
    @MethodSource("provideChefUnderTest")
    public void platesStartOutUnsorted(IChef chefUnderTest){
        chefUnderTest.prepare();                                        // Prepare the baked goods

        ArrayList<BakedGood> bakedGoods = chefUnderTest.getPlate();     // Get the plate as-is, without sorting by the Chef
        String unsorted = bakedGoods.toString();

        Collections.sort(bakedGoods);                                   // Have the baked goods sorted by Collections
        String sorted = bakedGoods.toString();

        assertNotEquals(sorted, unsorted);                              // As long as the Chef starts out without sorting, these will not equal each other
    }

    static Stream<? extends IChef> provideChefUnderTest(){
        // Return an instance of each class that implements IChef, in order to test the methods implemented by the classes
        return Stream.of(
                new PancakeChef(),
                new BurntPancakeChef(),
                new PizzaChef()
        );
    }
}

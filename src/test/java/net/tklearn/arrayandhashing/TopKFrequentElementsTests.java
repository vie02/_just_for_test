package net.tklearn.arrayandhashing;

import org.junit.jupiter.api.Test;

import static net.tklearn.arrayandhashing.TopKFrequentElements.topKFrequent;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopKFrequentElementsTests {

    @Test
    public void testTopKFrequent() {
        assertArrayEquals(topKFrequent((new int[]{1, 1, 1, 2, 2, 3}), 2), new int[]{1, 2});
        assertArrayEquals(topKFrequent((new int[]{5,2,5,3,5,3,1,1,3}), 2), new int[]{3, 5});
        assertArrayEquals(topKFrequent((new int[]{1}), 1), new int[]{1});
    }
}

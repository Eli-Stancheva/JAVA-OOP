package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    @Test
    public void expectedOrderedArray() {
        int[] array = {1, 5, 8, 20, 14, 3, 50};
        Bubble.sort(array);
        int[] expected = {1, 3, 5, 8, 14, 20, 50};
        Assert.assertArrayEquals(expected, array);
    }
}

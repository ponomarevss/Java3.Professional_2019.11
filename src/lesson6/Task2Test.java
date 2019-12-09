package lesson6;

import org.junit.Assert;
import org.junit.Test;

public class Task2Test {

    @Test
            public void testModifyIt1() {

        Assert.assertArrayEquals(new int[]{1, 7}, Task2.modifyIt(new int[]{4, 1, 7}));
    }
    @Test
            public void testModifyIt2() {

        Assert.assertArrayEquals(new int[]{1, 7}, Task2.modifyIt(new int[]{4, 4, 1, 7}));
    }
    @Test
            public void testModifyIt3() {

        Assert.assertArrayEquals(new int[]{}, Task2.modifyIt(new int[]{1, 4}));
    }
    @Test
            public void testModifyIt4() {

        Assert.assertEquals(new RuntimeException(), Task2.modifyIt(new int[]{1, 1, 7}));
    }
}

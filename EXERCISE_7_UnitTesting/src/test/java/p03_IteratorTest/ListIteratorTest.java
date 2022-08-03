package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import javax.xml.crypto.Data;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] DATA = {"Eli", "Raili", "Kamil", "Tedi"};

    @Before
    public void setUp() throws Exception {
        listIterator = new ListIterator(DATA);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfThereIsNullConstructor() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void testIfAfterMoveThereIsNext() {
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

        Assert.assertFalse(listIterator.hasNext());
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintingEmptyList() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testIsPrintingCorrect() {
        int currElement = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(listIterator.print(), DATA[currElement]);
            currElement++;
            listIterator.move();
        }
    }
}

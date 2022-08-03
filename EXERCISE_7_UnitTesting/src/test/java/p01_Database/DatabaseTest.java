package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {20, 50, 80, 10};
    private Database database;

    @Before
    public void setUp() throws Exception {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasCreateValidObject() {
        Integer[] elements = database.getElements();
        Assert.assertArrayEquals(elements, NUMBERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldTrowExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[18];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldTrowExceptionForLessThanOneElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfAddTakesNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void shouldAddElementAtTheNextFreeCell() throws OperationNotSupportedException {
        database.add(30);
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements.length, NUMBERS.length + 1);
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(30));
    }

    @Test
    public void testIfRemoveWorksCorrectly() throws OperationNotSupportedException {
        database.remove();
        Integer[] element = database.getElements();
        Assert.assertEquals(element.length, NUMBERS.length - 1);
        Assert.assertEquals(element[element.length - 1], Integer.valueOf(80));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldTrowExceptionIfIndexIsNull() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}
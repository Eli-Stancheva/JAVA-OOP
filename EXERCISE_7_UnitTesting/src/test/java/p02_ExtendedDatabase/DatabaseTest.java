package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Person[] PEOPLE = {new Person(1, "Eli"),
            new Person(2, "Raili"),
            new Person(3, "Mimi"),
            new Person(4, "Desi")};
    private Database database;

    @Before
    public void setUp() throws Exception {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorHasCreateValidObject() {
        Person[] elements = database.getElements();
        Assert.assertArrayEquals(elements, PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldTrowExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        Person[] people = new Person[18];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldTrowExceptionForLessThanOneElements() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfAddTakesNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void shouldAddElementAtTheNextFreeCell() throws OperationNotSupportedException {
        Person newPerson = new Person(5, "Marti");
        database.add(newPerson);
        Person[] elements = database.getElements();
        Assert.assertEquals(elements.length, PEOPLE.length + 1);
        Assert.assertEquals(elements[elements.length - 1].getUsername(), "Marti");
    }

    @Test
    public void testIfRemoveWorksCorrectly() throws OperationNotSupportedException {
        database.remove();
        Person[] element = database.getElements();
        Assert.assertEquals(element.length, PEOPLE.length - 1);
        Assert.assertEquals(element[element.length - 1].getUsername(), "Mimi");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldTrowExceptionIfIndexIsNull() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void trowExceptionIfUsernameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername("Eli");
        Assert.assertEquals(1, person.getId());
        Assert.assertEquals("Eli", person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameMoreThanOnePerson() throws OperationNotSupportedException {
            database.add(new Person(5, "Desi"));
            database.findByUsername("Desi");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameInvalidName () throws OperationNotSupportedException {
        database.findByUsername("Pesho");
    }

    @Test
    public void testFindByUserId() throws OperationNotSupportedException {
        Person person = database.findById(1);
        Assert.assertEquals(1, person.getId());
        Assert.assertEquals(person.getUsername(), "Eli");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUserIdMoreThanOnePerson() throws OperationNotSupportedException {
        database.add(new Person(4, "Desi"));
        database.findById(4);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUserIdInvalidName () throws OperationNotSupportedException {
        database.findById(6);
    }
}

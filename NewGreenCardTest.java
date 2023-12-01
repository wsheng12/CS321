import static org.junit.Assert.*;
import org.junit.Test;

public class NewGreenCardTest {

    // test different parameters of the object
    // Added more here
    // Added comment here See if it works.
    // Added even more comments
    @Test
    public void argumentTypeTest() {

        // valid IDs
        String address = "4542 Ruth Drive";
        String name = "Winston Sheng";
        String id = "XYZ123456789";

        NewGreenCard greenCard = new NewGreenCard(address, name, id);

        assertEquals(greenCard.getAddress() instanceof String, true);
        assertEquals(greenCard.getName() instanceof String, true);
        assertEquals(greenCard.getId() instanceof String, true);

        // check over this! status complicated ! :(
        assertTrue(greenCard.getStatus());
        // assertEquals(greenCard.getStatus() instanceof boolean, true);
        // cannot check primitive types

    }

    // test to make sure the object is the right return type
    @Test
    public void greenCardTypeTest() {

        String address = "4542 Ruth Drive";
        String name = "Bianca AKins";
        String id = "XYZ123456789";

        NewGreenCard greenCard = new NewGreenCard(address, name, id);

        assertEquals(greenCard instanceof NewGreenCard, true);

    }

    // checking if object is NULL
    @Test
    public void greenCardTypeTest() {

        String address = "4542 Ruth Drive";
        String name = "Bianca AKins";
        String id = "XYZ123456789";

        NewGreenCard greenCard = null;

        assertEquals(greenCard != null, false);

    }

    // test to make sure validation method works correctly
    @Test
    public void validationTest() {

        // valid values
        String address = "4542 Ruth Drive";
        String name = "Brian Andres";
        String id = "XYZ123456789";

        // invalid values:
        // non-valid address
        String fakeAddress1 = "1234 fake address";
        String realName1 = "Brian Andres";
        String realId1 = "XYZ123456789";

        // non-valid name
        String realAddress2 = "4542 Ruth Drive";
        String fakeName2 = "Wintson Sheng";
        String realId2 = "XYZ123456789";

        // non-valid ID
        String realAddress3 = "4542 Ruth Drive";
        String realName3 = "Brian Andres";
        String fakeId3 = "ABC1234567891";

        // create objects
        NewGreenCard greenCard = new NewGreenCard(address, name, id);
        NewGreenCard falseGreenCard1 = new NewGreenCard(fakeAddress1, realName1, realId1);
        NewGreenCard falseGreenCard2 = new NewGreenCard(realAddress2, fakeName2, realId2);
        NewGreenCard falseGreenCard3 = new NewGreenCard(realAddress3, realName3, fakeId3);

        // all objects should return false except for first one
        assertEquals(greenCard.validate(true), true);
        assertEquals(falseGreenCard1.validate(true), false);
        assertEquals(falseGreenCard2.validate(true), false);
        assertEquals(falseGreenCard3.validate(true), false);

    }

    // test to make sure external database retrieve method is working correctly
    @Test
    public void externalDatabaseRetrieveTest() {

        // valid ID
        String id = "XYZ123456789";

        // values that the NGC object with the VALID ID will have in the external
        // Database
        String address = "4542 Ruth Drive";
        String name = "Bianca Akins";

        // non-valid ID
        String fakeId = "ABC9876543210";

        // test if the method can successfully retrieve a valid NGC object from the
        // external database with a valid id
        assertTrue(NewGreenCard.externalDatabaseRetrieve(id) instanceof NewGreenCard);

        // checks to make sure it has the correct fields
        NewGreenCard valid = NewGreenCard.externalDatabaseRetrieve(id);
        assertTrue(valid.getAddress().equals(address));
        assertTrue(valid.getName().equals(name));

        // test that if we give it an incorrect id that it'll return null (could not
        // find any object with that ID)
        assertTrue(NewGreenCard.externalDatabaseRetrieve(fakeId) == null);

    }

    // test to make sure internal database add method is working correctly
    @Test
    public void internalDatabaseAddTest() {

        // valid fields for the object
        String address = "4542 Ruth Drive";
        String name = "Winston Sheng";
        String id = "XYZ123456789";

        NewGreenCard NGC = new NewGreenCard(address, name, id);

        // add object, should return true
        assertTrue(NGC.internalDatabaseAdd());
        // combine this with test below?

    }

    // check to make sure internal database retrieve method is working correctly
    @Test
    public void internalDatabaseRetrieveTest() {

        // valid fields for object
        String address = "4542 Ruth Drive";
        String name = "Brian Andres";
        String id = "XYZ123456789";

        // id that is not in internal database
        String invalidId = "ABC09876543210";

        // create object then add it to the database
        NewGreenCard NGC = new NewGreenCard(address, name, id);
        NGC.internalDatabaseAdd();

        // test if retrieving returns the correct object (NewGreenCard)
        assertTrue(NewGreenCard.internalDatabaseRetrieve(id) instanceof NewGreenCard);

        // test if each field in the NewGreenCard are the correct fields
        NewGreenCard retrievedNGC = NewGreenCard.internalDatabaseRetrieve(id);
        assertTrue(retrievedNGC.getAddress().equals(address));
        assertTrue(retrievedNGC.getName().equals(name));
        assertTrue(retrievedNGC.getId().equals(id));

        // searches for an id that is not there - should return null
        assertEquals(NewGreenCard.internalDatabaseRetrieve(invalidId) == null, true);
    }

    // IMPORTANT - we should probably do correct IDs and such here no?
}
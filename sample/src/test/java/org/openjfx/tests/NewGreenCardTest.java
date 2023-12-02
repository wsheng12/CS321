package org.openjfx.tests;

// import src.main.java.org.openjfx;
import org.openjfx.otherClasses.*;

import static org.junit.Assert.*;

import javax.security.auth.login.CredentialException;

import org.junit.Test;

public class NewGreenCardTest {

    // test different parameters of the object
    // Added more here
    // Added comment here See if it works.
    // Added even more comments
    @Test
    public void argumentTypeTest() {

        // valid IDs
        String address = "1829 Lois Lane";
        String name = "Brian Andres";
        String id = "ABC123456789";
        String email = "brian@gmail.com";

        NewGreenCard greenCard = NewGreenCard.createNewGreenCard(address, name, id, email);

        assertEquals(true, greenCard.getAddress() instanceof String);
        assertEquals(true, greenCard.getName() instanceof String);
        assertEquals(true, greenCard.getId() instanceof String);
        assertEquals(true, greenCard.getEmail() instanceof String);

        // cannot check primitive types

    }

    // test to make sure the object is the right return type
    @Test
    public void greenCardTypeTest() {

        String address = "1829 Lois Lane";
        String name = "Brian Andres";
        String id = "ABC123456789";
        String email = "brian@gmail.com";

        NewGreenCard greenCard = NewGreenCard.createNewGreenCard(address, name, id, email);

        assertEquals(true, greenCard instanceof NewGreenCard);

    }

    // test to make sure validation method works correctly
    @Test
    public void validationTest() {

        // valid values
        String address = "1829 Lois Lane";
        String name = "Brian Andres";
        String id = "ABC123456789";
        String email = "brian@gmail.com";

        // invalid values:
        // non-valid address
        String fakeAddress1 = "8004 Jane Tree";
        String realName1 = "Winston Shen";
        String realId1 = "DEF12345";
        String realEmail1 = "winston@gmail.com";

        // non-valid name
        String realAddress2 = "6392 Gmu";
        String fakeName2 = "Bianca s";
        String realId2 = "GHI123456789";
        String realEmail2 = "bianca@gmail.com";

        // non-valid ID
        String realAddress3 = "2341 Lane";
        String realName3 = "John Smith";
        String fakeId3 = "JKL123456789";
        String realEmail3 = "john@gmail.com";

        // create objects
        NewGreenCard greenCard = NewGreenCard.createNewGreenCard(address, name, id, email);
        NewGreenCard falseGreenCard1 = NewGreenCard.createNewGreenCard(fakeAddress1, realName1, realId1, realEmail1);
        NewGreenCard falseGreenCard2 = NewGreenCard.createNewGreenCard(realAddress2, fakeName2, realId2, realEmail2);
        NewGreenCard falseGreenCard3 = NewGreenCard.createNewGreenCard(realAddress3, realName3, fakeId3, realEmail3);

        // all objects should return false except for first one
        assertEquals(true, greenCard.validate(true, greenCard));
        assertEquals(false, falseGreenCard1.validate(true, falseGreenCard1));
        assertEquals(false, falseGreenCard2.validate(true, falseGreenCard2));
        assertEquals(false, falseGreenCard3.validate(true, falseGreenCard3));

    }

    // test to make sure l database retrieve method is working correctly
    @Test
    public void externalDatabaseRetrieveTest() {

        // valid values

        // valid ID
        String id = "ABC123456789";

        // values that the NGC object with the VALID ID will have in the external
        // Database
        String address = "1829 Lois Lane";
        String name = "Brian Andres";

        // non-valid ID
        String fakeId = "ABC2412519241";

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
        // valid values
        String address = "1829 Lois Lane";
        String name = "Brian Andres";
        String id = "ABC123456789";
        String email = "brian@gmail.com";

        NewGreenCard NGC = NewGreenCard.createNewGreenCard(address, name, id, email);

        // add object, should return true
        assertTrue(NGC.internalDatabaseAdd(NGC));
        // combine this with test below?

    }

    // check to make sure internal database retrieve method is working correctly
    @Test
    public void internalDatabaseRetrieveTest() {

        // valid fields for object
        // valid values
        String address = "1829 Lois Lane";
        String name = "Brian Andres";
        String id = "ABC123456789";
        String email = "brian@gmail.com";

        // id that is not in internal database
        String invalidId = "ABC09876543210";

        // create object then add it to the database
        NewGreenCard NGC = NewGreenCard.createNewGreenCard(address, name, id, email);
        NGC.internalDatabaseAdd(NGC);

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
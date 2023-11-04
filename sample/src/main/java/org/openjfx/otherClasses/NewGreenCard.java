//Represents a new green card object with address, name, id, and status information
package org.openjfx.otherClasses;

public class NewGreenCard {

    // The address associated with the green card requester
    private String address;

    // The name of the green card requester
    private String name;

    // The id of the green card requester
    private String id;

    // The status of the green card requester
    private String status;

    private String email;

    // Constructs a new green card object with the specified address, name, and id
    private NewGreenCard(String address, String name, String id, String email) {
        this.address = address;
        this.name = name;
        this.id = id;
        this.email = email;
        status = "initial";
    }

    public static NewGreenCard createNewGreenCard(String address, String name, String id, String email) {
        return new NewGreenCard(address, name, id, email);
    }

    // Validates the green card requester information
    public boolean validate(boolean reviewer) {
        return false;
    }

    // Adds the green card requester information to the internal database
    public boolean internalDatabaseAdd() {
        return false;
    }

    // Retrieves a green card requester object from the external database based on
    // the given
    // ID
    public static NewGreenCard externalDatabaseRetrieve(String id) {
        return null;
    }

    // Retrieves a green card requester object from the internal database based on
    // the given
    // ID
    public static NewGreenCard internalDatabaseRetrieve(String id) {
        return null;
    }

    // Gets the name of the green card requester
    public String getName() {
        return name;
    }

    // Gets the id of the green card requester
    public String getId() {
        return id;
    }

    // Gets the status of the green card requester
    public String getStatus() {
        return status;
    }

    // Gets the address associated with the green card requester
    public String getAddress() {
        return address;
    }

    public String getEmail(){

        return email;

    }

    // Sets the address associated with the green card requester
    public void setAddress(String address) {
    }

    // Sets the name of the green card holder
    public void setName(String name) {
    }

    // Sets the id of the green card requester
    public void setId(String id) {
    }

    public void setEmail(String email){

        
    }

    // Sets the status of the green card requester
    public void setStatus(String status) {
    }
}

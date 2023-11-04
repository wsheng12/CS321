package org.openjfx;

import java.util.HashMap;

import org.openjfx.otherClasses.NewGreenCard;

public class InternalDatabse {
    public static HashMap<String, NewGreenCard> internDatabase = new HashMap<String, NewGreenCard>();

    
    public boolean add(String id, NewGreenCard greenCard) {

        internDatabase.put(id, greenCard);

        return true;

    }

    public NewGreenCard get(String id){

        return internDatabase.get(id);

    }

}

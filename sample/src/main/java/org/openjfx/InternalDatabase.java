package org.openjfx;

import java.util.HashMap;

import org.openjfx.otherClasses.NewGreenCard;

public class InternalDatabase {
    public static HashMap<String, NewGreenCard> internDatabase = new HashMap<String, NewGreenCard>();

    
    public static boolean add(String id, NewGreenCard greenCard) {

        internDatabase.put(id, greenCard);

        return true;

    }

    public static NewGreenCard get(String id){

        return internDatabase.get(id);

    }

}

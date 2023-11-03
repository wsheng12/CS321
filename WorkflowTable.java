package org.openjfx.otherClasses;

import java.util.*;

//WorkflowTable class manages queues of NewGreenCard IDs that need to be reviewed and approved
//It provides methods to add, remove, and retrieve elements from these queues
public class WorkflowTable {

    // Queue to store NewGreenCard IDs that need to be reviewed
    private static Queue<String> reviewerQueue = new LinkedList<>();

    // Queue to store NewGreenCard IDs that need to be approved
    private static Queue<String> approverQueue = new LinkedList<>();

    // Adds a NewGreenCard ID to the reviewer queue
    public static boolean addReviewer(String id) {
        return false;
    }

    // Adds a NewGreenCard ID to the approver queue
    public static boolean addApprover(String id) {
        return false;
    }

    // Removes and returns a NewGreenCard ID from the reviewer queue
    public static String popReviewer() {
        return null;
    }

    // Removes and returns a NewGreenCard ID from the approver queue
    public static String popApprover() {
        return null;
    }

    // Gets the number of NewGreenCard IDs in the reviewer queue
    public static int getSizeReviewer() {
        return -1;
    }

    // Gets the number of NewGreenCard IDs in the approver queue
    public static int getSizeApprover() {
        return -1;
    }

    // Sets the reviewer queue to the provided queue of NewGreenCard IDs that need
    // to be reviewed
    public static boolean setReviewerQueue(Queue<String> reviewerQueue) {
        return false;
    }

    // Sets the approver queue to the provided queue of NewGreenCard IDs that need
    // to be approved
    public static boolean setApproverQueue(Queue<String> approverQueue) {
        return false;
    }

    // Gets the queue of NewGreenCard IDs that need to be reviewed
    public static Queue<String> getReviewerQueue() {
        return null;
    }

    // Gets the queue of NewGreenCard IDs that need to be approved
    public static Queue<String> getApproverQueue() {
        return null;
    }
}
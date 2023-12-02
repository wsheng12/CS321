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
        reviewerQueue.add(id);
        return true;
    }

    // Adds a NewGreenCard ID to the approver queue
    public static boolean addApprover(String id) {
        approverQueue.add(id);
        return true;
    }

    // Removes and returns a NewGreenCard ID from the reviewer queue
    public static String popReviewer() {
        return reviewerQueue.poll();
    }

    // Removes and returns a NewGreenCard ID from the approver queue
    public static String popApprover() {
        return approverQueue.poll();
    }

    // Gets the number of NewGreenCard IDs in the reviewer queue
    public static int getSizeReviewer() {
        return reviewerQueue.size();
    }

    // Gets the number of NewGreenCard IDs in the approver queue
    public static int getSizeApprover() {
        return approverQueue.size();
    }

    // Sets the reviewer queue to the provided queue of NewGreenCard IDs that need
    // to be reviewed
    public static boolean setReviewerQueue(Queue<String> reviewerQueue) {
        Iterator<String> it = reviewerQueue.iterator();
        while(it.hasNext())  {
            WorkflowTable.reviewerQueue.add(it.next());
        }
        return true;
    }

    // Sets the approver queue to the provided queue of NewGreenCard IDs that need
    // to be approved
    public static boolean setApproverQueue(Queue<String> approverQueue) {
        Iterator<String> it = approverQueue.iterator();
        while(it.hasNext())  {
            WorkflowTable.approverQueue.add(it.next());
        }
        return true;
    }

    // Gets the queue of NewGreenCard IDs that need to be reviewed
    public static Queue<String> getReviewerQueue() {
        return reviewerQueue;
    }

    // Gets the queue of NewGreenCard IDs that need to be approved
    public static Queue<String> getApproverQueue() {
        return approverQueue;
    }
}
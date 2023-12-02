package org.openjfx.tests;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import org.openjfx.otherClasses.WorkflowTable;

public class WorkflowTableTest {

    // queue variable tests
    @Test
    public void WorkflowQueueTests() {
        // makes sure getQueue returns proper type
        assertTrue(WorkflowTable.getApproverQueue() instanceof Queue<?>);
        assertTrue(WorkflowTable.getReviewerQueue() instanceof Queue<?>);

        // makes sure that set and get methods create and return correct queues
        // for Approver
        Queue<String> temp = new LinkedList<>();
        temp.add("ABCDEFG");
        temp.add("CDEFGHJI");
        assertTrue(WorkflowTable.setApproverQueue(temp));
        // System.out.println(WorkflowTable.getApproverQueue().poll() == temp.poll());
        assertTrue(WorkflowTable.getApproverQueue().poll() == temp.poll());
        assertTrue(WorkflowTable.getApproverQueue().poll() == temp.poll());

        // for Reviewer
        Queue<String> temp2 = new LinkedList<>();
        temp2.add("ABCDEFG");
        temp2.add("CDEFGHJI");
        assertTrue(WorkflowTable.setReviewerQueue(temp2));
        // System.out.println(WorkflowTable.getReviewerQueue().poll() == temp2.poll());

        assertTrue(WorkflowTable.getReviewerQueue().poll() == temp2.poll());
        assertTrue(WorkflowTable.getReviewerQueue().poll() == temp2.poll());

    }

    // Approver tests
    @Test
    public void WorkflowApproverQueueTests() {

        // size test
        assertEquals(WorkflowTable.getSizeApprover() == 0, true);

        // adding
        assertTrue(WorkflowTable.addApprover("XYZ123456789"));
        assertTrue(WorkflowTable.addApprover("ABC98765321"));
        assertTrue(WorkflowTable.addApprover("DEF123450987"));

        // size test
        assertEquals(WorkflowTable.getSizeApprover() == 3, true);

        // right retun type
        assertTrue(WorkflowTable.popApprover() instanceof String);

        // popApprover returns correct values (also makes sure that the add method
        // works)
        assertEquals(WorkflowTable.popApprover(), "ABC98765321");
        assertEquals(WorkflowTable.popApprover(), "DEF123450987");

        // size test
        assertEquals(WorkflowTable.getSizeApprover() == 0, true);

    }

    // reviewer tests
    @Test
    public void WorkflowReviewerQueueTests() {

        // size test
        assertEquals(WorkflowTable.getSizeReviewer() == 0, true);

        // add values
        assertTrue(WorkflowTable.addReviewer("XYZ123456789"));
        assertTrue(WorkflowTable.addReviewer("ABC98765321"));
        assertTrue(WorkflowTable.addReviewer("DEF123450987"));
        assertTrue(WorkflowTable.addReviewer("GHI123450987"));

        // size test
        assertEquals(WorkflowTable.getSizeReviewer() == 4, true);

        // right return type for pop
        assertTrue(WorkflowTable.popReviewer() instanceof String);

        // right return values
        assertEquals(WorkflowTable.popReviewer(), "ABC98765321");
        assertEquals(WorkflowTable.popReviewer(), "DEF123450987");
        assertEquals(WorkflowTable.popReviewer(), "GHI123450987");

        // size test
        assertEquals(WorkflowTable.getSizeReviewer() == 0, true);

    }

}
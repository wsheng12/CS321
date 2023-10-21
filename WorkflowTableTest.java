import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import org.junit.Test;

public class WorkflowTableTest {

    // queue variable tests
    @Test
    public void WorkflowQueueTests() {
        // makes sure getQueue returns proper type
        assertTrue(WorkflowTable.getApproverQueue() instanceof Queue<String>);
        assertTrue(WorkflowTable.getReviewerQueue() instanceof Queue<String>);

        // makes sure that set and get methods create and return correct queues
        // for Approver
        Queue<String> temp = new LinkedList<>();
        temp.add("ABCDEFG");
        temp.add("CDEFGHJI");
        assertTrue(WorkflowTable.setApproverQueue(temp));
        assertTrue(WorkflowTable.getApproverQueue().poll() == temp.poll());
        assertTrue(WorkflowTable.getApproverQueue().poll() == temp.poll());

        // for Reviewer
        Queue<String> temp2 = new LinkedList<>();
        temp.add("ABCDEFG");
        temp.add("CDEFGHJI");
        assertTrue(WorkflowTable.setReviewerQueue(temp));
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
        assertEquals(WorkflowTable.popApprover(), "DEF123450987");
        assertEquals(WorkflowTable.popApprover(), "ABC98765321");
        assertEquals(WorkflowTable.popApprover(), "XYZ123456789");

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

        // size test
        assertEquals(WorkflowTable.getSizeReviewer() == 3, true);

        // right return type for pop
        assertTrue(WorkflowTable.popReviewer() instanceof String);

        // right return values
        assertEquals(WorkflowTable.popReviewer(), "XYZ123456789");
        assertEquals(WorkflowTable.popReviewer(), "ABC98765321");
        assertEquals(WorkflowTable.popReviewer(), "DEF123450987");

        // size test
        assertEquals(WorkflowTable.getSizeReviewer() == 0, true);

    }

}

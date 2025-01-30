import org.junit.jupiter.api.Test;      /*importando libreria para test como tal de la clase  Stackvector*/
import static org.junit.jupiter.api.Assertions.*;

public class StackVectorTest {

    @Test
    void testPushiPop() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void testPeek() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(5);
        stack.push(15);
        assertEquals(15, stack.peek());
    }

    @Test
    void testEmpty() {
        StackVector<Integer> stack = new StackVector<>();
        assertTrue(stack.empty());
        stack.push(1);
        assertFalse(stack.empty());
    }

    @Test
    void testSize() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(5);
        stack.push(10);
        assertEquals(2, stack.size());
    }

    @Test
    void testPopOnEmptyStack() {
        StackVector<Integer> stack = new StackVector<>();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void testPeekOnEmptyStack() {
        StackVector<Integer> stack = new StackVector<>();
        assertThrows(IllegalStateException.class, stack::peek);
    }
}

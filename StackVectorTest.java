import org.junit.jupiter.api.Test;      /*importando libreria para test como tal de la clase  Stackvector*/
import static org.junit.jupiter.api.Assertions.*;

public class StackVectorTest {

    @Test
    void testPushiPop() {  //se crea un test para verificar que se pueda hacer push y pop de un elemento
        StackVector<Integer> stack = new StackVector<>();
        stack.push(10); //se agrega un elemento al stack
        stack.push(20); //se agrega un elemento al stack
        assertEquals(20, stack.pop());//se espera que el elemento que se elimine sea 20
        assertEquals(10, stack.pop());// se espera que el elemento que se elimine sea 10
    }

    @Test
    void testPeek() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(5); //se agrega un elemento al stack
        stack.push(15); //se agrega un elemento al stack
        assertEquals(15, stack.peek()); //se espera que ultimo elemento agregado sea 15
    }

    @Test
    void testEmpty() {
        StackVector<Integer> stack = new StackVector<>(); //se crea un stack
        assertTrue(stack.empty()); //se espera que el stack este vacio osea devuelve un valor true osea boolean
        stack.push(1); //se agrega un elemento al stack
        assertFalse(stack.empty());//se espera que el stack no este vacio osea devuelve un valor false osea boolean
    }

    @Test
    void testSize() {
        StackVector<Integer> stack = new StackVector<>();//se crea un stack
        stack.push(5);//se agrega un elemento al stack
        stack.push(10);//se agrega un elemento al stack
        assertEquals(2, stack.size());//se espera que el tamaño del stack sea 2, ya que se agregaron 2 elementos
    }

    @Test
    void testPopOnEmptyStack() { 
        StackVector<Integer> stack = new StackVector<>();// se va  usar el metodo pop en un stack vacio por lo que se espera que se lance una excepcion
        assertThrows(IllegalStateException.class, stack::pop); // en este caso el :: hace referencia al metodo pop de la intancia stack, es en vez de usar () -> stack.pop()
    }

    @Test
    void testPeekOnEmptyStack() { //se va  usar el metodo peek en un stack vacio por lo que se espera que se lance una excepcion
        StackVector<Integer> stack = new StackVector<>();
        assertThrows(IllegalStateException.class, stack::peek);//lo miso que en el test anterior se usa :: en vez de () ->
    }
}

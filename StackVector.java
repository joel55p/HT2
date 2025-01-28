import java.util.Vector;

public class StackVector<E> implements Stack<E> {
    private Vector<E> numeros;

    public StackVector() {
        numeros = new Vector<>();
    }

    @Override
    public void push(E item) {
        numeros.add(item);
    }

    @Override
    public E pop() {
        //No se puede realizar la acción si no hay elementos/números
        if (empty()) {
            throw new IllegalStateException("el Stack esta vacio");
        }
        return numeros.remove(numeros.size() - 1);
    }

    @Override
    public E peek() {
        //No se puede realizar la acción si no hay elementos/números
        if (empty()) {
            throw new IllegalStateException("el Stack esta vacio");
        }
        return numeros.lastElement();
    }

    @Override
    public boolean empty() {
        return numeros.isEmpty();
    }

    @Override
    public int size() {
        return numeros.size();
    }
}

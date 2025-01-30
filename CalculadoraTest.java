import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void testEvaluarPostfixExpresionSimple() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.evaluarPostfix("2 3 +");
        assertEquals(5, resultado);
    }

    @Test
    void testEvaluarPostfixExpresionCompleja() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.evaluarPostfix("5 1 2 + 4 * + 3 -");
        assertEquals(14, resultado);
    }

    @Test
    void testDivisionEntreCero() {
        Calculadora calculadora = new Calculadora();
        assertThrows(ArithmeticException.class, () -> calculadora.evaluarPostfix("10 0 /"));
    }

    @Test
    void testExpresionInvalidaConOperadores() {
        Calculadora calculadora = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> calculadora.evaluarPostfix("2 +"));
    }

    @Test
    void testExpresionInvalidaConOperandosExtras() {
        Calculadora calculadora = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> calculadora.evaluarPostfix("2 3 4 +"));
    }

    @Test
    void testExpresionConOperadorInvalido() {
        Calculadora calculadora = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> calculadora.evaluarPostfix("2 3 &"));
    }
}

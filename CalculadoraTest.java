import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;/*importando libreria para test como tal de la clase  Stackvector*/

class CalculadoraTest {

    @Test
    void testEvaluarPostfixExpresionSimple() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.evaluar("2 3 +"); /*se guarda el resultado experimetal */
        assertEquals(5, resultado); // como tal verifica que el resultado si sea el correcto osea 5
    }

    @Test
    void testEvaluarPostfixExpresionCompleja() {  /*se crea un test para una expresion mas compleja que la anterior */
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.evaluar("5 1 2 + 4 * + 3 -");
        assertEquals(14, resultado);
    }

    @Test
    void testDivisionEntreCero() { /*se crea un test para verificar que no se pueda dividir entre cero, el () -> hace referencia a "ejecutar " es una expresion lambda */
        Calculadora calculadora = new Calculadora(); //osea el () -> calculadora.evaluarPostfix("10 0 /") indica ejecutar metodo  con objeto calculadora y  con el argumento "10 0 /"
        assertThrows(ArithmeticException.class, () -> calculadora.evaluar("10 0 /")); //se espera que se lance una excepcion de tipo ArithmeticException
    }

    @Test
    void testExpresionInvalidaConOperadores() {
        Calculadora calculadora = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> calculadora.evaluar("2 +")); /*verifica que no se pueda realizar operaciones de este */
    }

    @Test
    void testExpresionInvalidaConOperandosExtras() {
        Calculadora calculadora = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> calculadora.evaluar("2 3 4 +"));//verifica que no se pueda realizar operaciones de este tipo
    }

    @Test
    void testExpresionConOperadorInvalido() {
        Calculadora calculadora = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> calculadora.evaluar("2 3 &"));//verifica que no se pueda realizar operaciones de este tipo
    }
}

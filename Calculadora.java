/**
 * Clase Calculadora que implementa la interfaz Interfaz para evaluar expresiones en notación postfija.
 */
import java.util.StringTokenizer;

public class Calculadora implements Interfaz {
    private Stack<Integer> stack;

    /**
     * Constructor de la clase Calculadora..
     */
    public Calculadora() {
        stack = new StackVector<>();
    }

    /**
     * Método para evaluar una expresión en notación postfija.
     * 
     * @param operacion La expresión en notación postfija a evaluar.
     * @return El resultado de la evaluación.
     * @throws IllegalArgumentException Si la expresión es inválida.
     */
    @Override
    public int evaluar(String operacion) {
        StringTokenizer tokens = new StringTokenizer(operacion);
        
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            
            if (esNumero(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión inválida: no hay suficientes operandos para el operador '" + token + "'");
                }
                int b = stack.pop();
                int a = stack.pop();
                
                stack.push(operar(a, b, token));
            }
        }
        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión inválida: demasiados operandos sin operadores suficientes");
        }
        return stack.pop();
    }

    /**
     * Método para realizar una operación entre dos operandos.
     * 
     * @param operandoA Primer operando.
     * @param operandoB Segundo operando.
     * @param operador  Operador a aplicar (+, -, *, /).
     * @return El resultado de la operación.
     * @throws ArithmeticException Si se intenta dividir por cero.
     * @throws IllegalArgumentException Si el operador no es válido.
     */
    @Override
    public int operar(int operandoA, int operandoB, String operador) {
        return switch (operador) {
            case "+" -> operandoA + operandoB;
            case "-" -> operandoA - operandoB;
            case "*" -> operandoA * operandoB;
            case "/" -> {
                if (operandoB == 0) {
                    throw new ArithmeticException("Error: División entre cero");
                }
                yield operandoA / operandoB;
            }
            default -> throw new IllegalArgumentException("Operador no válido: " + operador);
        };
    }

    /**
     * Método privado para verificar si un token es un número entero.
     * 
     * @param token El token a verificar.
     * @return true si el token es un número, false en caso contrario.
     */
    private boolean esNumero(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

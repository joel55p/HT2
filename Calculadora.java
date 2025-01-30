import java.util.StringTokenizer;

public class Calculadora implements Interfaz {
    private Stack<Integer> stack;

  //Constructor
    public Calculadora() {
        stack = new StackVector<>();
    }

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

    private boolean esNumero(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
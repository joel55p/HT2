import java.util.StringTokenizer;  //libreria utilizada para leer cada elemento del archivo 

public class Calculadora {
    private StackVector<Integer> stack;
    
    public Calculadora() {
        stack = new StackVector<>();
    }
    
    public int evaluarPostfix(String expresion) {
        StringTokenizer tokens = new StringTokenizer(expresion);
        
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            
            if (esNumero(token)) {
                stack.push(Integer.parseInt(token));
            } else if (esOperador(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión inválida: no hay suficientes operandos");
                }
                int b = stack.pop();
                int a = stack.pop();
                int resultado = operar(a, b, token);
                stack.push(resultado);
            } else {
                throw new IllegalArgumentException("ha ingresado un valor incorrecto: " + token);
            }
        }
        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión inválida: demasiados operandos");
        }
        return stack.pop();
    }
    
    private boolean esNumero(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    private int operar(int a, int b, String operador) {
        switch (operador) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": 
                if (b == 0) {
                    throw new ArithmeticException("División entre cero");
                }
                return a / b;
            default: throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
}

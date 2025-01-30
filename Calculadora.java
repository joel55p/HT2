<<<<<<< HEAD
public class Calculadora{

    public void calcular(String expresion, StackVector<Integer> stack) {
        // Se crea un arreglo de String
        String[] tokens = expresion.split(" ");
        // Se recorre el arreglo de String
        for (String token : tokens) {
            // Si el token es un número
            if (esNumero(token)) {
                // Se agrega el número al stack
                stack.push(Integer.parseInt(token));
            } else {
                // Se obtienen los dos números del stack
                int num2 = stack.pop();
                int num1 = stack.pop();
                // Se realiza la operación correspondiente
                int resultado = operar(num1, num2, token);
                // Se agrega el resultado al stack
                stack.push(resultado);
            }
        }
    }

    public boolean esNumero(String token) {
=======
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
>>>>>>> 16bbc96a6c8552b70b74b05b47bbff4526e2847e
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
<<<<<<< HEAD

    public int operar(int num1, int num2, String operador) {
        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }



}
=======
    
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
>>>>>>> 16bbc96a6c8552b70b74b05b47bbff4526e2847e

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
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

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
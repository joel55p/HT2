import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        String fileName = "datos.txt";
        Calculadora calculador = new Calculadora();
        
        // Se crea un objeto de la clase StackVector
        StackVector<Integer> stack = new StackVector<>();

        // Leer la expresión desde el archivo de texto
        String expresion = leerExpresionDesdeArchivo(fileName);
        
        if (expresion != null) {
            // Se llama al método de la clase Calculadora
            calculador.calcular(expresion, stack);

            // Se imprime el resultado
            System.out.println("El resultado de la expresión es: " + stack.peek());
        } else {
            System.out.println("No se pudo leer la expresión del archivo.");
        }
    }

    // Método para leer la expresión desde el archivo
    private static String leerExpresionDesdeArchivo(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.readLine();  // Lee solo la primera línea
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
=======
        Calculadora calculadora = new Calculadora();
        
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int resultado = calculadora.evaluarPostfix(linea);
                System.out.println("el resultado: " + resultado);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
>>>>>>> 16bbc96a6c8552b70b74b05b47bbff4526e2847e
    }
}
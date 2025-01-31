import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal que ejecuta la aplicación de la calculadora.
 * Lee expresiones desde un archivo y las evalúa utilizando la interfaz de calculadora.
 */
public class Main {
    /**
     * Método principal que lee expresiones de un archivo y las evalúa.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Interfaz calculadora = new Calculadora();
        
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                try {
                    int resultado = calculadora.evaluar(linea);
                    System.out.println("El resultado: " + resultado);
                } catch (IllegalArgumentException | ArithmeticException e) {
                    System.out.println("Error en la expresión: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
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
    }
}
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio19LeerArchivo {
    public static void main(String[] args) {
        int contadorLineas = 1;
        int contadorPalabras = 1;
        int contadorCaracteres = 1;

        System.out.println("Texto que hay en el archivo");
        try (FileReader reader = new FileReader("../ArchivoParaEjercicios.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                if (c == '\n') { // \n son saltos de líneas
                    contadorLineas++;
                }
                if (c == 32 || c == '\n') { // 32 es el espacio y \n el salto de línea
                    contadorPalabras++;
                }
                if (c != -1 && c != '\n') {
                    contadorCaracteres++;
                }
                System.out.print((char) c);
            }
            /* CORRECCIÓN DE CLASE
            int contador = 0;
            int caracteres = 0;
            int palabras = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader("../ArchivoParaEjercicios.txt"))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    contador++;
                    System.out.println(linea);
                    caracteres += linea.length();
                    palabras += linea.split(" ").length; //split "trocea" la línea cada vez que ve un espácio en blanco
                }
            } catch (IOException e) {
                System.out.println("Ocurrió un error al leer el archivo: " +
                        e.getMessage());
            }
                }
            */
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("================================================================");
        System.out.println("En el archivo hay un total de " + contadorLineas + " líneas.");
        System.out.println("En el archivo hay un total de " + contadorPalabras + " palabras.");
        System.out.println("En el archivo hay un total de " + contadorCaracteres + " caracteres.");
    }
}
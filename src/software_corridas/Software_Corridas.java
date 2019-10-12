
package software_corridas;

/**
 * *
 * @author marco antonio chi castillo 
 * @author marcos abraham caamal tzuc
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Software_Corridas {

    public static void main(String[] args) {
        CargarArchivo prueba=new CargarArchivo();
        ArrayList <String> texto=new ArrayList();
        texto=prueba.leer_fichero();
        for (int i=0; i<texto.size(); i++){
            System.out.println(texto.get(i));
        }
    
    }
    
}

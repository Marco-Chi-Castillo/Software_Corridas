
package software_corridas;

/**
 * @author m
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class CargarArchivo {
    String direccion = "numeros.txt"; //Direccion del Archivo
    
    public ArrayList leer_fichero(){
        ArrayList arreglo= new ArrayList(); //Pasa elementos x elementos a un vector.
        
        try {
            FileReader ficha = new FileReader(direccion); //captura del archivo
            BufferedReader dato = new BufferedReader(ficha); //Lectura del archivo.
           
            String linea = "";
                    
            while(linea != null){ //Cuando es -1 ya no hay texto que mostrar.
                linea = dato.readLine(); //Lee cada palabra almacenada en un archivo.
                /*
                Un lectura con buffer siempre termina con null. por eso se pone este if,
                para que no imprima en pantalla ese null del buffer.
                */
                if(linea!=null){ 
                    arreglo.add(linea); //Captura los valores de linea al vector lineas.
               } 
            } 
        } catch (IOException ex) { //Excepcion si encuentra un problema.
            System.out.println("Archivo No Encontrado");
        }
        return arreglo; //retorna el areglo nuevo.
    }
}

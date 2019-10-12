
package software_corridas;
import java.util.ArrayList;


public class Operaciones {
    public double[] valores(){
        CargarArchivo datos = new CargarArchivo(); 
        ArrayList arreglo = datos.leer_fichero();
        double[] datosDouble = new double[arreglo.size()];
        
        for(int i = 0; i< arreglo.size();i++){
            datosDouble[i] = Double.parseDouble(arreglo.get(i).toString());
        }
        return datosDouble;
    }
    
    //si valor actual <= numero anterior 0
    //si valor anterior > actual 1
    public ArrayList<Integer> Binario(){
        ArrayList<Integer> binario = new ArrayList();
        double[] va = this.valores();
        for(int i=1; i < va.length; i++){
            if(va[i]<=va[i-1]) binario.add(0);
            else binario.add(1);
        }
        return binario;
    }
    
    public int corridas(){
        int corridas = 1;
        ArrayList<Integer> binario = this.Binario();
        for(int i = 1; i<binario.size();i++){
            if(binario.get(i) != binario.get(i-1)){
                corridas++;
            }
        }
        return corridas;
    }
    
    public String ImprimirBinario(){
        String binario = "";
        for(int i = 0; i<this.Binario().size();i++){
            binario = binario + String.valueOf(this.Binario().get(i));
        }
        return binario;
    }
    
    public double Mc(){
        double mc;
        mc = ((2*this.valores().length)-1)/3;
        return mc;
    }
    
    public double Co(){
        double co;
        co = (float)((16*this.valores().length)-29)/90;
        return co;
    }
    
    public double Zo(){
        double zo;
        zo = Math.abs((this.corridas() - this.Mc())/Math.sqrt(this.Co()));
        return zo;
    }
    
    public void Imprimir(){
         frmInterfaz.lblResultadoBinario1.setText(this.ImprimirBinario());
         frmInterfaz.lblMc.setText("Mc: " + String.valueOf(this.Mc()));
         frmInterfaz.lblCo.setText("Co: " + String.valueOf(String.format("%.2f", this.Co())));
         frmInterfaz.lblZo.setText("Zo: " + String.valueOf(String.format("%.5f", this.Zo())));
    }
    
    public void resultadoFinal(double conf){
        frmInterfaz.lblResultado1.setText(String.valueOf(String.format("%.5f", this.Zo())) + " < " + String.valueOf(conf));
        if(this.Zo()<conf){
            frmInterfaz.lblMensaje.setText("El conjunto Ri es Independiente");
        }else{
            frmInterfaz.lblMensaje.setText("El conjunto Ri es dependiente");
        }
    }
    
    
    
    
    
}

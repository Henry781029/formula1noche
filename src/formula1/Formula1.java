
package formula1;

import formula1.controladores.ControladorHome;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.Vistahome;


public class Formula1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Escuderia escuderia = new Escuderia(); 
    Piloto piloto = new Piloto();
    Vistahome vistahome = new Vistahome();
    vistahome.setVisible(true);
    
    ControladorHome controladorhome = new ControladorHome (escuderia, piloto, vistahome);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.Vistahome;
import formula1.vistas.Vistaregistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorHome implements ActionListener{
    
    //atributos de la clase
    Escuderia escuderia = new Escuderia(); 
    Piloto piloto = new Piloto();
    Vistahome vistahome = new Vistahome();

    
    public ControladorHome() {
    }
    
    
    public ControladorHome(Escuderia escuderia,Piloto piloto,Vistahome vistahome  ) {
        
        this.escuderia = escuderia;
        this.piloto = piloto;
        this.vistahome = vistahome;
        
        vistahome.btingresar1.addActionListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //crear objeto de la clase consulta escuderia
        ConsultasEscuderia consulta = new ConsultasEscuderia();
        
        //obtener id de la vista
        String id = vistahome.tvidescuderia.getText();
        
        //intento buscar escuderia por id
        if(consulta.buscarEscuderia(id)!= null){
            JOptionPane.showMessageDialog(null, "ya existe");
        }else{
            //si esta vacia la busqueda si no existe
            Vistaregistro vistaregistro = new Vistaregistro(); 
            vistaregistro.setVisible(true);
            vistahome.setVisible(false);
            
            ControladorRegistro controladorregistro =new ControladorRegistro(escuderia, piloto, vistaregistro);
            
        }
        
         
    }
         
}


package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.ConsultasPilotos;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.Vistaregistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class ControladorRegistro implements ActionListener {
    
    Escuderia escuderia = new Escuderia(); 
    Piloto piloto = new Piloto();
    Vistaregistro vistaregistro = new Vistaregistro();

    public ControladorRegistro() {
    }
    
    public ControladorRegistro(Escuderia escuderia, Piloto piloto, Vistaregistro vistaregistro ) {
        
        this.escuderia = escuderia;
        this.piloto = piloto;
        this.vistaregistro = vistaregistro;
        
        vistaregistro.btingresar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        //traer las consultas de escuderia y de pilotos
        ConsultasEscuderia consultaescuderia = new ConsultasEscuderia();
        ConsultasPilotos  consultaspilotos = new ConsultasPilotos();
        
        //armar escuderia para grabar
        escuderia.setId(vistaregistro.tvescuderia.getText());
        escuderia.setNombre(vistaregistro.tvnombreescuderia.getText());
        escuderia.setPresupuesto(Integer.parseInt(vistaregistro.tvpresupuesto.getText()));
        escuderia.setTipoMotor(vistaregistro.tvmotor.getText());
        
        //armar piloto para grabar
        piloto.setNombres(vistaregistro.tvnombre.getText());
        piloto.setApellidos(vistaregistro.tvapellido.getText());
        piloto.setSalario(Integer.parseInt(vistaregistro.tvsalario.getText()));
        
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaentrada=formato.format(entrada);
        piloto.setFechaIn(fechaentrada);
        piloto.setIdEscuderia(vistaregistro.tvescuderia.getText());
        
        //intentar registrar escuderia y piloto
        if(consultaescuderia.registrarEscuderia(escuderia) && consultaspilotos.registrarPiloto(piloto)){
            JOptionPane.showMessageDialog(null,"Exito en el ingreso" );
        }else{
            JOptionPane.showMessageDialog(null,"UPPPPS...................intente nuevamente" );
        }
        
    }
    
}

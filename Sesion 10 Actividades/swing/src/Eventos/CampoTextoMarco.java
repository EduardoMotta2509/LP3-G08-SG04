package Eventos;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;


public class CampoTextoMarco extends JFrame{
	private final JTextField campoTexto1;//campo de texto con tamañp fijo
	private final JTextField campoTexto2;//campo de texto con texto
	private final JTextField campoTexto3;//campo de texto con texto y tamaño
	private final JPasswordField campoContrasenia;//campo de contraseña con texto
	
	//El constructor de CampoTextoMarco agrega objetos JTextField a JFrame
	public CampoTextoMarco() {
		super("Prueba de JTextField y JPasswordField - Eduardo Motta");
		setLayout(new FlowLayout());
		
		//construye campo de texto con 10 columnas
		campoTexto1 = new JTextField(10);
		add(campoTexto1); //Agrega campoTexto1 a JFrame
		
		//construye campo de texto con texto predeterminado
		campoTexto2 = new JTextField("Escriba el texto aquí");
		add(campoTexto2); //agrega campoTexto2 a JFrame
		
		//contruye campo de texto con texto predeterminado y 21 columnas
		campoTexto3 = new JTextField("Campo de texto no editable", 21);
		campoTexto3.setEditable(false); //deshabilita la edición
		add(campoTexto3);
		
		//construye campo de contraseña con texto predeterminado
		campoContrasenia = new JPasswordField("Texto oculto");
		add(campoContrasenia);
		
		//registra los manejadores de eventos
		ManejadorCampoTexto manejador = new ManejadorCampoTexto();
		campoTexto1.addActionListener(manejador);
		campoTexto2.addActionListener(manejador);
		campoTexto2.addActionListener(manejador);
		campoContrasenia.addActionListener(manejador);
	}
	
	private class ManejadorCampoTexto implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			String cadena = "";
			//el susario oprimió Intro en el objeto JTextField campoTexto1
			if(evento.getSource() == campoTexto1) {
				cadena = String.format("campoTexto1: %s",evento.getActionCommand());
			}
			
			//el usuario oprimió Intro en el objeto JTextField campoTexto2
			else if(evento.getSource() == campoTexto2) {
				cadena = String.format("campoTexto2: %s", evento.getActionCommand());
			}
			
			//el usuario oprimió Intro en el objeto JTextField campoTexto3
			else if(evento.getSource() == campoTexto3) {
				cadena = String.format("campoTexto3: %s", evento.getActionCommand());
			}
			
			//el usuario oprimió Intro en el objeto JTextField campoContrasenia
			else if(evento.getSource() == campoContrasenia) {
				cadena = String.format("campoContrasenia: %s", evento.getActionCommand());
			}
			
			//muestra el contenido del objeto JTextField
			JOptionPane.showMessageDialog(null, cadena);
		}
	}//Fin de la clase privada interna ManejadorCampoTexto
}//Fin de la clase CampoTextoMarco

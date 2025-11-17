package EsquemasComplejos;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MarcoPanel extends JFrame{
	private final JPanel panelBotones;
	private final JButton[] botones;
	
	//constructor sin argumentos
	public MarcoPanel() {
		super("Demostracion de Panel - Eduardo Motta");
		botones = new JButton[5];
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, botones.length));
		
		//Crea y agrega los botones
		for (int cuenta = 0; cuenta < botones.length; cuenta++) {
			botones[cuenta] = new JButton("Boton " + (cuenta + 1));
			panelBotones.add(botones[cuenta]); //agrega el botón al panel
		}
		
		add(panelBotones, BorderLayout.WEST); //Agrega el panel a JFrame
	}

} //fin de la clase MarcoPanel

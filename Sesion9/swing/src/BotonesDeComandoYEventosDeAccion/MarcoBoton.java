package BotonesDeComandoYEventosDeAccion;

//Fig. 12.15: MarcoBoton.java
//Botones de comando y eventos de acción.

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MarcoBoton extends JFrame {
	private final JButton botonJButtonSimple;   // botón con texto solamente
	private final JButton botonJButtonElegante; // botón con iconos

	// MarcoBoton agrega objetos JButton a JFrame
	public MarcoBoton() {
		super("Prueba de botones");
		setLayout(new FlowLayout());

		// botón con texto
		botonJButtonSimple = new JButton("Botón simple");
		add(botonJButtonSimple);

		// botones con imágenes
		Icon insecto1 = new ImageIcon(getClass().getResource("davo0.png"));
		Icon insecto2 = new ImageIcon(getClass().getResource("davo1.png"));
		botonJButtonElegante = new JButton("Botón elegante", insecto1);
		botonJButtonElegante.setRolloverIcon(insecto2); // imagen al pasar el mouse
		add(botonJButtonElegante);

		// crea nuevo ManejadorBoton para manejar los eventos
		ManejadorBoton manejador = new ManejadorBoton();
		botonJButtonElegante.addActionListener(manejador);
		botonJButtonSimple.addActionListener(manejador);
	}

	// clase interna para manejar eventos de botón
	private class ManejadorBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evento) {
			JOptionPane.showMessageDialog(
					MarcoBoton.this,
					String.format("Usted oprimió: %s", evento.getActionCommand())
					);
		}
	}
} // fin de la clase MarcoBoton

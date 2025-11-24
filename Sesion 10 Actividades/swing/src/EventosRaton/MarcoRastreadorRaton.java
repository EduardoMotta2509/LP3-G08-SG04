package EventosRaton;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarcoRastreadorRaton extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelRaton; //panel en el que ocurrirán los eventos de ratón
	private final JLabel barraEstado; //muestra información de los eventos
	
	//El constructor de MarcoRastreadorRaton establece la GUI y
	//registra los manejadores de eventos de ratón
	public MarcoRastreadorRaton() {
		super("Demostración de los eventos de raton - Eduardo Motta");
		
		panelRaton = new JPanel();
		panelRaton.setBackground(Color.WHITE);
		add(panelRaton, BorderLayout.CENTER); //agrega el panel a JFrame
		
		barraEstado = new JLabel("Raton fuera de JPanel");
		add(barraEstado, BorderLayout.SOUTH);
		
		//crea y registra un componente de escucha para los eventos de ratón y de su movimiento
		ManejadorRaton manejador = new ManejadorRaton();
		panelRaton.addMouseListener(manejador);
		panelRaton.addMouseMotionListener(manejador);
	}
	
	private class ManejadorRaton implements MouseListener, MouseMotionListener{
		//Los manejadores de eventos de MOuseLIstener manejan el evento cuando suelta el raton justo después de oprimir el botón
		@Override
		public void mouseClicked(MouseEvent evento) {
			barraEstado.setText(String.format("Se hizo click en [%d, %d]", evento.getX(), evento.getY()));
		}
		
		//Maneja evento cuando se oprime el ratón
		@Override
		public void mousePressed(MouseEvent evento) {
			barraEstado.setText(String.format("Se oprimió en [%d, %d]", evento.getX(), evento.getY()));
		}
		
		//maneja evento cuadno se suelta el batón del ratón
		@Override
		public void mouseReleased(MouseEvent evento) {
			barraEstado.setText(String.format("Se soltó en [%d, %d]", evento.getX(), evento.getY()));
		}
		
		//maneja evento cuando el ratón entra al área
		@Override
		public void mouseEntered(MouseEvent evento) {
			barraEstado.setText(String.format("Mouse entró en [%d, %d]", evento.getX(), evento.getY()));
			panelRaton.setBackground(Color.BLACK);
		}
		
		//maneja evento cuando el ratón sale del área
		@Override
		public void mouseExited(MouseEvent evento) {
			barraEstado.setText("Ratón fuera de JPanel");
			panelRaton.setBackground(Color.WHITE);
		}
		
		//maneja evento cuando el usuario mueve el ratón
		@Override
		public void mouseMoved(MouseEvent evento) {
			barraEstado.setText(String.format("Mouse movió en [%d, %d]", evento.getX(), evento.getY()));
		}
	}//FIn de la clase interna ManejadorRaton

}//Fin de la clase MarcoRastreadorRaton

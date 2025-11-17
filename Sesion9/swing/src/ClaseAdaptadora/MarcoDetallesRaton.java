package ClaseAdaptadora;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MarcoDetallesRaton extends JFrame{
	private String detalles; //String que se muestra en barraEstado
	private final JLabel barraEstado; //JLabel que aparece en la parte inferior de la ventana
	
	//Constructor establece String de la barra de titulo y registra componente de escucha del raton
	public MarcoDetallesRaton() {
		super("Clicks y botones del raton - Eduardo Motta");
		barraEstado = new JLabel("Haga click en el raton");
		add(barraEstado, BorderLayout.SOUTH);
		addMouseListener(new ManejadorClicRaton()); //Agrega el manejador
		
	}
	private class ManejadorClicRaton extends MouseAdapter{
		//maneja evento de clic del raton y determina cual botón se oprimió
		@Override
		public void mouseClicked(MouseEvent evento) {
			int xPos = evento.getX(); //Obtiene posicion x del raton en caso requerirse
			int yPos = evento.getY(); //Obtiene posicion y del raton en caso requerirse
			
			detalles = String.format("Se hizo clic %d vez/veces", evento.getClickCount());
			
			if(evento.isMetaDown()) {//Boton derecho del mouse
				detalles += " con el boton derecho del ratón";
			}
			else if (evento.isAltDown()){ //Boton central del raton
				detalles += " con la rueda del ratón";
			}
			else{ //Boton izquierdo del raton
				detalles += " con el botón izquierdo del ratón";
			}
			barraEstado.setText(detalles); //muestra mensaje en barraEstado
			
		}//fin de la clase MarcoDetallesRaton
	}

}

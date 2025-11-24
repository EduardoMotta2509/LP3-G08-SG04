package TextoEImagenes;

import java.awt.FlowLayout;			//Especifica cómo se van a ordenar los componentes
import javax.swing.JFrame;			//Proporciona las características básicas de una ventana
import javax.swing.JLabel;			//muestra texto e imagenes
import javax.swing.SwingConstants;	//constantes comunes con Swing
import javax.swing.Icon;			//interfaz utilizada para manipular imágenes
import javax.swing.ImageIcon;		//carga las imagenes

public class LabelFrame extends JFrame{
	private JLabel etiqueta1; //Jlabel sólo con texto
	private JLabel etiqueta2; //JLabel construida con texto y un ícono
	private JLabel etiqueta3; //JLabel con texto adicional e ícono 15
	
	//El constructor de LabelFrame agrega objetos JLabel a JFrame
	
	//MOdificacion: Icono destinto (Leafeon)
	
	public LabelFrame() {
		//Constructor de JLabel con un argumento String
		super("Prueba de JLabel - Eduardo Motta");
		setLayout(new FlowLayout()); //establece el esquema del marco
		
		//Constructor de JLabel con un argumento String
		etiqueta1 = new JLabel("Etiqueta con texto");
		etiqueta1.setToolTipText("Esta es etiqueta1");
		add(etiqueta1); //agrega etiqueta1 a JFrame
		
		//Constructor de JLabel con argumentos de cadena, Icono y alineación
		Icon leafeon = new ImageIcon(getClass().getResource("leafeon.png"));
		etiqueta2 = new JLabel("Etiqueta con texto y leafeon", leafeon, SwingConstants.LEFT);
		etiqueta2.setToolTipText("Esta es etiqueta2");
		add(etiqueta2);
		
		etiqueta3 = new JLabel(); //constructor de JLabel sin argumentos
		etiqueta3.setText("Etiqueta con leafeon y texto en la parte inferior");
		etiqueta3.setIcon(leafeon); //Agrega icono a JLabel
		etiqueta3.setHorizontalTextPosition(SwingConstants.CENTER);
		etiqueta3.setVerticalTextPosition(SwingConstants.BOTTOM);
		etiqueta3.setToolTipText("Esta es etiqueta3");
		add(etiqueta3); //Agrega etiqueta3 a JFrame
	}
}//Fin de la clase LabelFrame

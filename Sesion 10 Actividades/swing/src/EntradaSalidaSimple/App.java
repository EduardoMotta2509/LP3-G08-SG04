package EntradaSalidaSimple;

import javax.swing.JOptionPane;


public class App {

	public static void main(String[] args) {
		//obtiene la entrada del usuario de los dialogos de entrada de JOptionPane
		//Modificacion: en ves de enteros, cualquier numero
		String primerNumero = javax.swing.JOptionPane.showInputDialog("Introduzca el primer numero");
		
		String segundoNumero = javax.swing.JOptionPane.showInputDialog("Introduzca el segundo numero");
		
		//Convierte las entradas String en valores int para usarlos en un cálculo
		double numero1 = Double.parseDouble(primerNumero);
		double numero2 = Double.parseDouble(segundoNumero);
		double suma = numero1 + numero2;
		
		//muestra los resultados en un diálogo de mensajes de JOptionPane
		JOptionPane.showMessageDialog(null, "La suma es "+ suma, "Suma de dos enteros", JOptionPane.PLAIN_MESSAGE);
	}

}

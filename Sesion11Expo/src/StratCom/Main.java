package StratCom;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        Luz luz = new Luz();
        String input;

        System.out.println("Simulación de Alexa. Di 'enciende' o 'apaga':");
        while (true) {
	        input = scanner.nextLine().toLowerCase();
	
	        Alexa alexa;
	        
	        if (input.contains("enciende")) {
	            alexa = new Alexa(new EstrategiaEncender(), new EncenderCommand(luz));
	        } else if (input.contains("apaga")) {
	            alexa = new Alexa(new EstrategiaApagar(), new ApagarCommand(luz));
	        } else {
	            System.out.println("Comando no reconocido.");
	            return;
	        }
	
	        alexa.procesarComando(input);
        }
	}

}

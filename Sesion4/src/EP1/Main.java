package EP1;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        LeerEntrada leerEntrada = new LeerEntrada(System.in);
        Procesador procesador = new Procesador(leerEntrada);
        System.out.println("Ingrese caracteres. Para salir, ingrese el caracter secreto.");
        
        while (true) {
            try {
                procesador.procesar();
            } catch (ExcepciondeVocal ev) {
                System.out.println("Excepción Vocal: " + ev.getMessage());
            } catch (ExcepciondeNumero en) {
                System.out.println("Excepción Número: " + en.getMessage());
            } catch (ExcepciondeBlanco eb) {
                System.out.println("Excepción Blanco: " + eb.getMessage());
            } catch (ExcepciondeSalida es) {
                System.out.println("Excepción Salida: " + es.getMessage());
                break;
            } catch (IOException ioe) {
                System.out.println("Error de entrada/salida: " + ioe.getMessage());
                break;
            }
        }
        System.out.println("Programa terminado.");
	}

}

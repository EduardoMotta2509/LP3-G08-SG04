package EP1;

import java.io.IOException;

public class Procesador {
    private LeerEntrada leerEntrada;
    private char caracter;
    
    public Procesador(LeerEntrada leerEntrada) {
        this.leerEntrada = leerEntrada;
    }
    
    public void procesar() throws IOException, ExcepciondeVocal, ExcepciondeNumero, ExcepciondeSalida, ExcepciondeBlanco {
        caracter = leerEntrada.getChar();
        if (caracter == '\r' || caracter == '\n') {
            return;
        }
        if (caracter == '°') {
            throw new ExcepciondeSalida("Se ingresó el caracter secreto. Saliendo...");
        }
        if ("aeiouAEIOU".indexOf(caracter) != -1) {
            throw new ExcepciondeVocal("Se detectó una vocal: " + caracter);
        }
        if (Character.isDigit(caracter)) {
            throw new ExcepciondeNumero("Se detectó un número: " + caracter);
        }
        if (Character.isWhitespace(caracter)) {
            throw new ExcepciondeBlanco("Se detectó un espacio en blanco");
        }
        System.out.println("Carácter leído y procesado: " + caracter);
    }
}
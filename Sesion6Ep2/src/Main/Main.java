package Main;

import Modelo.*;
import Vista.*;
import Controlador.*;

public class Main {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioVista vista = new InventarioVista();
        InventarioControlador controlador = new InventarioControlador(modelo, vista);
        controlador.iniciar();
    }
}
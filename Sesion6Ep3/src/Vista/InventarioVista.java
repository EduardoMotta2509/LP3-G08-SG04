package Vista;

import Modelo.Item;
import java.util.List;

public class InventarioVista {

    public void mostrarInventario(List<Item> items) {
        System.out.println("INVENTARIO");
        if (items.isEmpty()) {
            System.out.println("Inventario vacío.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item no encontrado.");
        }
    }
}
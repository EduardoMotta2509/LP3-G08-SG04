package Vista;

import Modelo.Item;
import java.util.List;

public class InventarioVista{
	
	public void mostrarInventario(List<Item> items) {
        System.out.println("\nINVENTARIO: ");
        if (items.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Item i : items) {
                System.out.println(i);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item == null) {
            System.out.println("Item no encontrado.");
        } else {
            System.out.println("\nDETALLES");
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Descripción: " + item.getDescripcion());
        }
    }
}
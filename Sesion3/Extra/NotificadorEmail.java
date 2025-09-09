package Actividad1;

public class NotificadorEmail implements Notificador {
    @Override
    public void enviarNotificacion(String mensaje, String destinatario) {
        System.out.println("Enviando email a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
    }
}

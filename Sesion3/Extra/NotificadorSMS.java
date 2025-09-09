package Actividad1;

public class NotificadorSMS implements Notificador {
    @Override
    public void enviarNotificacion(String mensaje, String destinatario) {
        System.out.println("Enviando SMS a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
    }
}
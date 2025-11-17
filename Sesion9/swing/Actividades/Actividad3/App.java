package Actividad3;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {

        VentanaPasaje v = new VentanaPasaje();

        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setSize(600, 500);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }
}

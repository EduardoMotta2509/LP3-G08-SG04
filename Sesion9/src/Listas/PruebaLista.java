package Listas;

import javax.swing.JFrame;

public class PruebaLista {
    public static void main(String[] args) {
        MarcoLista marcoLista = new MarcoLista();
        marcoLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoLista.setSize(350, 350);
        marcoLista.setLocationRelativeTo(null);
        marcoLista.setVisible(true);
    }
}
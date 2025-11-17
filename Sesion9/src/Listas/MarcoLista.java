package Listas;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class MarcoLista extends JFrame {
    private final JList<String> listaJListColores;
    private static final String[] nombresColores = {"Negro", "Azul", "Cyan",
        "Gris oscuro", "Gris", "Verde", "Gris claro", "Magenta",
        "Naranja", "Rosa", "Rojo", "Blanco", "Amarillo"};
    private static final Color[] colores = {Color.BLACK, Color.BLUE,
        Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
        Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
        Color.RED, Color.WHITE, Color.YELLOW};
    private final JLabel etiquetaInfo; 

    public MarcoLista() {
        super("Listas de eduardo y leandro");
        setLayout(new FlowLayout());

        listaJListColores = new JList<String>(nombresColores);
        listaJListColores.setVisibleRowCount(6);
        listaJListColores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(new JScrollPane(listaJListColores));

        etiquetaInfo = new JLabel("Selecciona un color para ver su info");
        add(etiquetaInfo);

        listaJListColores.addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent evento) {
                    getContentPane().setBackground(
                        colores[listaJListColores.getSelectedIndex()]);
                    etiquetaInfo.setText("RGB: "+colores[listaJListColores.getSelectedIndex()].getRed()+
                    		", "+colores[listaJListColores.getSelectedIndex()].getGreen()+
                    		", "+colores[listaJListColores.getSelectedIndex()].getBlue());
                }
            }
        );
    }
}
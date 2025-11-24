package Actividad1;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MarcoGrid extends JFrame {

    public MarcoGrid() {
        super("GridLayout – Eduardo Motta y Leandro Lagos");

        setLayout(new GridLayout(2, 3, 5, 5));

        for (int i = 1; i <= 6; i++) {
            add(new JButton("Botón " + i));
        }

        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

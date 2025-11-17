package Actividad1;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MarcoFlow extends JFrame {

    public MarcoFlow() {
        super("FlowLayout – Eduardo Motta y Leandro Lagos");

        setLayout(new FlowLayout());

        for (int i = 1; i <= 5; i++) {
            add(new JButton("Botón " + i));
        }

        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

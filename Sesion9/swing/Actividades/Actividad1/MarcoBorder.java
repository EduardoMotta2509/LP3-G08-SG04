package Actividad1;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MarcoBorder extends JFrame {

    public MarcoBorder() {
        super("BorderLayout – Eduardo Motta y Leandro Lagos");

        setLayout(new BorderLayout(5, 5));

        add(new JButton("Norte"), BorderLayout.NORTH);
        add(new JButton("Sur"), BorderLayout.SOUTH);
        add(new JButton("Este"), BorderLayout.EAST);
        add(new JButton("Oeste"), BorderLayout.WEST);
        add(new JButton("Centro"), BorderLayout.CENTER);

        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


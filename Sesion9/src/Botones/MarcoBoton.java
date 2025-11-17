package Botones;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Image; 

public class MarcoBoton extends JFrame {
    private final JButton botonJButtonSimple;
    private final JButton botonJButtonElegante;

    public MarcoBoton() {
        super("Los botones de Eduardo y Leandro");
        setLayout(new FlowLayout());

        botonJButtonSimple = new JButton("Ignorar al rey");
        add(botonJButtonSimple);
        
        ImageIcon iconoOriginal2 = new ImageIcon(getClass().getResource("reyfeliz.png"));
        Image imagenEscalada2 = iconoOriginal2.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        
        Icon enojado = new ImageIcon(getClass().getResource("reyenojado.gif"));
        Icon feliz = new ImageIcon(imagenEscalada2);
        
        botonJButtonElegante = new JButton("Hacer feliz al rey", enojado);
        botonJButtonElegante.setRolloverIcon(feliz);
        
        botonJButtonElegante.setPreferredSize(new java.awt.Dimension(400, 150));
        add(botonJButtonElegante);
        
        ManejadorBoton manejador = new ManejadorBoton();
        
        botonJButtonElegante.addActionListener(manejador);
        botonJButtonSimple.addActionListener(manejador);
    }

    private class ManejadorBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            JOptionPane.showMessageDialog(MarcoBoton.this, String.format(
                "Usted oprimio: %s", evento.getActionCommand()));
        }
    }
}
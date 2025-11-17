package BorderLayout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MarcoBorderLayout extends JFrame implements ActionListener {
    private final JButton botones[];
    private static final String nombres[] = {"Ocultar Norte", "Ocultar Sur",
        "Ocultar Este", "Ocultar Oeste", "Ocultar Centro"};
    private final BorderLayout esquema;
    private final JButton mostrarTodosBoton;  
    private final JButton ocultarTodosBoton;
    
    public MarcoBorderLayout() {
        super("BorderLayout de Eduardo y Leandro");

        esquema = new BorderLayout(5, 5);
        setLayout(esquema);
        botones = new JButton[nombres.length];

        for (int cuenta = 0; cuenta < nombres.length; cuenta++) {
            botones[cuenta] = new JButton(nombres[cuenta]);
            botones[cuenta].addActionListener(this);
        }

        add(botones[0], BorderLayout.NORTH);
        add(botones[1], BorderLayout.SOUTH);
        add(botones[2], BorderLayout.EAST);
        add(botones[3], BorderLayout.WEST);
        add(botones[4], BorderLayout.CENTER);
        
        JPanel panelSur = new JPanel(new FlowLayout());
        mostrarTodosBoton = new JButton("Mostrar Todos");
        ocultarTodosBoton = new JButton("Ocultar Todos");
        mostrarTodosBoton.addActionListener(this);
        ocultarTodosBoton.addActionListener(this);
        panelSur.add(mostrarTodosBoton);
        panelSur.add(ocultarTodosBoton);
        add(panelSur, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == mostrarTodosBoton) {
            for (JButton boton : botones) {
                boton.setVisible(true);
            }
        } else if (evento.getSource() == ocultarTodosBoton) {
            for (JButton boton : botones) {
                boton.setVisible(false);
            }
        } else {
            for (JButton boton : botones) {
                if (evento.getSource() == boton)
                    boton.setVisible(false);
                else
                    boton.setVisible(true);
            }
        }

        esquema.layoutContainer(getContentPane());
    }
}
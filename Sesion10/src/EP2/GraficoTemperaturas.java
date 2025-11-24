package EP2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraficoTemperaturas extends JFrame implements ActionListener {
    private JTextField[] txtTemperaturas;
    private JButton btnMostrar;
    private PanelGrafico panelGrafico;
    private double[] temperaturas;

    public GraficoTemperaturas() {
        super("Gráfico de Temperaturas");
        setLayout(new BorderLayout());
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelInputs = new JPanel();
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        txtTemperaturas = new JTextField[7];
        for (int i = 0; i < 7; i++) {
            panelInputs.add(new JLabel(dias[i] + ":"));
            txtTemperaturas[i] = new JTextField(5);
            panelInputs.add(txtTemperaturas[i]);
        }
        add(panelInputs, BorderLayout.NORTH);

        btnMostrar = new JButton("Mostrar Gráfico");
        btnMostrar.addActionListener(this);
        add(btnMostrar, BorderLayout.SOUTH);

        panelGrafico = new PanelGrafico();
        add(panelGrafico, BorderLayout.CENTER);

        temperaturas = new double[7];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMostrar) {
            try {
                for (int i = 0; i < 7; i++) {
                    temperaturas[i] = Double.parseDouble(txtTemperaturas[i].getText());
                }
                panelGrafico.setTemperaturas(temperaturas);
                panelGrafico.repaint();
            } catch (NumberFormatException ex) {
                System.out.println("No ingresaste valores permitidos - ERROR");
            }
        }
    }

    private class PanelGrafico extends JPanel {
        private double[] temps;

        public void setTemperaturas(double[] temps) {
            this.temps = temps;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (temps == null) return;

            int width = getWidth();
            int height = getHeight();
            int xStep = width / 8; 
            int yBase = height - 50;  

            g.setColor(Color.BLUE);
            for (int i = 0; i < 7; i++) {
                int x = (i + 1) * xStep;
                int y = yBase - (int) (temps[i] * 5);
                g.fillOval(x - 5, y - 5, 10, 10);  
                g.drawString(String.valueOf(temps[i]), x - 10, y - 10);
                if (i > 0) {
                    int prevX = i * xStep;
                    int prevY = yBase - (int) (temps[i - 1] * 5);
                    g.drawLine(prevX, prevY, x, y);  
                }
            }
        }
    }

    public static void main(String[] args) {
        GraficoTemperaturas app = new GraficoTemperaturas();
        app.setVisible(true);
    }
}
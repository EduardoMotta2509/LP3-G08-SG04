package SwingAv;

import javax.swing.*;
import java.awt.*;

public class AppGraficoPastel extends JPanel {
    
    private String[] categorias = {"Aprobados", "Desaprobados", "Retirados"};
    private int[] valores = {60, 30, 10}; // Total = 100
    private Color[] colores = {Color.GREEN, Color.RED, Color.GRAY};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int total = 0;
        for (int v : valores) total += v;

        int anguloInicio = 0;
        int x = 50;
        int y = 50;
        int diametro = 200;

        for (int i = 0; i < valores.length; i++) {
            int anguloArco = (int) Math.round(((double) valores[i] / total) * 360);
            
            if (i == valores.length - 1) {
                anguloArco = 360 - anguloInicio;
            }

            g2d.setColor(colores[i]);
            g2d.fillArc(x, y, diametro, diametro, anguloInicio, anguloArco);
            
            g2d.fillRect(300, y + (i * 30), 20, 20);
            g2d.setColor(Color.BLACK);
            g2d.drawString(categorias[i] + " (" + valores[i] + ")", 330, y + (i * 30) + 15);

            anguloInicio += anguloArco;
        }
        
        g2d.drawString("Gráfico de Rendimiento", 100, 280);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gráfico de Pastel con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.add(new AppGraficoPastel());
        frame.setVisible(true);
    }
}
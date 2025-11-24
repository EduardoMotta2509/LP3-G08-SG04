package SwingAv;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AppReproductor extends JFrame {
    private Clip clip;
    private JLabel lblEstado;

    public AppReproductor() {
        super("Reproductor de Audio Flexible");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnCargar = new JButton("Cargar y Reproducir");
        JButton btnDetener = new JButton("Detener");
        lblEstado = new JLabel("Seleccione un archivo .wav");

        btnCargar.addActionListener(e -> seleccionarYReproducir());
        
        btnDetener.addActionListener(e -> {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                lblEstado.setText("Reproducción detenida.");
            }
        });

        add(btnCargar);
        add(btnDetener);
        add(lblEstado);
    }

    private void seleccionarYReproducir() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            reproducirAudio(archivo);
        }
    }

    private void reproducirAudio(File archivo) {
        try {
            // Detener audio previo si existe
            if (clip != null && clip.isOpen()) {
                clip.close();
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            lblEstado.setText("Reproduciendo: " + archivo.getName());

        } catch (Exception ex) {
            lblEstado.setText("Error: Formato no soportado o archivo dañado.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppReproductor().setVisible(true));
    }
}
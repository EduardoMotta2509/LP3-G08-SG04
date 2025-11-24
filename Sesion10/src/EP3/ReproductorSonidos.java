package EP3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ReproductorSonidos extends JFrame implements ActionListener {
    private JButton btnHuh, btnEnojado, btnExplosion;

    public ReproductorSonidos() {
        super("Reproductor de Sonidos");
        setLayout(new FlowLayout());
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        btnHuh = new JButton("?");
        btnHuh.addActionListener(this);
        add(btnHuh);

        btnEnojado = new JButton("Enojado");
        btnEnojado.addActionListener(this);
        add(btnEnojado);

        btnExplosion = new JButton("Explosión");
        btnExplosion.addActionListener(this);
        add(btnExplosion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sonido = "";
        if (e.getSource() == btnHuh) {
            sonido = "huh.wav";
        } else if (e.getSource() == btnEnojado) {
            sonido = "enojo.wav";
        } else if (e.getSource() == btnExplosion) {
            sonido = "explosion.wav";
        }


        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(sonido));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();  
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace(); 
        }
    }

    public static void main(String[] args) {
        ReproductorSonidos app = new ReproductorSonidos();
        app.setVisible(true);
    }
}
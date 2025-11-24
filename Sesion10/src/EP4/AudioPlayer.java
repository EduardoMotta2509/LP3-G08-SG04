package EP4;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class AudioPlayer extends JFrame {
    private Clip clip;
    private Long pausePosition = 0L;

    public AudioPlayer() {
        setTitle("Reproductor de Audio");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnPlay = new JButton("Reproducir");
        JButton btnPause = new JButton("Pausar");
        JButton btnResume = new JButton("Reanudar");

        btnPlay.addActionListener(e -> playAudio());
        btnPause.addActionListener(e -> pauseAudio());
        btnResume.addActionListener(e -> resumeAudio());

        setLayout(new FlowLayout());
        add(btnPlay);
        add(btnPause);
        add(btnResume);
    }

    private void loadAudio() {
        try {
            if (clip == null) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\leand\\eclipse-workspace\\Sesion10\\src\\EP4\\dumbai.wav"));
                clip = AudioSystem.getClip();
                clip.open(audioStream);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void playAudio() {
        try {
            loadAudio();
            clip.stop();
            clip.setFramePosition(0);
            clip.start();
            pausePosition = 0L;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pauseAudio() {
        if (clip != null && clip.isRunning()) {
            pausePosition = (long) clip.getFramePosition();
            clip.stop();
        }
    }

    private void resumeAudio() {
        if (clip != null && !clip.isRunning()) {
            clip.setFramePosition(pausePosition.intValue());
            clip.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AudioPlayer().setVisible(true);
        });
    }
}


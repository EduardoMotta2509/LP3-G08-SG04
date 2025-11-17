package BorderLayout;

import javax.swing.JFrame;

public class DemoBorderLayout {
    public static void main(String[] args) {
        MarcoBorderLayout marcoBorderLayout = new MarcoBorderLayout();
        marcoBorderLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoBorderLayout.setSize(500, 200);
        marcoBorderLayout.setLocationRelativeTo(null);
        marcoBorderLayout.setVisible(true);
    }
}
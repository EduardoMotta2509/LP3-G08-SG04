package SwingAv;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AppInventario {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Inventario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        Producto prod = new Producto("Laptop Gamer", 1200.00, 5);

        JTextField txtNombre = new JTextField(prod.getNombre());
        JTextField txtPrecio = new JTextField(String.valueOf(prod.getPrecio()));
        JTextField txtStock = new JTextField(String.valueOf(prod.getStock()));
        JButton btnActualizar = new JButton("Actualizar Producto");
        JLabel lblEstado = new JLabel("Estado: Sin cambios");

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double precio = Double.parseDouble(txtPrecio.getText());
                    int stock = Integer.parseInt(txtStock.getText());

                    if (precio < 0 || stock < 0) {
                        JOptionPane.showMessageDialog(frame, "El precio y stock no pueden ser negativos.");
                        return;
                    }

                    // Actualizar Modelo
                    prod.setNombre(txtNombre.getText());
                    prod.setPrecio(precio);
                    prod.setStock(stock);

                    lblEstado.setText("Estado: Producto actualizado a las " + java.time.LocalTime.now());
                    System.out.println("Producto: " + prod.getNombre() + " | Stock: " + prod.getStock());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Ingrese valores numéricos válidos.");
                }
            }
        });

        frame.add(new JLabel("Producto:")); frame.add(txtNombre);
        frame.add(new JLabel("Precio ($):")); frame.add(txtPrecio);
        frame.add(new JLabel("Stock (u):")); frame.add(txtStock);
        frame.add(btnActualizar); frame.add(lblEstado);

        frame.setVisible(true);
    }
}
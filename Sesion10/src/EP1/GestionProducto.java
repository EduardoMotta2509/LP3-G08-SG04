package EP1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GestionProducto extends JFrame implements ActionListener {
    private JTextField txtNombre, txtPrecio, txtStock, txtCategoria;
    private JButton btnActualizar;
    private JLabel lblInfo;
    private Producto producto;

    public GestionProducto() {
        super("Gestión de Producto");
        setLayout(new FlowLayout());
        setSize(700, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(10);
        add(txtNombre);

        add(new JLabel("Precio:"));
        txtPrecio = new JTextField(10);
        add(txtPrecio);

        add(new JLabel("Stock:"));
        txtStock = new JTextField(10);
        add(txtStock);

        add(new JLabel("Categoría:"));
        txtCategoria = new JTextField(10);
        add(txtCategoria);


        btnActualizar = new JButton("Actualizar Producto");
        btnActualizar.addActionListener(this);
        add(btnActualizar);

        lblInfo = new JLabel("Información del producto aparecerá aquí");
        add(lblInfo);

        producto = new Producto("", 0, 0, ""); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnActualizar) {
            try {
                String nombre = txtNombre.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                int stock = Integer.parseInt(txtStock.getText());
                String categoria = txtCategoria.getText();

                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setCantidadStock(stock);
                producto.setCategoria(categoria);

                lblInfo.setText(producto.toString());
            } catch (NumberFormatException ex) {
                lblInfo.setText("Error: Ingresa números válidos para precio y stock");
            }
        }
    }

    public static void main(String[] args) {
        GestionProducto app = new GestionProducto();
        app.setVisible(true);
    }
}
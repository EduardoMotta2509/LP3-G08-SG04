package Actividad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPasaje extends JFrame {

    private JTextField txtNombre, txtDni, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbPiso1, rbPiso2;
    private JComboBox<String> cboOrigen, cboDestino;
    private JList<String> listaServicio;
    private JButton btnLimpiar, btnResumen;

    public VentanaPasaje() {
        super("Compra de Pasajes - Empresa de Transporte");

        setLayout(new GridLayout(9, 1));

        // ----------- 1. DATOS DEL PASAJERO ---------------
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(15);
        p1.add(txtNombre);

        p1.add(new JLabel("DNI:"));
        txtDni = new JTextField(10);
        p1.add(txtDni);

        p1.add(new JLabel("Fecha Viaje:"));
        txtFecha = new JTextField(10);
        p1.add(txtFecha);

        add(p1);

        // ----------- 2. CASILLAS DE VERIFICACIÓN ---------------
        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("Servicios opcionales"));
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");

        p2.add(chkAudifonos);
        p2.add(chkManta);
        p2.add(chkRevistas);

        add(p2);

        // ----------- 3. RADIO BUTTONS ------------------------
        JPanel p3 = new JPanel();
        p3.setBorder(BorderFactory.createTitledBorder("Piso de Viaje"));

        rbPiso1 = new JRadioButton("1er piso");
        rbPiso2 = new JRadioButton("2do piso");

        ButtonGroup grupoPisos = new ButtonGroup();
        grupoPisos.add(rbPiso1);
        grupoPisos.add(rbPiso2);

        p3.add(rbPiso1);
        p3.add(rbPiso2);

        add(p3);

        // ----------- 4. COMBO BOX -----------------------------
        JPanel p4 = new JPanel();
        p4.add(new JLabel("Origen:"));
        cboOrigen = new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Puno"});
        p4.add(cboOrigen);

        p4.add(new JLabel("Destino:"));
        cboDestino = new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Puno"});
        p4.add(cboDestino);

        add(p4);

        // ----------- 5. LISTA ------------------------------
        JPanel p5 = new JPanel();
        p5.setBorder(BorderFactory.createTitledBorder("Tipo de servicio"));

        listaServicio = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        listaServicio.setVisibleRowCount(3);
        p5.add(new JScrollPane(listaServicio));

        add(p5);

        // ----------- 6. BOTONES -----------------------------
        JPanel p6 = new JPanel();
        btnLimpiar = new JButton("Limpiar");
        btnResumen = new JButton("Mostrar Resumen");

        p6.add(btnLimpiar);
        p6.add(btnResumen);

        add(p6);

        // ----------- 7. EVENTOS -----------------------------
        btnResumen.addActionListener(e -> mostrarResumen());
        btnLimpiar.addActionListener(e -> limpiarTodo());
    }

    private void mostrarResumen() {
        String nombre = txtNombre.getText();
        String dni = txtDni.getText();
        String fecha = txtFecha.getText();

        String servicios = "";
        if (chkAudifonos.isSelected()) servicios += "Audífonos ";
        if (chkManta.isSelected()) servicios += "Manta ";
        if (chkRevistas.isSelected()) servicios += "Revistas ";

        String piso = rbPiso1.isSelected() ? "1er piso" : "2do piso";

        String origen = (String) cboOrigen.getSelectedItem();
        String destino = (String) cboDestino.getSelectedItem();

        String tipoServicio = listaServicio.getSelectedValue();

        String mensaje = 
            "----- RESUMEN DE COMPRA -----\n" +
            "Nombre: " + nombre + "\n" +
            "DNI: " + dni + "\n" +
            "Fecha: " + fecha + "\n\n" +
            "Servicios opcionales: " + servicios + "\n" +
            "Piso: " + piso + "\n" +
            "Origen: " + origen + "\n" +
            "Destino: " + destino + "\n" +
            "Servicio: " + tipoServicio;

        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void limpiarTodo() {
        txtNombre.setText("");
        txtDni.setText("");
        txtFecha.setText("");

        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);

        rbPiso1.setSelected(false);
        rbPiso2.setSelected(false);

        cboOrigen.setSelectedIndex(0);
        cboDestino.setSelectedIndex(0);

        listaServicio.clearSelection();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package sisGestion.vistaGui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sisGestion.controller.AdminController;
import sisGestion.model.EmployeeType;

/**
 *
 * @author Marcela Realpe
 */
public class DialogoAgregarEmpleado extends javax.swing.JDialog {
        // Referencia al controlador
    private final AdminController adminController;

    // Componentes del formulario
    private JTextField txtNombre, txtTipoDoc, txtNumDoc, txtEmail, txtEdad, txtFechaIngreso, txtSalario, txtHorario, txtExtra;
    private JComboBox<EmployeeType> comboTipoContrato;
    private JLabel lblExtra;

    public DialogoAgregarEmpleado(JFrame parent, boolean modal, AdminController adminController) {
        super(parent, modal);
        this.adminController = adminController;

        setTitle("Agregar Nuevo Empleado");
        setSize(400, 550);
        setLayout(new GridLayout(12, 2, 10, 10)); // Layout simple de rejilla
        setLocationRelativeTo(parent);

        // Inicializar y agregar componentes al diálogo
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Tipo Documento:"));
        txtTipoDoc = new JTextField();
        add(txtTipoDoc);

        add(new JLabel("Número Documento:"));
        txtNumDoc = new JTextField();
        add(txtNumDoc);

        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        add(txtEdad);

        add(new JLabel("Fecha Ingreso:"));
        txtFechaIngreso = new JTextField();
        add(txtFechaIngreso);

        add(new JLabel("Salario:"));
        txtSalario = new JTextField();
        add(txtSalario);

        add(new JLabel("Horario:"));
        txtHorario = new JTextField();
        add(txtHorario);

        add(new JLabel("Tipo Contrato:"));
        comboTipoContrato = new JComboBox<>(EmployeeType.values());
        add(comboTipoContrato);

        lblExtra = new JLabel("Beneficios:"); // Etiqueta dinámica
        add(lblExtra);
        txtExtra = new JTextField();
        add(txtExtra);

        // Cambiar la etiqueta extra según el tipo de contrato seleccionado
        comboTipoContrato.addActionListener(e -> actualizarCampoExtra());

        JButton btnGuardar = new JButton("Guardar");
        add(btnGuardar);
        btnGuardar.addActionListener(e -> guardarEmpleado());

        JButton btnCancelar = new JButton("Cancelar");
        add(btnCancelar);
        btnCancelar.addActionListener(e -> dispose()); // Cierra el diálogo
        
        actualizarCampoExtra(); // Para que la etiqueta sea correcta al inicio
    }

    private void actualizarCampoExtra() {
        EmployeeType tipoSeleccionado = (EmployeeType) comboTipoContrato.getSelectedItem();
        if (tipoSeleccionado == EmployeeType.TEMPORAL) {
            lblExtra.setText("Fecha Fin Contrato:");
        } else {
            lblExtra.setText("Beneficios:");
        }
    }
    
    private void guardarEmpleado() {
        try {
            // Recolectar datos del formulario
            String nombre = txtNombre.getText();
            String tipoDoc = txtTipoDoc.getText();
            int numDoc = Integer.parseInt(txtNumDoc.getText());
            String email = txtEmail.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String fechaIngreso = txtFechaIngreso.getText();
            String salario = txtSalario.getText();
            String horario = txtHorario.getText();
            EmployeeType tipoContrato = (EmployeeType) comboTipoContrato.getSelectedItem();
            String extra = txtExtra.getText();
            
            // Validar que los campos no estén vacíos
            if(nombre.isEmpty() || tipoDoc.isEmpty() || email.isEmpty()){
                JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Llamar al controlador para crear el empleado
            adminController.createEmployeeFromUI(nombre, tipoDoc, numDoc, email, edad, fechaIngreso, salario, horario, tipoContrato, extra);

            JOptionPane.showMessageDialog(this, "Empleado creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Cerrar el diálogo

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para Documento y Edad.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DialogoAgregarEmpleado.class.getName());

    /**
     * Creates new form DialogoAgregarEmpleado
     */
    public DialogoAgregarEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.adminController = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DialogoAgregarEmpleado dialog = new DialogoAgregarEmpleado(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

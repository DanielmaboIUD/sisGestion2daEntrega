/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package sisGestion.vistaGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import sisGestion.controller.DepartmentController;


public class DialogoAgregarDepartamento extends javax.swing.JDialog {
    
    private final DepartmentController departmentController;
    private JTextField txtNombre;


    public DialogoAgregarDepartamento(JFrame parent, boolean modal, DepartmentController departmentController) {
        super(parent, modal);
        this.departmentController = departmentController;
        initComponents(); 
        construirInterfaz();
    }
    private void construirInterfaz() {
        setTitle("Agregar Nuevo Departamento");
        setSize(400, 160); // Ajustamos el tamaño
        setLayout(new BorderLayout(10, 10)); // Usamos BorderLayout
        setLocationRelativeTo(getParent());

        // Panel para el formulario (arriba)
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        formPanel.setBorder(new EmptyBorder(10, 10, 0, 10)); // Margen
        formPanel.add(new JLabel("Nombre del Departamento:"));
        txtNombre = new JTextField(20); // 20 columnas de ancho
        formPanel.add(txtNombre);
        add(formPanel, BorderLayout.CENTER);

        // Panel para los botones (abajo)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnCancelar);
        add(buttonPanel, BorderLayout.SOUTH);

        // Acciones de los botones
        btnGuardar.addActionListener(e -> guardarDepartamento());
        btnCancelar.addActionListener(e -> dispose()); // dispose() cierra la ventana
    }
    
    private void guardarDepartamento() {
        String nombre = txtNombre.getText().trim(); // trim() quita espacios en blanco

        // Validación simple
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del departamento no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return; // Detiene la ejecución si el campo está vacío
        }

        // Llamamos al controlador para que haga el trabajo de verdad
        departmentController.createDepartment(nombre);
        
        JOptionPane.showMessageDialog(this, "Departamento '" + nombre + "' creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        dispose(); // Cerramos el diálogo si todo salió bien
    }
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DialogoAgregarDepartamento dialog = new DialogoAgregarDepartamento(new javax.swing.JFrame(), true, null); // Pasamos null porque es solo una prueba
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

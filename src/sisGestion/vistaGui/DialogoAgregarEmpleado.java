/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package sisGestion.vistaGui;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sisGestion.controller.AdminController;
import sisGestion.controller.DepartmentController;
import sisGestion.model.Department;
import sisGestion.model.Employee;
import sisGestion.model.EmployeeType;

public class DialogoAgregarEmpleado extends javax.swing.JDialog {
    private final AdminController adminController;
    private final DepartmentController departmentController;

    private JTextField txtNombre, txtTipoDoc, txtNumDoc, txtEmail, txtEdad, txtFechaIngreso, txtSalario, txtHorario, txtExtra;
    private JComboBox<EmployeeType> comboTipoContrato;
    private JComboBox<Object> comboDepartamentos;
    private JLabel lblExtra;
    private Employee empleadoAEditar;

    public DialogoAgregarEmpleado(JFrame parent, boolean modal, AdminController adminController, 
           DepartmentController departmentController) {
        super(parent, modal);
        this.adminController = adminController;
        this.departmentController = departmentController;

        setTitle("Agregar Nuevo Empleado");
        setSize(400, 600);
        setLayout(new GridLayout(13, 2, 10, 10));
        setLocationRelativeTo(parent);

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

        lblExtra = new JLabel("Beneficios:");
        add(lblExtra);
        txtExtra = new JTextField();
        add(txtExtra);
        
        add(new JLabel("Departamento:"));
        comboDepartamentos = new JComboBox<>();
        cargarDepartamentos();
        add(comboDepartamentos);

        comboTipoContrato.addActionListener(e -> actualizarCampoExtra());

        JButton btnGuardar = new JButton("Guardar");
        add(btnGuardar);
        btnGuardar.addActionListener(e -> guardarEmpleado());

        JButton btnCancelar = new JButton("Cancelar");
        add(btnCancelar);
        btnCancelar.addActionListener(e -> dispose());
        
        actualizarCampoExtra();
    }
    
        public DialogoAgregarEmpleado(JFrame parent, boolean modal, AdminController adminController, 
            DepartmentController departmentController, Employee empleadoAEditar) {
            this(parent, modal, adminController, departmentController);
            this.empleadoAEditar = empleadoAEditar;
            setTitle("Editar Empleado");

            llenarFormulario();
        }
        
        private void llenarFormulario() {
            txtNombre.setText(empleadoAEditar.getName());
            txtTipoDoc.setText(empleadoAEditar.getDocumentType());
            txtNumDoc.setText(String.valueOf(empleadoAEditar.getDocumentNumber()));
            txtEmail.setText(empleadoAEditar.getEmail());
            txtEdad.setText(String.valueOf(empleadoAEditar.getAge()));
            txtFechaIngreso.setText(empleadoAEditar.getEntryDate());
            txtSalario.setText(empleadoAEditar.getPayment());
            txtHorario.setText(empleadoAEditar.getSchedule());

            comboTipoContrato.setSelectedItem(EmployeeType.valueOf(empleadoAEditar.getContractType()));

            if (empleadoAEditar instanceof sisGestion.model.PermEmployee perm) {
                txtExtra.setText(perm.getBenefits());
            } else if (empleadoAEditar instanceof sisGestion.model.TempEmployee temp) {
                txtExtra.setText(temp.getOutDate());
            }

            Department deptoActual = departmentController.findDepartmentOfEmployee(empleadoAEditar);
            if (deptoActual != null) {
                comboDepartamentos.setSelectedItem(deptoActual);
            }
}
    
        private void cargarDepartamentos() {
        List<Department> departamentos = departmentController.getDepartments();
        if (departamentos.isEmpty()) {
            comboDepartamentos.addItem("Sin departamentos (crear primero)");
            comboDepartamentos.setEnabled(false);
        } else {
            comboDepartamentos.addItem("Seleccionar departamento...");
            for (Department dept : departamentos) {
                comboDepartamentos.addItem(dept);
            }
        }
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
            
            if(nombre.isEmpty() || tipoDoc.isEmpty() || email.isEmpty()){
                JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Department deptoSeleccionado = null;
            Object itemSeleccionado = comboDepartamentos.getSelectedItem();
            if (itemSeleccionado instanceof Department) {
                  deptoSeleccionado = (Department) itemSeleccionado;
            }
            if (empleadoAEditar != null) {
                adminController.actualizarEmpleado(empleadoAEditar.getCode(), nombre, tipoDoc, numDoc, email, edad, fechaIngreso, 
                            salario, horario, tipoContrato, extra, deptoSeleccionado);
                JOptionPane.showMessageDialog(this, "Empleado actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                adminController.createEmployeeFromUI(nombre, tipoDoc, numDoc, email, edad, fechaIngreso, 
                            salario, horario, tipoContrato, extra, deptoSeleccionado);

                JOptionPane.showMessageDialog(this, "Empleado creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            


        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para Documento y Edad.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

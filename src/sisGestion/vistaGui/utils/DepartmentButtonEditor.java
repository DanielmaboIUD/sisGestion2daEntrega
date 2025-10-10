/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.vistaGui.utils;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import sisGestion.controller.DepartmentController;
import sisGestion.model.Department;
import sisGestion.vistaGui.DialogoEditarDepartamento;
import sisGestion.vistaGui.VentanaPrincipal;

public class DepartmentButtonEditor extends DefaultCellEditor {

    protected JPanel panel;
    protected JButton editButton;
    protected JButton deleteButton;
    private JTable table;
    private int row;
    private DepartmentController departmentController;
    private VentanaPrincipal ventanaPrincipal;

    public DepartmentButtonEditor(JCheckBox checkBox, DepartmentController controller, VentanaPrincipal ventana) {
        super(checkBox);
        this.departmentController = controller;
        this.ventanaPrincipal = ventana;
        
        panel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));
        editButton = new JButton("Editar");
        deleteButton = new JButton("Eliminar");
        panel.add(editButton);
        panel.add(deleteButton);

        editButton.addActionListener(e -> {
            fireEditingStopped();
            int id = (int) table.getValueAt(row, 0);
            Department depto = departmentController.findDepartmentByCode(id);
            if (depto != null) {
                DialogoEditarDepartamento dialogo = new DialogoEditarDepartamento(ventanaPrincipal, true, departmentController, depto);
                dialogo.setVisible(true);
                ventanaPrincipal.actualizarTablaDepartamentos();
                ventanaPrincipal.actualizarTablaEmpleados();
            }
        });

        deleteButton.addActionListener(e -> {
            fireEditingStopped();
            int id = (int) table.getValueAt(row, 0);
            Department depto = departmentController.findDepartmentByCode(id);
            if (depto != null) {
                if (departmentController.eliminarDepartamento(id) != null) {
                    ventanaPrincipal.actualizarTablaDepartamentos();
                    ventanaPrincipal.actualizarTablaEmpleados();
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        return panel;
    }
    
    @Override
    public Object getCellEditorValue() {
        return "";
    }
}

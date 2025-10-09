/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.vistaGui.utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import sisGestion.controller.AdminController;
import sisGestion.controller.DepartmentController;
import sisGestion.vistaGui.VentanaPrincipal;

public class ButtonEditor extends DefaultCellEditor{
    
    protected JPanel panel;
    protected JButton editButton;
    protected JButton deleteButton;
    private JTable table;
    private int row;
    private AdminController adminController;
    private DepartmentController departmentController;
    private VentanaPrincipal ventanaPrincipal;
    
    public ButtonEditor(JCheckBox checkBox, AdminController adminController, 
           DepartmentController departmentController, VentanaPrincipal ventanaPrincipal) {
        super(checkBox);
        this.adminController = adminController;
        this.departmentController = departmentController;
        this.ventanaPrincipal = ventanaPrincipal;
        panel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));
        editButton = new JButton("Editar");
        deleteButton = new JButton("Eliminar");
        panel.add(editButton);
        panel.add(deleteButton);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                JOptionPane.showMessageDialog(null, "Acción EDITAR para la fila: " + row);
            }
        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();

                int confirm = JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro de que deseas eliminar este registro?",
                        "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    int id = (int) table.getValueAt(row, 0);
                    adminController.eliminarEmpleado(id);
                    ventanaPrincipal.actualizarTablaEmpleados();
                    ventanaPrincipal.actualizarTablaDepartamentos();
                }
            }
        });
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        
        if (isSelected) {
            panel.setBackground(table.getSelectionBackground());
        } else {
            panel.setBackground(table.getBackground());
        }
        return panel;
    }
    
    @Override
    public Object getCellEditorValue() {
        return "";
    }
    
}

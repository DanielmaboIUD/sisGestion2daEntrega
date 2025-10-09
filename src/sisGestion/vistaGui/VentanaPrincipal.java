/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sisGestion.vistaGui;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import sisGestion.controller.AdminController;
import sisGestion.controller.DepartmentController;
import sisGestion.model.Department;
import sisGestion.model.Employee;
import sisGestion.vistaGui.utils.ButtonEditor;
import sisGestion.vistaGui.utils.ButtonRenderer;
import javax.swing.JCheckBox;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());
    private final AdminController adminController;
    private final DepartmentController departmentController;
    
    public VentanaPrincipal(AdminController adminController, DepartmentController deptController) {
        this.adminController = adminController;
        this.departmentController = deptController;
        
        initComponents();
        configurarEventos();
        configurarAnchosDeColumnas();
        
        int alturaFila = 35; // Puedes cambiar este valor
        TablaEmpleados.setRowHeight(alturaFila);
        TablaDepartamentos.setRowHeight(alturaFila);
        
        int accionesColumnIndex = TablaEmpleados.getColumnModel().getColumnCount() - 1;
        TablaEmpleados.getColumnModel().getColumn(accionesColumnIndex).setCellRenderer(new ButtonRenderer());
        TablaEmpleados.getColumnModel().getColumn(accionesColumnIndex).setCellEditor(new ButtonEditor(new JCheckBox()));
        
        actualizarTablaEmpleados();
        actualizarTablaDepartamentos();
        this.setLocationRelativeTo(null);
    }

    private void configurarEventos() {
        AggBtnEmpleados.addActionListener(e -> abrirDialogoAgregarEmpleado());
        SalirBtnEmpleados.addActionListener(e -> System.exit(0));
        SalirBtnDepartamentos.addActionListener(e -> System.exit(0));
        AggBtnDepartamentos.addActionListener(e -> abrirDialogoAgregarDepartamento());
        
    }
    
    private void abrirDialogoAgregarDepartamento() {
    DialogoAgregarDepartamento dialogo = new DialogoAgregarDepartamento(this, true, departmentController);
    dialogo.setVisible(true);

    actualizarTablaDepartamentos();
    actualizarTablaDepartamentos();
    }

    private void abrirDialogoAgregarEmpleado() {
        DialogoAgregarEmpleado dialogo = new DialogoAgregarEmpleado(this, true, adminController, departmentController);
        dialogo.setVisible(true);

        
        actualizarTablaEmpleados();
    }

    public void actualizarTablaEmpleados() {
        DefaultTableModel model = (DefaultTableModel) TablaEmpleados.getModel();
        model.setRowCount(0);

        List<Employee> empleados = adminController.getEmployees();

        for (Employee emp : empleados) {
            
            Department deptDelEmpleado = departmentController.findDepartmentOfEmployee(emp);
        
            String nombreDepto = (deptDelEmpleado != null) ? deptDelEmpleado.getName() : "Sin asignar";
            
            Object[] rowData = {
                emp.getCode(),
                emp.getName(),
                emp.getDocumentNumber(),
                nombreDepto,
                emp.getSchedule(),
                "Acciones"
            };
            model.addRow(rowData);
        }
    }
    
    public void actualizarTablaDepartamentos() {
    DefaultTableModel model = (DefaultTableModel) TablaDepartamentos.getModel();
    model.setRowCount(0);

    List<Department> departamentos = departmentController.getDepartments();

    for (Department dept : departamentos) {
        Object[] rowData = {
            dept.getCode(),
            dept.getName(),
            (dept.getDepartmentHead() != null) ? dept.getDepartmentHead().getName() : "N/A",
            "Acciones"
        };
        model.addRow(rowData);
    }
    }
    
    private void configurarAnchosDeColumnas() {
    // Obtenemos el modelo de columnas de la tabla de empleados
    javax.swing.table.TableColumnModel columnModel = TablaEmpleados.getColumnModel();

    // Columna 0: "ID" - la hacemos pequeña
    columnModel.getColumn(0).setPreferredWidth(40);
    columnModel.getColumn(0).setMaxWidth(50); // Opcional: fija un tamaño máximo

    // Columna 1: "Nombre" - le damos más espacio
    columnModel.getColumn(1).setPreferredWidth(200);

    // Columna 2: "Num Documento" - tamaño mediano
    columnModel.getColumn(2).setPreferredWidth(120);
    
    // Columna 3: "Departamento" - tamaño mediano
    columnModel.getColumn(3).setPreferredWidth(120);

    // Columna 4: "Turno" - tamaño mediano/pequeño
    columnModel.getColumn(4).setPreferredWidth(100);

    // Columna 5: "Acciones" - la hacemos más ancha para que quepan los botones
    columnModel.getColumn(5).setPreferredWidth(160);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JTabbedPane();
        TabEmpleados = new javax.swing.JPanel();
        BuscarEmpleadoText = new javax.swing.JTextField();
        ScrollListaEmpleado = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        SalirBtnEmpleados = new javax.swing.JButton();
        AggBtnEmpleados = new javax.swing.JButton();
        TabDepartamento = new javax.swing.JPanel();
        BuscarDepartamentoText = new javax.swing.JTextField();
        ScrollListaDepartamento = new javax.swing.JScrollPane();
        TablaDepartamentos = new javax.swing.JTable();
        SalirBtnDepartamentos = new javax.swing.JButton();
        AggBtnDepartamentos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BuscarEmpleadoText.setForeground(new java.awt.Color(199, 189, 189));
        BuscarEmpleadoText.setText("🔍Buscar...");
        BuscarEmpleadoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarEmpleadoTextActionPerformed(evt);
            }
        });

        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", " Nombre", "Num Documento", "Departamento", "Turno", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollListaEmpleado.setViewportView(TablaEmpleados);

        SalirBtnEmpleados.setText("Salir");

        AggBtnEmpleados.setText("Agregar");

        javax.swing.GroupLayout TabEmpleadosLayout = new javax.swing.GroupLayout(TabEmpleados);
        TabEmpleados.setLayout(TabEmpleadosLayout);
        TabEmpleadosLayout.setHorizontalGroup(
            TabEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BuscarEmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TabEmpleadosLayout.createSequentialGroup()
                        .addComponent(ScrollListaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(TabEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SalirBtnEmpleados)
                            .addComponent(AggBtnEmpleados))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        TabEmpleadosLayout.setVerticalGroup(
            TabEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabEmpleadosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BuscarEmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TabEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TabEmpleadosLayout.createSequentialGroup()
                        .addComponent(AggBtnEmpleados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SalirBtnEmpleados))
                    .addComponent(ScrollListaEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelPrincipal.addTab("EMPLEADOS", TabEmpleados);

        BuscarDepartamentoText.setForeground(new java.awt.Color(199, 189, 189));
        BuscarDepartamentoText.setText("🔍Buscar...");
        BuscarDepartamentoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarDepartamentoTextActionPerformed(evt);
            }
        });

        TablaDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre departamento", "Jefe departamento", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollListaDepartamento.setViewportView(TablaDepartamentos);

        SalirBtnDepartamentos.setText("Salir");

        AggBtnDepartamentos.setText("Agregar");

        javax.swing.GroupLayout TabDepartamentoLayout = new javax.swing.GroupLayout(TabDepartamento);
        TabDepartamento.setLayout(TabDepartamentoLayout);
        TabDepartamentoLayout.setHorizontalGroup(
            TabDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabDepartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BuscarDepartamentoText, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TabDepartamentoLayout.createSequentialGroup()
                        .addComponent(ScrollListaDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(TabDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SalirBtnDepartamentos)
                            .addComponent(AggBtnDepartamentos))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        TabDepartamentoLayout.setVerticalGroup(
            TabDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabDepartamentoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BuscarDepartamentoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TabDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TabDepartamentoLayout.createSequentialGroup()
                        .addComponent(AggBtnDepartamentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SalirBtnDepartamentos))
                    .addComponent(ScrollListaDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelPrincipal.addTab("DEPARTAMENTOS", TabDepartamento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarEmpleadoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarEmpleadoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarEmpleadoTextActionPerformed

    private void BuscarDepartamentoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarDepartamentoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarDepartamentoTextActionPerformed

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            DepartmentController departmentController = new DepartmentController();
            AdminController adminController = new AdminController(null, departmentController);

            new VentanaPrincipal(adminController, departmentController).setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AggBtnDepartamentos;
    private javax.swing.JButton AggBtnEmpleados;
    private javax.swing.JTextField BuscarDepartamentoText;
    private javax.swing.JTextField BuscarEmpleadoText;
    private javax.swing.JTabbedPane PanelPrincipal;
    private javax.swing.JButton SalirBtnDepartamentos;
    private javax.swing.JButton SalirBtnEmpleados;
    private javax.swing.JScrollPane ScrollListaDepartamento;
    private javax.swing.JScrollPane ScrollListaEmpleado;
    private javax.swing.JPanel TabDepartamento;
    private javax.swing.JPanel TabEmpleados;
    private javax.swing.JTable TablaDepartamentos;
    private javax.swing.JTable TablaEmpleados;
    // End of variables declaration//GEN-END:variables
}

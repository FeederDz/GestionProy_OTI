package Interfaz;

import Recursos.RenderTable;
import javax.swing.table.DefaultTableModel;
import Recursos.controlador;
import java.util.ArrayList;
import javax.swing.JButton;
import java.sql.ResultSet;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.DefaultFormatter;

/**
 *
 * @author JNUNEZF
 */
public class Principal extends javax.swing.JFrame {

    //Para el control de actividades 
    int minValue = 0;
    int maxValue = 3;
    int initialValue = 0;
    int step = 1;
    ArrayList<Integer> id_proyectos = new ArrayList<>();
    controlador control = new controlador();
    DefaultTableModel TablaControl_proyectos = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 0;
        }
    };

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        TablaControl_proyectos.setColumnIdentifiers(new String[]{"Prioridad" ,"Codigo Proyecto", "Nombre", "Sponsor", "Gestor", "Fase", "Fecha Inicio", "Fecha Fin", "Avance", "Actividades"});
        //AGREGAR CAMPO PRIORIDAD
        // CORTES AUTOMATICOS MENSUALES
        this.Tabla_Proyectos.setDefaultRenderer(Object.class, new RenderTable());
        Tabla_Proyectos.setModel(TablaControl_proyectos);
        control.llenarIds(id_proyectos);
        cargarTabla();
        System.out.println(id_proyectos);        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Proyectos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla_Proyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla_Proyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_ProyectosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Proyectos);

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Crear Proyecto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Detalle Etapas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(89, 89, 89)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void cargarTabla() {
        control.LimpiarJtable(TablaControl_proyectos);
        //ACA HACER PRUEBAS CON LA TABLA
        control.TablaSpinner(TablaControl_proyectos, "SELECT codigo_proyecto , nombre, sponsor, gestor, fase, fecha_ini, fecha_fin  FROM CARTERA_PROYECTOS "
                + "WHERE estado = 'EN PROCESO' order by CARTERA_PROYECTOS.id asc", 7);
    
        //ESTADO SUSPENDIDO/ PARALIZADO
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarTabla();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void Tabla_ProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_ProyectosMouseClicked
        int column = Tabla_Proyectos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / Tabla_Proyectos.getRowHeight();
        int codigo_proyecto;

        if (row < Tabla_Proyectos.getRowCount() && row >= 0 && column < Tabla_Proyectos.getColumnCount() && column >= 0) {
            Object value = Tabla_Proyectos.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                //Capturamos el ROW e invocamos las actividades con el id que se guardo en el arrayList
                //System.out.println("Tengo este row:" + row);
                codigo_proyecto = id_proyectos.get(row);
                //System.out.println("tengo este id:" + codigo_proyecto);
                invocarAct(codigo_proyecto);
            }
        }
    }//GEN-LAST:event_Tabla_ProyectosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CrearProyecto crearProy = new CrearProyecto();
        crearProy.setVisible(true);
        crearProy.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void invocarAct(int cod_proy) {
        Actividades act = new Actividades(cod_proy);
        act.setVisible(true);
        act.setLocationRelativeTo(null);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Proyectos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
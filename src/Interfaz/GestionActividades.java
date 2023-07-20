/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Recursos.Conexion;
import Recursos.RenderTable;
import Recursos.controlador;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JNUNEZF
 */
public class GestionActividades extends javax.swing.JFrame {

    int cont = 0;
    int cod_proyecto, filas;
    int filas_selecionada;
    ArrayList<Integer> id_actividades = new ArrayList<>();
    controlador control = new controlador();
    DefaultTableModel TablaControlActividades = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public GestionActividades(int cod) {
        this.cod_proyecto = cod;
        initComponents();
        TablaControlActividades.setColumnIdentifiers(new String[]{"Actividades"});
        TablaActividades.setModel(TablaControlActividades);
        Editable();
        llenarcamposFecha();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private GestionActividades() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TablaActividades = new javax.swing.JTable();
        jEliminarActBtn = new javax.swing.JButton();
        anio_txt = new javax.swing.JTextField();
        jModificarActBtn = new javax.swing.JButton();
        mes_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tipoact_cbox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        corte_txt = new javax.swing.JTextField();
        jAniadirBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jActividad_txt = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lista de Actividades"
            }
        ));
        TablaActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaActividadesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaActividades);

        jEliminarActBtn.setText("Eliminar Actividad");
        jEliminarActBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarActBtnActionPerformed(evt);
            }
        });

        jModificarActBtn.setText("Modificar Actividad");
        jModificarActBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificarActBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Mes");

        jLabel1.setText("Actividad");

        tipoact_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REALIZADA", "PROXIMA" }));
        tipoact_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoact_cboxActionPerformed(evt);
            }
        });

        jLabel2.setText("Corte");

        jAniadirBtn.setText("Añadir a la Lista");
        jAniadirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAniadirBtnActionPerformed(evt);
            }
        });

        jActividad_txt.setColumns(20);
        jActividad_txt.setRows(5);
        jScrollPane1.setViewportView(jActividad_txt);

        jLabel5.setText("Agregar Actividad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jAniadirBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tipoact_cbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(corte_txt))
                            .addGap(67, 67, 67)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(anio_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mes_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jModificarActBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jEliminarActBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(48, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tipoact_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mes_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jModificarActBtn))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(anio_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jEliminarActBtn)
                                .addComponent(corte_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jAniadirBtn)
                    .addGap(24, 24, 24)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(11, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void Editable() {
        jModificarActBtn.setEnabled(false);
        jEliminarActBtn.setEnabled(false);
        mes_txt.setEditable(false);
        anio_txt.setEditable(false);
        corte_txt.setEditable(false);
    }

    public void llenarcamposFecha() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MMMM", new Locale("es"));
        String nombreMes = fechaActual.format(formatoMes);
        String anio = String.valueOf(fechaActual.getYear());
        int dia = fechaActual.getDayOfMonth();
        if (dia >= 12 || dia < 28) {
            corte_txt.setText("PRIMERO");
        } else if (dia >= 28 || dia <= 7) {
            corte_txt.setText("SEGUNDO");
        }
        mes_txt.setText(nombreMes.toUpperCase());
        anio_txt.setText(anio);
    }
    private void TablaActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaActividadesMouseClicked
        CallableStatement sql;
        int row = evt.getY() / TablaActividades.getRowHeight();
        this.filas_selecionada = row;
        jModificarActBtn.setEnabled(true);
        jEliminarActBtn.setEnabled(true);        
    }//GEN-LAST:event_TablaActividadesMouseClicked

    private void tipoact_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoact_cboxActionPerformed
        Object selectedItem = tipoact_cbox.getSelectedItem();
        String tipo_act = selectedItem.toString();
        String mes = mes_txt.getText();
        String corte = corte_txt.getText();
        control.LlenarJtable(TablaControlActividades, "select actividad from actividades WHERE id_proy='" + cod_proyecto + "'AND mes='" + mes + "' AND tipo_act='" + tipo_act + "' AND corte='" + corte + "' order by id asc", 1);
        llenarIdAct();
    }//GEN-LAST:event_tipoact_cboxActionPerformed

    private void llenarIdAct() {
        id_actividades.clear();
        Object selectedItem = tipoact_cbox.getSelectedItem();
        String tipo_act = selectedItem.toString();
        String mes = mes_txt.getText();
        String corte = corte_txt.getText();
        control.llenarIdsActividades(id_actividades, cod_proyecto, mes, tipo_act, corte);
        System.out.println(id_actividades);
    }


    private void jAniadirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAniadirBtnActionPerformed
        CallableStatement sql;
        String actividad = jActividad_txt.getText().trim();
        if (!actividad.isEmpty()) {
            TablaControlActividades.addRow(new Object[]{actividad});
            //filas++;
            try {
                LocalDate fechaActual = LocalDate.now();
                Object selectedItem = tipoact_cbox.getSelectedItem();
                String tipo_act = selectedItem.toString();
                String mes = mes_txt.getText();
                String corte = corte_txt.getText();
                String anio = String.valueOf(fechaActual.getYear());
                sql = Conexion.getConexion().prepareCall("{CALL sp_crearactividad(?,?,?,?,?,?)}");
                sql.setInt(1,cod_proyecto);
                sql.setString(2, actividad);
                sql.setString(3, tipo_act);
                sql.setString(4,corte );
                sql.setString(5,mes );
                sql.setString(6,anio );
                sql.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CrearProyecto.class.getName()).log(Level.SEVERE, null, ex);}     
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una actividad");
        }
        jActividad_txt.setText("");
        control.exportTableToCSV("actividades", "Select * from actividades", "D:/BD OTI GESTION/actividades.csv");
        llenarIdAct();
    }//GEN-LAST:event_jAniadirBtnActionPerformed

    private void jEliminarActBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarActBtnActionPerformed
        CallableStatement sql;
        int selectedRow = TablaActividades.getSelectedRow();
        TablaControlActividades.removeRow(selectedRow);
        try {
            sql = Conexion.getConexion().prepareCall("{CALL sp_eliminar_actividad(?)}");
            sql.setInt(1, id_actividades.get(filas_selecionada));
            sql.executeUpdate();
            System.out.println(selectedRow);
            System.out.println(id_actividades.get(selectedRow));
        } catch (Exception e) {TablaActividades.repaint(); }
        control.exportTableToCSV("actividades", "Select * from actividades", "D:/BD OTI GESTION/actividades.csv");
        llenarIdAct();
    }//GEN-LAST:event_jEliminarActBtnActionPerformed

    private void jModificarActBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificarActBtnActionPerformed
        CallableStatement sql;
        int selectedRow = TablaActividades.getSelectedRow();
        TablaControlActividades.removeRow(selectedRow);
        jEliminarActBtn.setEnabled(false);        
        try{
            LocalDate fechaActual = LocalDate.now();               
            String anio = String.valueOf(fechaActual.getYear());
            Object selectedItem = tipoact_cbox.getSelectedItem();
            String tipo_act = selectedItem.toString();
            String mes = mes_txt.getText();
            String corte = corte_txt.getText();
            String act = control.DevolverRegistroBD("select actividad from actividades WHERE id_proy='" + cod_proyecto + "'AND mes='" + mes + "' AND tipo_act='" + tipo_act + "' AND corte='" + corte + "' order by id asc", 1);
            System.out.println(cod_proyecto);
            System.out.println(selectedRow);
            System.out.println(id_actividades.get(selectedRow));
            jActividad_txt.setText(act);           
        }catch(Exception ex){}
    }//GEN-LAST:event_jModificarActBtnActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionActividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaActividades;
    private javax.swing.JTextField anio_txt;
    private javax.swing.JTextField corte_txt;
    private javax.swing.JTextArea jActividad_txt;
    private javax.swing.JButton jAniadirBtn;
    private javax.swing.JButton jEliminarActBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jModificarActBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mes_txt;
    private javax.swing.JComboBox<String> tipoact_cbox;
    // End of variables declaration//GEN-END:variables
}

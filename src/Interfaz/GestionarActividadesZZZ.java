/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Recursos.Conexion;
import Recursos.controlador;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
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
 * @author ECANALES
 */
public class GestionarActividadesZZZ extends javax.swing.JFrame {

    
    int cod_proyecto;
    int filas = 0;
    controlador control = new controlador();
    
    public GestionarActividadesZZZ(int cod) {

        controlador control = new controlador();
        this.cod_proyecto = cod;
        initComponents();
        llenarcamposFecha();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        mes_txt.setEditable(false);
        anio_txt.setEditable(false);
        corte_txt.setEditable(false);
        Object selectedItem = tipoact_cbox.getSelectedItem();
        String tipo_act = selectedItem.toString();
        String mes = mes_txt.getText();
        String corte = corte_txt.getText();
        System.out.println(cod_proyecto);
        jModificarActBtn.setEnabled(false);


    }
    
    private GestionarActividadesZZZ() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void llenarcamposFecha() {
        LocalDate fechaActual = LocalDate.now();
        //Object selectedItem = tipoact_cbox.getSelectedItem(); 
        //String tipo_act = selectedItem.toString();
        DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MMMM", new Locale("es"));
        String nombreMes = fechaActual.format(formatoMes);
        String anio = String.valueOf(fechaActual.getYear());
        //DefaultTableModel tablaactividad = (DefaultTableModel) jTable1.getModel();
        int dia = fechaActual.getDayOfMonth();
        if (dia >= 12 || dia < 28) {
            corte_txt.setText("PRIMERO");
        } else if (dia >= 28 || dia <= 7) {
            corte_txt.setText("SEGUNDO");
        }
        mes_txt.setText(nombreMes.toUpperCase());
        anio_txt.setText(anio);
        //String mes = mes_txt.getText();
        //String corte = corte_txt.getText();
        //control.LlenarJtable(tablaactividad, "select actividad from actividades WHERE id_proy='"+cod_proyecto+"'AND mes='"+mes+"' AND tipo_act='"+tipo_act+"' AND corte='"+corte+"'", 1);

        System.out.println(fechaActual);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jActividad_txt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaActividades = new javax.swing.JTable();
        tipoact_cbox = new javax.swing.JComboBox<>();
        anio_txt = new javax.swing.JTextField();
        mes_txt = new javax.swing.JTextField();
        jAniadirBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jModificarActBtn = new javax.swing.JButton();
        jEliminarActBtn = new javax.swing.JButton();
        corte_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jActividad_txt.setColumns(20);
        jActividad_txt.setRows(5);
        jScrollPane1.setViewportView(jActividad_txt);

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

        tipoact_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REALIZADA", "PROXIMA" }));
        tipoact_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoact_cboxActionPerformed(evt);
            }
        });

        jAniadirBtn.setText("Añadir a la Lista");
        jAniadirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAniadirBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Actividad");

        jLabel2.setText("Corte");

        jLabel3.setText("Año");

        jLabel4.setText("Mes");

        jLabel5.setText("Agregar Actividad");

        jModificarActBtn.setText("Modificar Actividad");
        jModificarActBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificarActBtnActionPerformed(evt);
            }
        });

        jEliminarActBtn.setText("Eliminar Actividad");
        jEliminarActBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarActBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jAniadirBtn)
                        .addContainerGap(631, Short.MAX_VALUE))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(anio_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mes_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jModificarActBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jEliminarActBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
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
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void jAniadirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAniadirBtnActionPerformed
        
        String actividad = jActividad_txt.getText().trim();
        DefaultTableModel tablaactividad = (DefaultTableModel) TablaActividades.getModel();
        
        if (!actividad.isEmpty()) {
            tablaactividad.insertRow(filas, new Object[]{actividad});
            tablaactividad.setColumnIdentifiers(new String[]{"Actividad"});
            filas++;
        }else {
            JOptionPane.showMessageDialog(null, "Ingrese una actividad");
        }
        jActividad_txt.setText("");
    }//GEN-LAST:event_jAniadirBtnActionPerformed

    private void tipoact_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoact_cboxActionPerformed
        Object selectedItem = tipoact_cbox.getSelectedItem();
        String tipo_act = selectedItem.toString();
        DefaultTableModel tablaactividad = (DefaultTableModel) TablaActividades.getModel();
        String mes = mes_txt.getText();
        String corte = corte_txt.getText();
        System.out.println(mes);
        System.out.println(corte);
        System.out.println(tipo_act);
        control.LlenarJtable(tablaactividad, "select actividad from actividades WHERE id_proy='" + cod_proyecto + "'AND mes='" + mes + "' AND tipo_act='" + tipo_act + "' AND corte='" + corte + "' order by id asc", 1);


    }//GEN-LAST:event_tipoact_cboxActionPerformed

    private void jEliminarActBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarActBtnActionPerformed
        CallableStatement sql;
        DefaultTableModel tablaactividad = (DefaultTableModel) TablaActividades.getModel();
        int selectedRow = TablaActividades.getSelectedRow();
        ArrayList<Integer> id_actividades = new ArrayList<>();
        Object selectedItem = tipoact_cbox.getSelectedItem();
        String tipo_act = selectedItem.toString();
        String mes = mes_txt.getText();
        String corte = corte_txt.getText();
        control.llenarIdsActividades(id_actividades, cod_proyecto, mes, tipo_act, corte);
        
        if (selectedRow != -1) {
            tablaactividad.removeRow(selectedRow);
            try {
                    sql = Conexion.getConexion().prepareCall("{CALL eliminar_actividad(?)}");
                    sql.setInt(1, id_actividades.get(selectedRow));
                    sql.executeUpdate();
                } catch (Exception e) {
                }
            TablaActividades.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una actividad de la lista para eliminarla.");
        }
        
    }//GEN-LAST:event_jEliminarActBtnActionPerformed

    private void TablaActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaActividadesMouseClicked
        int column = TablaActividades.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TablaActividades.getRowHeight();
        int codigo_proyecto;
        /*System.out.println("Fila: " + row);
        System.out.println("Fila capturada: " + fila_proy);
        System.out.println("Identificador proyecto: " + id_proyectos.get(row));*/
        if (row < TablaActividades.getRowCount() && row >= 0 && column < TablaActividades.getColumnCount() && column >= 0) {
            jModificarActBtn.setEnabled(true);
            jAniadirBtn.setEnabled(false);
        }
    }//GEN-LAST:event_TablaActividadesMouseClicked

    private void jModificarActBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificarActBtnActionPerformed
        
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
            java.util.logging.Logger.getLogger(GestionarActividadesZZZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarActividadesZZZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarActividadesZZZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarActividadesZZZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarActividadesZZZ().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jModificarActBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mes_txt;
    private javax.swing.JComboBox<String> tipoact_cbox;
    // End of variables declaration//GEN-END:variables
}

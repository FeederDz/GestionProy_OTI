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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ECANALES
 */
public class ModificarActividades extends javax.swing.JFrame {

    int filas = 0;
    int cod_proyecto;
    controlador control= new controlador();

    public ModificarActividades(int cod) {

        controlador control = new controlador();
        this.cod_proyecto = cod;
        initComponents();
        llenarcamposAct();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        corte_txt.setEditable(false);
        mes_txt.setEditable(false);
        anio_txt.setEditable(false);
        System.out.println(cod_proyecto);

    }

    private ModificarActividades() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void llenarcamposAct() {
        LocalDate fechaActual = LocalDate.now();
        Object selectedItem = tipoact_cbox.getSelectedItem(); 
        String tipo_act = selectedItem.toString();
        DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MMMM", new Locale("es"));
        String nombreMes = fechaActual.format(formatoMes);
        String anio = String.valueOf(fechaActual.getYear());
        DefaultTableModel tablaactividad = (DefaultTableModel) jTable1.getModel();
        int dia = fechaActual.getDayOfMonth();
        if (dia <= 15) {
            corte_txt.setText("PRIMERO");
        } else {
            corte_txt.setText("SEGUNDO");
        }
        mes_txt.setText(nombreMes.toUpperCase());
        anio_txt.setText(anio);
        String mes = mes_txt.getText();
        String corte = corte_txt.getText();
        control.LlenarJtable(tablaactividad, "select actividad from actividades WHERE id_proy='"+cod_proyecto+"'AND mes='"+mes+"' AND tipo_act='"+tipo_act+"' AND corte='"+corte+"'", 1);

        System.out.println(fechaActual);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jActividad_txt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tipoact_cbox = new javax.swing.JComboBox<>();
        corte_txt = new javax.swing.JTextField();
        anio_txt = new javax.swing.JTextField();
        mes_txt = new javax.swing.JTextField();
        jAniadirBtn = new javax.swing.JButton();
        jGuardarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jActividad_txt.setColumns(20);
        jActividad_txt.setRows(5);
        jScrollPane1.setViewportView(jActividad_txt);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lista de Actividades"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        tipoact_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REALIZADA", "PROXIMA" }));
        tipoact_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoact_cboxActionPerformed(evt);
            }
        });

        corte_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corte_txtActionPerformed(evt);
            }
        });

        jAniadirBtn.setText("Añadir a la Lista");
        jAniadirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAniadirBtnActionPerformed(evt);
            }
        });

        jGuardarBtn.setText("Guardar Actividades");
        jGuardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Actividad");

        jLabel2.setText("Corte");

        jLabel3.setText("Año");

        jLabel4.setText("Mes");

        jLabel5.setText("Agregar Actividad");

        jButton1.setText("Modificar Actividad");

        jButton2.setText("Eliminar Actividad");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipoact_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(corte_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
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
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jGuardarBtn)
                .addGap(336, 336, 336))
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
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(corte_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anio_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAniadirBtn)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jGuardarBtn)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void corte_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corte_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_corte_txtActionPerformed

    private void jGuardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarBtnActionPerformed
        CallableStatement sql;

        String agreact;
        DefaultTableModel tablaactividad = (DefaultTableModel) jTable1.getModel();
        int fila = tablaactividad.getRowCount();
        String[] actividades = new String[fila];
        for (int i = 0; i < fila; i++) {
            actividades[i] = tablaactividad.getValueAt(i, 0).toString();
        }
        String corte = corte_txt.getText();
        String mes = mes_txt.getText();
        String anio = anio_txt.getText();
        int contador = 0;
        
        if (tablaactividad.getRowCount()!=0) {
            for (int i = 0; i < actividades.length; i++) {
                try {
                    sql = Conexion.getConexion().prepareCall("{CALL sp_crearactividad(?,?,?,?,?,?)}");
                    sql.setInt(1, cod_proyecto);
                    sql.setString(2, actividades[i]);
                    sql.setString(3, tipoact_cbox.getSelectedItem().toString());
                    sql.setString(4, corte_txt.getText());
                    sql.setString(5, mes_txt.getText());
                    sql.setString(6, anio_txt.getText());
                    sql.executeUpdate();
                    contador++;
                } catch (Exception e) {
                }
                if (contador == actividades.length) {
                    JOptionPane.showMessageDialog(null, "Actividades Agregadas con Éxito.");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese actividades a la Lista");
        }

    }//GEN-LAST:event_jGuardarBtnActionPerformed

    private void jAniadirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAniadirBtnActionPerformed
        String actividad = jActividad_txt.getText().trim();
        DefaultTableModel tablaactividad = (DefaultTableModel) jTable1.getModel();
        if (!actividad.isEmpty()) {
            tablaactividad.insertRow(filas, new Object[]{actividad});
            tablaactividad.setColumnIdentifiers(new String[]{"Actividad"});
            filas++;
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una actividad");
        }
        jActividad_txt.setText("");
    }//GEN-LAST:event_jAniadirBtnActionPerformed

    private void tipoact_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoact_cboxActionPerformed
        LocalDate fechaActual = LocalDate.now();
        Object selectedItem = tipoact_cbox.getSelectedItem(); 
        String tipo_act = selectedItem.toString();
        DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MMMM", new Locale("es"));
        String nombreMes = fechaActual.format(formatoMes);
        String anio = String.valueOf(fechaActual.getYear());
        DefaultTableModel tablaactividad = (DefaultTableModel) jTable1.getModel();
        int dia = fechaActual.getDayOfMonth();
        if (dia <= 15) {
            corte_txt.setText("PRIMERO");
        } else {
            corte_txt.setText("SEGUNDO");
        }
        mes_txt.setText(nombreMes.toUpperCase());
        anio_txt.setText(anio);
        String mes = mes_txt.getText();
        String corte = corte_txt.getText();
        control.LlenarJtable(tablaactividad, "select actividad from actividades WHERE id_proy='"+cod_proyecto+"'AND mes='"+mes+"' AND tipo_act='"+tipo_act+"' AND corte='"+corte+"'", 1); 
    }//GEN-LAST:event_tipoact_cboxActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarActividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anio_txt;
    private javax.swing.JTextField corte_txt;
    private javax.swing.JTextArea jActividad_txt;
    private javax.swing.JButton jAniadirBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jGuardarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mes_txt;
    private javax.swing.JComboBox<String> tipoact_cbox;
    // End of variables declaration//GEN-END:variables
}

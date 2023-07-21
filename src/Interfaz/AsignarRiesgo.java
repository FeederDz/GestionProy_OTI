package Interfaz;

import Recursos.Conexion;
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
public class AsignarRiesgo extends javax.swing.JFrame {

    int cont = 0;
    int cod_proyecto, filas;
    int filas_selecionada;
    ArrayList<Integer> id_riesgos = new ArrayList<>();
    controlador control = new controlador();
    DefaultTableModel TablaControlRiesgos = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public AsignarRiesgo(int cod) {
        this.cod_proyecto = cod;
        initComponents();
        llenarcamposFecha();
        Editable();
        TablaControlRiesgos.setColumnIdentifiers(new String[]{"Riesgos"});
        TablaRiesgos.setModel(TablaControlRiesgos);
        llenarTablaRiesgos();
        llenarIdRiesgos();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void llenarTablaRiesgos() {
        LocalDate fechaActual = LocalDate.now();
        String anio = String.valueOf(fechaActual.getYear());
        String mes = mes_txt.getText();
        String corte = corte_txt.getText();
        control.LlenarJtable(TablaControlRiesgos, "select Riesgo from riesgos where id_proy = '" + cod_proyecto + "' and corte = '" + corte + "' and mes = '" + mes + "' and año = '" + anio + "' order by id asc ", 1);
    }

    private AsignarRiesgo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void Editable() {
        jEliminarRiesgBtn.setEnabled(false);
        mes_txt.setEditable(false);
        anio_txt.setEditable(false);
        corte_txt.setEditable(false);
    }

    private void llenarIdRiesgos() {
        id_riesgos.clear();
        String mes = mes_txt.getText();
        String corte = corte_txt.getText();
        control.llenarIdsRiesgos(id_riesgos, cod_proyecto, mes, corte);
    }

    private void llenarcamposFecha() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jRiesgo_txt = new javax.swing.JTextArea();
        jAniadirRiesgoBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaRiesgos = new javax.swing.JTable();
        corte_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mes_txt = new javax.swing.JTextField();
        anio_txt = new javax.swing.JTextField();
        jEliminarRiesgBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Descripcion del Riesgo");

        jRiesgo_txt.setColumns(20);
        jRiesgo_txt.setRows(5);
        jScrollPane1.setViewportView(jRiesgo_txt);

        jAniadirRiesgoBtn.setText("Añadir a la Lista");
        jAniadirRiesgoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAniadirRiesgoBtnActionPerformed(evt);
            }
        });

        TablaRiesgos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lista de Riesgos"
            }
        ));
        TablaRiesgos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaRiesgosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaRiesgos);

        jLabel2.setText("Corte");

        jLabel4.setText("Mes");

        jEliminarRiesgBtn.setText("Eliminar Riesgo");
        jEliminarRiesgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarRiesgBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Año");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(corte_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(anio_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mes_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jEliminarRiesgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(139, 139, 139))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAniadirRiesgoBtn))
                        .addGap(0, 0, 0))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(corte_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mes_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anio_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jEliminarRiesgBtn)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jAniadirRiesgoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAniadirRiesgoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAniadirRiesgoBtnActionPerformed
        CallableStatement sql;
        String riesgo = jRiesgo_txt.getText().trim();
        if (!riesgo.isEmpty()) {
            TablaControlRiesgos.addRow(new Object[]{riesgo});
            //filas++;
            try {
                LocalDate fechaActual = LocalDate.now();
                String mes = mes_txt.getText();
                String corte = corte_txt.getText();
                String anio = String.valueOf(fechaActual.getYear());
                sql = Conexion.getConexion().prepareCall("{CALL sp_crearriesgo(?,?,?,?,?)}");
                sql.setInt(1, cod_proyecto);
                sql.setString(2, riesgo);
                sql.setString(3, corte);
                sql.setString(4, mes);
                sql.setString(5, anio);
                sql.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CrearProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un riesgo");
        }
        jRiesgo_txt.setText("");
        llenarIdRiesgos();
        control.exportTableToCSV("riesgo", "Select * from riesgos", "D:/BD OTI GESTION/riesgos.csv");

    }//GEN-LAST:event_jAniadirRiesgoBtnActionPerformed

    private void TablaRiesgosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaRiesgosMouseClicked
        int row = evt.getY() / TablaRiesgos.getRowHeight();
        this.filas_selecionada = row;
        jEliminarRiesgBtn.setEnabled(true);    
    }//GEN-LAST:event_TablaRiesgosMouseClicked

    private void jEliminarRiesgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarRiesgBtnActionPerformed
        CallableStatement sql;
        int selectedRow = TablaRiesgos.getSelectedRow();
        TablaControlRiesgos.removeRow(selectedRow);
        try {
            sql = Conexion.getConexion().prepareCall("{CALL [sp_eliminar_riesgo](?)}");
            sql.setInt(1, id_riesgos.get(filas_selecionada));
            sql.executeUpdate();
            System.out.println(selectedRow);
            System.out.println(id_riesgos.get(selectedRow));
        } catch (Exception e) {
            TablaRiesgos.repaint();
        }
        control.exportTableToCSV("riesgo", "Select * from riesgos", "D:/BD OTI GESTION/riesgos.csv");
        llenarIdRiesgos();
    }//GEN-LAST:event_jEliminarRiesgBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AsignarRiesgo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarRiesgo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarRiesgo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarRiesgo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarRiesgo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaRiesgos;
    private javax.swing.JTextField anio_txt;
    private javax.swing.JTextField corte_txt;
    private javax.swing.JButton jAniadirRiesgoBtn;
    private javax.swing.JButton jEliminarRiesgBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextArea jRiesgo_txt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mes_txt;
    // End of variables declaration//GEN-END:variables
}

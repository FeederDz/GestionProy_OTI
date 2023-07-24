package Interfaz;

import javax.swing.table.DefaultTableModel;
import Recursos.controlador;
import javax.swing.WindowConstants;

/**
 *
 * @author JNUNEZF
 */
public class Actividades extends javax.swing.JFrame {

    controlador control = new controlador();
    int codigo_proy = 0;
    DefaultTableModel TablaControlRiesgos = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel TablaControl_act_proxima = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel TablaControl_act_realizada = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public Actividades(int cod) {
        initComponents();
        this.codigo_proy = cod;
        TablaControl_act_realizada.setColumnIdentifiers(new String[]{"Actividades Realizadas"});
        TablaControl_act_proxima.setColumnIdentifiers(new String[]{"Actividades Proximas"});
        TablaControlRiesgos.setColumnIdentifiers(new String[]{"Riesgos"});
        Act_realizadas.setModel(TablaControl_act_realizada);
        Act_proximas.setModel(TablaControl_act_proxima);
        tablaRiesgos.setModel(TablaControlRiesgos);
        //FechasCorte();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        

    }

    private Actividades() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        Act_realizadas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Act_proximas = new javax.swing.JTable();
        buscar_fecha = new javax.swing.JButton();
        tipocorte_cbox = new javax.swing.JComboBox<>();
        aniocbox = new javax.swing.JComboBox<>();
        mescbox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jAgregarActBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaRiesgos = new javax.swing.JTable();
        jAgregarRies = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Act_realizadas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Act_realizadas);

        Act_proximas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(Act_proximas);

        buscar_fecha.setText("Buscar");
        buscar_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_fechaActionPerformed(evt);
            }
        });

        tipocorte_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRIMERO", "SEGUNDO" }));
        tipocorte_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipocorte_cboxActionPerformed(evt);
            }
        });

        aniocbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026" }));

        mescbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));

        jLabel1.setText("Corte:");

        jLabel2.setText("Mes:");

        jLabel3.setText("Año:");

        jAgregarActBtn.setText("Administrar Actividades");
        jAgregarActBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarActBtnActionPerformed(evt);
            }
        });

        tablaRiesgos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tablaRiesgos);

        jAgregarRies.setText("Administrar Riesgos");
        jAgregarRies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarRiesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buscar_fecha)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipocorte_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mescbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aniocbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jAgregarActBtn)
                                .addGap(32, 32, 32)
                                .addComponent(jAgregarRies)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscar_fecha)
                            .addComponent(tipocorte_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aniocbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mescbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jAgregarActBtn)
                            .addComponent(jAgregarRies))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_fechaActionPerformed
        String corte = tipocorte_cbox.getSelectedItem().toString();
        String mes = mescbox.getSelectedItem().toString();
        String anio = aniocbox.getSelectedItem().toString();
        control.LimpiarJtable(TablaControl_act_realizada);
        control.LimpiarJtable(TablaControl_act_proxima);
        control.LimpiarJtable(TablaControlRiesgos);
        String consulta = "select actividad from actividades where tipo_act='REALIZADA' AND id_proy=" + codigo_proy + " AND corte='" + corte + "' AND mes='" + mes + "' AND año='" + anio + "'";
        String consulta2 = "select actividad from actividades where tipo_act='PROXIMA' AND id_proy=" + codigo_proy + " AND corte='" + corte + "' AND mes='" + mes + "' AND año='" + anio + "'";
        String consulta3 = "select Riesgo from riesgos where id_proy = '"+codigo_proy+"' and corte = '" +corte+"' and mes = '"+mes+"' and año = '"+anio+"' order by id asc ";
        control.LlenarJtable(TablaControl_act_realizada, consulta, 1);
        control.LlenarJtable(TablaControl_act_proxima, consulta2, 1);
        control.LlenarJtable(TablaControlRiesgos, consulta3, 1);
    }//GEN-LAST:event_buscar_fechaActionPerformed

    private void tipocorte_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipocorte_cboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipocorte_cboxActionPerformed

    private void jAgregarActBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarActBtnActionPerformed
        invocarCrearAct(codigo_proy);
    }//GEN-LAST:event_jAgregarActBtnActionPerformed

    private void jAgregarRiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarRiesActionPerformed
        AsignarRiesgo crearriesgo = new AsignarRiesgo(codigo_proy);
        crearriesgo.setVisible(true);
        crearriesgo.setLocationRelativeTo(null);
    }//GEN-LAST:event_jAgregarRiesActionPerformed

    private void invocarCrearAct(int cod_proy) {
        GestionActividades crearact = new GestionActividades(cod_proy);
        crearact.setVisible(true);
        crearact.setLocationRelativeTo(null);
        
    }

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
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Act_proximas;
    private javax.swing.JTable Act_realizadas;
    private javax.swing.JComboBox<String> aniocbox;
    private javax.swing.JButton buscar_fecha;
    private javax.swing.JButton jAgregarActBtn;
    private javax.swing.JButton jAgregarRies;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> mescbox;
    private javax.swing.JTable tablaRiesgos;
    private javax.swing.JComboBox<String> tipocorte_cbox;
    // End of variables declaration//GEN-END:variables
}

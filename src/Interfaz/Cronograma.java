
package Interfaz;

import Recursos.Conexion;
import Recursos.controlador;
import static java.lang.Integer.parseInt;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;

/**
 *
 * @author ECANALES
 */

public class Cronograma extends javax.swing.JFrame {

    controlador control = new controlador();
    ArrayList<Integer> id_proyectos = new ArrayList<>();

    public Cronograma() {
        initComponents();
        setLocationRelativeTo(null);
        llenarComboBox();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void llenarComboBox() {
        String consulta = "SELECT NOMBRE FROM CARTERA_PROYECTOS WHERE estado = 'EN PROCESO' order by cartera_proyectos.prioridad asc";
        jComboProyectos.removeAllItems();
        control.LlenarJcombobox(consulta, 1, jComboProyectos);
        control.llenarIds(id_proyectos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jTextField12 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboProyectos = new javax.swing.JComboBox<>();
        jActIniCrBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        JBarraInicio = new javax.swing.JProgressBar();
        JBarraPlanificación = new javax.swing.JProgressBar();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        JBarraEjecucion = new javax.swing.JProgressBar();
        JBarraSeguimiento = new javax.swing.JProgressBar();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        JBarraCierre = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        real_ini = new javax.swing.JTextField();
        real_plan = new javax.swing.JTextField();
        real_eje = new javax.swing.JTextField();
        real_cierre = new javax.swing.JTextField();
        real_segui = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel10.setText("PROYECTO:");

        jComboProyectos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboProyectosActionPerformed(evt);
            }
        });

        jActIniCrBtn.setText("Actualizar");
        jActIniCrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActIniCrBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Porcentaje Real");

        jLabel8.setText("Fecha de Fin");

        jLabel7.setText("Fecha de Inicio");

        jLabel1.setText("ETAPA");

        jLabel2.setText("INICIO");

        jLabel3.setText("PLANIFICACION");

        jLabel4.setText("EJECUCION");

        jLabel5.setText("SEGUIMIENTO");

        jLabel6.setText("CIERRE");

        jLabel11.setText("Porcentaje");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jComboProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(59, 59, 59)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1)
                                .addComponent(jTextField3)
                                .addComponent(jTextField5)
                                .addComponent(jTextField7)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel8))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2)
                                .addComponent(jTextField4)
                                .addComponent(jTextField6)
                                .addComponent(jTextField8)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBarraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jActIniCrBtn)
                                            .addComponent(real_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBarraPlanificación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(real_plan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBarraEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(real_eje, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBarraSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(real_segui, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBarraCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(real_cierre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(14, 14, 14)))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jComboProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jActIniCrBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JBarraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(real_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(real_plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(JBarraPlanificación, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(real_eje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(JBarraEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBarraSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBarraCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(real_segui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(real_cierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboProyectosActionPerformed

        try {

            int filaseleccionada = jComboProyectos.getSelectedIndex();
            int cod_proyecto = 0;
            cod_proyecto = id_proyectos.get(filaseleccionada);
            String[] fechas = new String[10];

            fechas[0] = control.DevolverRegistroBD("Select fecha_ini from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'INICIO'", 1);
            fechas[1] = control.DevolverRegistroBD("Select fecha_fin from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'INICIO'", 1);
            fechas[2] = control.DevolverRegistroBD("Select fecha_ini from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'PLANIFICACION'", 1);
            fechas[3] = control.DevolverRegistroBD("Select fecha_fin from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'PLANIFICACION'", 1);
            fechas[4] = control.DevolverRegistroBD("Select fecha_ini from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'EJECUCION'", 1);
            fechas[5] = control.DevolverRegistroBD("Select fecha_fin from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'EJECUCION'", 1);
            fechas[6] = control.DevolverRegistroBD("Select fecha_ini from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'SEGUIMIENTO'", 1);
            fechas[7] = control.DevolverRegistroBD("Select fecha_fin from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'SEGUIMIENTO'", 1);
            fechas[8] = control.DevolverRegistroBD("Select fecha_ini from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'CIERRE'", 1);
            fechas[9] = control.DevolverRegistroBD("Select fecha_fin from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'CIERRE'", 1);
            
            jTextField1.setText(fechas[0]);
            jTextField2.setText(fechas[1]);
            jTextField3.setText(fechas[2]);
            jTextField4.setText(fechas[3]);
            jTextField5.setText(fechas[4]);
            jTextField6.setText(fechas[5]);
            jTextField7.setText(fechas[6]);
            jTextField8.setText(fechas[7]);
            jTextField9.setText(fechas[8]);
            jTextField10.setText(fechas[9]);
            llenarBarra();
            
            real_ini.setText(control.DevolverRegistroBD("Select porcentaje_real from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'INICIO'", 1));
            real_plan.setText(control.DevolverRegistroBD("Select porcentaje_real from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'PLANIFICACION'", 1));
            real_eje.setText(control.DevolverRegistroBD("Select porcentaje_real from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'EJECUCION'", 1));
            real_segui.setText(control.DevolverRegistroBD("Select porcentaje_real from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'SEGUIMIENTO'", 1));
            real_cierre.setText(control.DevolverRegistroBD("Select porcentaje_real from porcxetapa where porcxetapa.id = '" + cod_proyecto + "' and etapa = 'CIERRE'", 1));
                                        
            

        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboProyectosActionPerformed

    private void llenarBarra() {
        JBarraInicio.setValue(0);
        JBarraInicio.setStringPainted(true);

        JBarraPlanificación.setValue(0);
        JBarraPlanificación.setStringPainted(true);

        JBarraEjecucion.setValue(0);
        JBarraEjecucion.setStringPainted(true);

        JBarraSeguimiento.setValue(0);
        JBarraSeguimiento.setStringPainted(true);

        JBarraCierre.setValue(0);
        JBarraCierre.setStringPainted(true);
        //System.out.println("Iniciobarra");
        CallableStatement sql = null;
        int filaseleccionada = jComboProyectos.getSelectedIndex();
        int cod_proyecto = 0;
        try {
            cod_proyecto = id_proyectos.get(filaseleccionada);

            int avanINI = control.avanceporc(jTextField1.getText(), jTextField2.getText());
            int avanPLANI = control.avanceporc(jTextField3.getText(), jTextField4.getText());
            System.out.println( "PLANIFICACION PORCENTAJE: " +  avanPLANI + " calculado");
            int avanEJEC = control.avanceporc(jTextField5.getText(), jTextField6.getText());
            int avanSEGUI = control.avanceporc(jTextField7.getText(), jTextField8.getText());
            int avanCIER = control.avanceporc(jTextField9.getText(), jTextField10.getText());

            try {
                sql = Conexion.getConexion().prepareCall("{CALL sp_modificar_avance(?,?,?)}");
                sql.setInt(1, cod_proyecto);
                sql.setString(2, "INICIO");
                sql.setInt(3, avanINI);
                sql.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                    if (sql != null) {
                        try {
                            sql.close();
                        }catch (SQLException e) {} 
                    } 
            } 
            try {
                sql = Conexion.getConexion().prepareCall("{CALL sp_modificar_avance(?,?,?)}");
                sql.setInt(1, cod_proyecto);
                sql.setString(2, "PLANIFICACION");
                sql.setInt(3, avanPLANI);
                sql.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sql = Conexion.getConexion().prepareCall("{CALL sp_modificar_avance(?,?,?)}");
                sql.setInt(1, cod_proyecto);
                sql.setString(2, "EJECUCION");
                sql.setInt(3, avanEJEC);
                sql.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sql = Conexion.getConexion().prepareCall("{CALL sp_modificar_avance(?,?,?)}");
                sql.setInt(1, cod_proyecto);
                sql.setString(2, "SEGUIMIENTO");
                sql.setInt(3, avanSEGUI);
                sql.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sql = Conexion.getConexion().prepareCall("{CALL sp_modificar_avance(?,?,?)}");
                sql.setInt(1, cod_proyecto);
                sql.setString(2, "CIERRE");
                sql.setInt(3, avanCIER);
                sql.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);
            } 

            JBarraInicio.setValue(avanINI);
            JBarraInicio.setStringPainted(true);

            JBarraPlanificación.setValue(avanPLANI);
            JBarraPlanificación.setStringPainted(true);
            System.out.println( "PLANIFICACION PORCENTAJE: " +  avanPLANI + " impreso");
            JBarraEjecucion.setValue(avanEJEC);
            JBarraEjecucion.setStringPainted(true);

            JBarraSeguimiento.setValue(avanSEGUI);
            JBarraSeguimiento.setStringPainted(true);

            JBarraCierre.setValue(avanCIER);
            JBarraCierre.setStringPainted(true);

        } catch (Exception e) {

        }
    }
    private void jActIniCrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActIniCrBtnActionPerformed
        CallableStatement sql = null;
        int filaseleccionada = jComboProyectos.getSelectedIndex();
        int cod_proyecto = 0,ini_real;
        if (filaseleccionada != -1) {
            cod_proyecto = id_proyectos.get(filaseleccionada);
        } 
        try {
            sql = Conexion.getConexion().prepareCall("{CALL sp_modificar_fechaxetapa(?,?,?,?,?)}");
            sql.setInt(1, cod_proyecto);
            sql.setString(2, "INICIO");
            sql.setString(3, jTextField1.getText());
            sql.setString(4, jTextField2.getText());
            sql.setInt(5, Integer.parseInt(real_ini.getText()));
            sql.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            sql = Conexion.getConexion().prepareCall("{CALL sp_modificar_fechaxetapa(?,?,?,?,?)}");
            sql.setInt(1, cod_proyecto);
            sql.setString(2, "PLANIFICACION");
            sql.setString(3, jTextField3.getText());
            sql.setString(4, jTextField4.getText());
            sql.setInt(5, Integer.parseInt(real_plan.getText()));
            sql.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            sql = Conexion.getConexion().prepareCall("{CALL sp_modificar_fechaxetapa(?,?,?,?,?)}");
            sql.setInt(1, cod_proyecto);
            sql.setString(2, "EJECUCION");
            sql.setString(3, jTextField5.getText());
            sql.setString(4, jTextField6.getText());
            sql.setInt(5, Integer.parseInt(real_eje.getText()));
            sql.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            sql = Conexion.getConexion().prepareCall("{CALL sp_modificar_fechaxetapa(?,?,?,?,?)}");
            sql.setInt(1, cod_proyecto);
            sql.setString(2, "SEGUIMIENTO");
            sql.setString(3, jTextField7.getText());
            sql.setString(4, jTextField8.getText());
            sql.setInt(5, Integer.parseInt(real_segui.getText()));
            sql.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);
        } 

        try {
            sql = Conexion.getConexion().prepareCall("{CALL sp_modificar_fechaxetapa(?,?,?,?,?)}");
            sql.setInt(1, cod_proyecto);
            sql.setString(2, "CIERRE");
            sql.setString(3, jTextField9.getText());
            sql.setString(4, jTextField10.getText());
            sql.setInt(5, Integer.parseInt(real_cierre.getText()));
            sql.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Ejecutaron los procedimientos");
        llenarBarra();
        System.out.println("cargo tabla");
        control.exportTableToCSV("porcxetapa", "Select * from porcxetapa", "D:/BD OTI GESTION/porcxetapa.csv");

    }//GEN-LAST:event_jActIniCrBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Cronograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cronograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cronograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cronograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cronograma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar JBarraCierre;
    private javax.swing.JProgressBar JBarraEjecucion;
    private javax.swing.JProgressBar JBarraInicio;
    private javax.swing.JProgressBar JBarraPlanificación;
    private javax.swing.JProgressBar JBarraSeguimiento;
    private javax.swing.JButton jActIniCrBtn;
    private javax.swing.JComboBox<String> jComboProyectos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField real_cierre;
    private javax.swing.JTextField real_eje;
    private javax.swing.JTextField real_ini;
    private javax.swing.JTextField real_plan;
    private javax.swing.JTextField real_segui;
    // End of variables declaration//GEN-END:variables
}
// PROBAR ESTO LUEGO  --->
// Arreglo para almacenar las consultas
/*String[] etapas = {"INICIO", "PLANIFICACION", "EJECUCION", "SEGUIMIENTO", "CIERRE"};
        String[] consultas = new String[etapas.length * 2]; // Arreglo para almacenar las consultas
        String[] resultados = new String[etapas.length * 2]; // Arreglo para almacenar los resultados

// Construir las consultas
        for (int i = 0; i < etapas.length; i++) {
            consultas[i * 2] = "SELECT fecha_ini FROM porcxetapa WHERE porcxetapa.id = '" + cod_proyecto + "' AND etapa = '" + etapas[i] + "'";
            consultas[i * 2 + 1] = "SELECT fecha_fin FROM porcxetapa WHERE porcxetapa.id = '" + cod_proyecto + "' AND etapa = '" + etapas[i] + "'";
        }

        // Crear un arreglo de los nombres de los textfields
        String[] textfields = {"textfield1", "textfield2", "textfield3", "textfield4", "textfield5", "textfield6", "textfield7", "textfield8", "textfield9", "textfield10"};

// Iterar sobre el arreglo de textfields y realizar las consultas
        for (int i = 0; i < textfields.length; i++) {
            // Construir la consulta SQL
            String consulta = "SELECT fecha_ini FROM porcxetapa WHERE porcxetapa.id = '" + cod_proyecto + "' AND etapa = '" + etapas[i] + "'";

            // Ejecutar la consulta y obtener el resultado
            String resultado = control.DevolverRegistroBD(consulta, 1);

            // Asignar el resultado al textfield correspondiente
            textfields[i].setText(resultado);
        }*/

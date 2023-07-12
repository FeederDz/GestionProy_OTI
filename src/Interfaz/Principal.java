package Interfaz;

import Recursos.Conexion;
import Recursos.RenderTable;
import javax.swing.table.DefaultTableModel;
import Recursos.controlador;
import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.swing.JButton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    int fila_proy;
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
        // CORTES AUTOMATICOS MENSUALES POR QUINCENAS
        // ACTUALIZAR ETAPA DEL PROYECTO GENERAL
        //COLOCAR MENSAJE AL CREAR 
        // LIMITE DEL SPINER LA CANTIDAD DE PROYECTOS
        this.Tabla_Proyectos.setDefaultRenderer(Object.class, new RenderTable());
        Tabla_Proyectos.setModel(TablaControl_proyectos);
        control.llenarIds(id_proyectos);
        System.out.println(id_proyectos);
        cargarTabla();
        JModificarBtn.setEnabled(false); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Proyectos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JModificarBtn = new javax.swing.JButton();

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

        JModificarBtn.setText("Modificar Proyecto");
        JModificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(36, 36, 36)
                        .addComponent(JModificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(JModificarBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void cargarTabla() {
        control.LimpiarJtable(TablaControl_proyectos);
        //ACA HACER PRUEBAS CON LA TABLA
        actualizar_fechas();
        control.PruebaLlenarProgressBar(TablaControl_proyectos, "SELECT  prioridad, codigo_proyecto , nombre, sponsor, gestor, fase, fecha_ini, fecha_fin  FROM CARTERA_PROYECTOS "
                + "WHERE estado = 'EN PROCESO' order by cartera_proyectos.prioridad asc", 8);
        
        //ESTADO SUSPENDIDO/ PARALIZADO
    }
    
    private void actualizar_fechas(){
        CallableStatement sql;
        String f_ini, f_fin; 
        int avance = 0;
        for (int i= 0; i<id_proyectos.size();i++){
            System.out.println(id_proyectos.size());
            try{               
                f_ini = control.DevolverRegistroBD("Select fecha_ini from cartera_proyectos where cartera_proyectos.id = '"+ id_proyectos.get(i) + "'",1);
                f_fin = control.DevolverRegistroBD("Select fecha_fin from cartera_proyectos where cartera_proyectos.id = '"+ id_proyectos.get(i) + "'",1);
                avance = control.avanceporc(f_ini, f_fin);                
                sql = Conexion.getConexion().prepareCall("CALL asignar_avance(?,?)");
                sql.setInt(1, id_proyectos.get(i));
                sql.setInt(2,avance);
                sql.executeUpdate();}
            catch(Exception ex){
                Logger.getLogger(Cronograma.class.getName()).log(Level.SEVERE, null, ex);}            
        }     
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarTabla();
        id_proyectos.clear();
        control.llenarIds(id_proyectos);
        System.out.println("Carga de id iteracion 2" + id_proyectos);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Tabla_ProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_ProyectosMouseClicked
        int column = Tabla_Proyectos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / Tabla_Proyectos.getRowHeight();
        int codigo_proyecto;
        this.fila_proy=row;
        /*System.out.println("Fila: " + row);
        System.out.println("Fila capturada: " + fila_proy);
        System.out.println("Identificador proyecto: " + id_proyectos.get(row));*/
        if (row < Tabla_Proyectos.getRowCount() && row >= 0 && column < Tabla_Proyectos.getColumnCount() && column >= 0) {
            JModificarBtn.setEnabled(true);
            Object value = Tabla_Proyectos.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                //Capturamos el ROW e invocamos las actividades con el id que se guardo en el arrayList
                //System.out.println("Tengo este row:" + row);
                codigo_proyecto = id_proyectos.get(row);
                /*System.out.println("Fila es:" + row);
                System.out.println("Codigo es:" + codigo_proyecto);*/
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
        Cronograma cronograma = new Cronograma();
        cronograma.setVisible(true);
        cronograma.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JModificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarBtnActionPerformed
        CrearProyecto modifProy = new CrearProyecto();
        modifProy.setVisible(true);
        modifProy.setLocationRelativeTo(null);
        modifProy.LlenarDatosModif(id_proyectos.get(fila_proy));
        //System.out.println(id_proyectos.get(fila_proy));
    }//GEN-LAST:event_JModificarBtnActionPerformed

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
    private javax.swing.JButton JModificarBtn;
    private javax.swing.JTable Tabla_Proyectos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

package Recursos;

import com.opencsv.CSVWriter;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatter;

/**
 *
 * @author JNUNEZF
 */
public class controlador extends Conexion {

    public controlador() {
    }
    int r;

    public void llenarIds(ArrayList<Integer> id_proyectos) {
        String query = "SELECT CARTERA_PROYECTOS.id_proy FROM CARTERA_PROYECTOS WHERE estado = 'EN PROCESO' order by cartera_proyectos.prioridad asc";
        try {
            this.st = this.getConexion().createStatement();
            this.rs = this.st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id_proy");
                id_proyectos.add(id);
            }
        } catch (Exception e) {}
    }
    
    public void llenarIdsActividades(ArrayList<Integer> id_actividades, int cod_proy, String mes, String tipo_act, String corte){
        String query = "select id from actividades WHERE id_proy='" + cod_proy + "'AND mes='" + mes + "' AND tipo_act='" + tipo_act + "' AND corte='" + corte + "' order by id asc";
        try {
            this.st = this.getConexion().createStatement();
            this.rs = this.st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                id_actividades.add(id);
            }
        } catch (Exception e) {}
    }

    public ResultSet DevolverRegistro(String sql) {
        try {
            this.st = this.getConexion().createStatement();
            this.rs = this.st.executeQuery(sql);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());}      
        return this.rs;
    }

    public String DevolverRegistroBD(String sql, int pos) {
        String capturar = "";
        try {
            this.rs = DevolverRegistro(sql);
            while (this.rs.next()) {
                capturar = this.rs.getString(pos);
            }
        }catch (Exception e) {}      
        return capturar;
    }

    public String DevolverRegistroDto(String sq, int pos) {
        String rs = "";
        try {
            this.st = this.getConexion().createStatement();
            this.rs = this.st.executeQuery(sq);
            if (this.rs.next()) {
                rs = this.rs.getString(pos);
            }
        } catch (Exception e) {}      
        return rs;
    }

    public void LimpiarJtable(DefaultTableModel mdt) {
        while (mdt.getRowCount() > 0) {
            mdt.removeRow(0);
        }
    }

    public void LlenarJtable(DefaultTableModel mdt, String sql, int tamanio) {
        LimpiarJtable(mdt);
        String datos[] = new String[tamanio];
        try {
            this.rs = DevolverRegistro(sql);
            while (this.rs.next()) {
                for (int i = 0; i < tamanio; i++) {
                    datos[i] = this.rs.getString(i + 1);
                }
                mdt.addRow(datos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String DevolverRegistro1(String sql, int pos) {
        String capturar = "";
        try {
            this.st = this.getConexion().createStatement();
            this.rs = this.st.executeQuery(sql);
            while (this.rs.next()) {
                capturar = this.rs.getString(pos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());}
        return capturar;
    }

    public void LlenarJcombobox(String sql, int pos, JComboBox cbo) {
        try {
            this.rs = DevolverRegistro(sql);
            while (this.rs.next()) {
                cbo.addItem(this.rs.getString(pos));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LlenarJtableButton(DefaultTableModel mdt, String sql, int tamanio) {
        LimpiarJtable(mdt);

        Object[] datos = new Object[tamanio + 1]; 
        try {
            this.rs = DevolverRegistro(sql);
            while (this.rs.next()) {
                for (int i = 0; i < tamanio; i++) {
                    datos[i] = this.rs.getString(i + 1);
                }
                // MODIFICAR ESTA NOTA: ->>> datos[tamanio - 1] = new JProgressBar().setValue(10);
                datos[tamanio] = new JButton("Ver"); 
                mdt.addRow(datos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void PruebaLlenarProgressBar(DefaultTableModel mdt, String sql, int tamanio) {
        LimpiarJtable(mdt);
        ArrayList<Integer> avances_proy = new ArrayList<>();
        int k = 0;
        String query = "SELECT CARTERA_PROYECTOS.AVANCE FROM CARTERA_PROYECTOS WHERE estado = 'EN PROCESO' order by cartera_proyectos.prioridad asc";
        try {
            this.st = this.getConexion().createStatement();
            this.rs = this.st.executeQuery(query);
            while (rs.next()) {
                int avance = rs.getInt("AVANCE");
                avances_proy.add(avance);
            }
        } catch (Exception e) {e.printStackTrace();}

        Object[] datos = new Object[tamanio + 2];
        try {
            this.rs = DevolverRegistro(sql);
            while (this.rs.next()) {
                for (int i = 0; i < tamanio; i++) {
                    datos[i] = this.rs.getString(i + 1);
                }
                datos[tamanio + 1] = new JButton("Ver");
                JProgressBar progressBar = new JProgressBar(0, 100);
                progressBar.setValue(0);
                progressBar.setStringPainted(true);
                datos[tamanio] = progressBar;
                progressBar.setValue(50);
                mdt.addRow(datos);
                progressBar.setValue(avances_proy.get(k));
                k++;
            }
        } catch (Exception e) {e.printStackTrace();}
     
    }

    public void TablaSpinner(DefaultTableModel mdt, String sql, int tamanio) {
        LimpiarJtable(mdt);
        ArrayList<Integer> avances_proy = new ArrayList<>();
        int k = 0;
        String query = "SELECT CARTERA_PROYECTOS.AVANCE FROM CARTERA_PROYECTOS WHERE estado = 'EN PROCESO'";
        try {
            this.st = this.getConexion().createStatement();
            this.rs = this.st.executeQuery(query);
            while (rs.next()) {
                int avance = rs.getInt("AVANCE");
                avances_proy.add(avance);
            }
        } catch (Exception e) {e.printStackTrace();}

        Object[] datos = new Object[tamanio + 3];
        try {
            this.rs = DevolverRegistro(sql);
            while (this.rs.next()) {
                for (int i = 0; i < tamanio; i++) {
                    datos[i + 1] = this.rs.getString(i + 1);
                }
                SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 3, 1);
                JSpinner prioridad = new JSpinner(spinnerModel);
                JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) prioridad.getEditor();
                spinnerEditor.getTextField().setEditable(false);
                DefaultFormatter formatter = (DefaultFormatter) spinnerEditor.getTextField().getFormatter();
                formatter.setOverwriteMode(false);
                datos[0] = prioridad;
                datos[tamanio + 2] = new JButton("Ver");
                JProgressBar progressBar = new JProgressBar(0, 100);
                progressBar.setValue(0);
                progressBar.setStringPainted(true);
                datos[tamanio + 1] = progressBar;
                progressBar.setValue(50);
                mdt.addRow(datos);
                progressBar.setValue(avances_proy.get(k));
                k++;
            }
        } catch (Exception e) {e.printStackTrace();}

    }
    
    public int avanceporc(String fechai, String fechaf) {
        LocalDate fechaActual = LocalDate.now();
        float avancepor;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaFin = LocalDate.parse(fechaf, formatter);
        LocalDate fechaInicio = LocalDate.parse(fechai, formatter);

        long diasDiferencia = fechaFin.toEpochDay() - fechaInicio.toEpochDay();

        long diasTranscurridos = fechaActual.toEpochDay() - fechaInicio.toEpochDay();

        avancepor = (diasTranscurridos * 100) / diasDiferencia;
        if (avancepor > 100) {
            avancepor = 100;
        } else if (avancepor < 0) {
            avancepor = 0;
        }
        Integer avancePorcentaje = (int) avancepor;
        return avancePorcentaje;
    }
    
    public  void exportTableToCSV(String tableName,String query ,String filePath) {

         try {
            Statement st = this.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);
            FileWriter fileWriter = new FileWriter(filePath);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            int columnCount = rs.getMetaData().getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = rs.getMetaData().getColumnName(i + 1);
            }
            csvWriter.writeNext(columnNames);

            // Escribir los datos en las filas siguientes
            while (rs.next()) {
                String[] row = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getString(i + 1);
                }
                csvWriter.writeNext(row);
            }

            // Cerrar el archivo CSV y la conexión a la base de datos
            csvWriter.close();
            fileWriter.close();
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());} 
        }
    
}

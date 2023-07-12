/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author JNUNEZF
 */
public class RenderTable extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object objeto_renderizable, boolean isSelected, boolean hasFocus, int row, int column) {
        if(objeto_renderizable instanceof JButton){
            return (JButton)objeto_renderizable;
        }
        if(objeto_renderizable instanceof JProgressBar){
            return (JProgressBar)objeto_renderizable;
        }
        if(objeto_renderizable instanceof JSpinner){
            return (JSpinner)objeto_renderizable;
        }
        return super.getTableCellRendererComponent(table, objeto_renderizable, isSelected, hasFocus, row, column); 
    }
     
}

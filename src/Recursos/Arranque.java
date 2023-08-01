
package Recursos;

import Interfaz.Principal;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Arranque {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Principal principal = new Principal();
            principal.setSize(1200, 300);
            principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            principal.setVisible(true);
        });
        
        
    }
    
}

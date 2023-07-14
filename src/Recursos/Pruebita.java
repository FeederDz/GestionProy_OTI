
package Recursos;

public class Pruebita {
    public static void main(String[] args) {
    controlador control = new controlador();
    String Nombre = control.DevolverRegistroBD("Select actividad from act_realizada",1);
    System.out.println(Nombre);

    } 
}


package Recursos;

public class Pruebita {
    public static void main(String[] args) {
    controlador control = new controlador();
    String Nombre = control.DevolverRegistroBD("Select cod_proy from cartera_proyectos",1);
    System.out.println(Nombre);

    } 
}

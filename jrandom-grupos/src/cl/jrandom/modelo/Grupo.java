/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.jrandom.modelo;

/**
 *
 * @author profesor
 */
public class Grupo {
    private int numero;
    private String nombre;

    public Grupo(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /*Esto es lo que se visualizará en esa lista.
     el numero y el nombre de la siguiente forma:

     1) Grupo 1*/
    @Override
    public String toString(){
        return numero +".- "+nombre;
    }
}

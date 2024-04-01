/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

public class ListaHash {

    NodoHash primero;
    NodoHash ultimo;

    public ListaHash() {
        this.primero = null;
    }
        /// esto es para insertar usuarios en el hast table
    public void insertar(String nombre, String apellido, String email, String genero, String celular, String llegada, int numeroHab) {
        NodoHash nuevo = new NodoHash(nombre, apellido, email, genero, celular, llegada, numeroHab);
        if (this.primero == null) {
            this.primero = this.ultimo = nuevo;
        } else {
            this.ultimo.setpNext(nuevo);
            this.ultimo = nuevo;
        }
    }

    public void eliminar(String nombre, String apellido) {
        if (this.primero != null) {
            if (this.primero.getPrimer_nombre().toLowerCase().equals(nombre) || this.primero.getSegundo_nombre().toLowerCase().equals(apellido)) {
                NodoHash aux = this.primero;
                while (aux.getpNext() != null && (!aux.getpNext().getPrimer_nombre().toLowerCase().equals(nombre)) || !aux.getpNext().getSegundo_nombre().toLowerCase().equals(apellido)) {
                    aux = aux.getpNext();
                }
                if (aux.getpNext() != null) {
                    aux.setpNext(aux.getpNext().getpNext());
                }
            } else {
                this.primero = this.primero.getpNext();
            }
        }
    }

    public NodoHash buscar(String nombre, String apellido) {
        if (this.primero != null) {
            NodoHash aux = this.primero;
            while (aux != null && (!aux.getPrimer_nombre().toLowerCase().equals(nombre)) || !aux.getSegundo_nombre().toLowerCase().equals(apellido)) {
                aux = aux.getpNext();
            }
            return aux;
        }
        return null;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

import hotelbooking.NodoHistorial;

public class ArbolHistorial {

    public NodoHistorial raiz;

    public ArbolHistorial() {
        raiz = null;
    }

    public void nuevoHistorial(String nombre, String apellido, String email, String genero, String llegada, int ci) {
        NodoHistorial nuevo = new NodoHistorial(nombre, apellido, email, genero, llegada, ci);
        if (this.raiz == null) {
            this.raiz = nuevo;
        } else {
            this.insertar(nuevo, this.raiz);
        }
    }
    ///insertar en el arbol del historial
    private void insertar(NodoHistorial nueva, NodoHistorial padre) {
        if (padre != null) {
            if (padre.getCi() >= nueva.getCi()) {
                if (padre.getHijoIzquierdo() != null) {
                    this.insertar(nueva, padre.getHijoIzquierdo());
                } else {
                    padre.setHijoIzquierdo(nueva);
                }
            } else if (padre.getCi() < nueva.getCi()) {
                if (padre.getHijoDerecho() != null) {
                    this.insertar(nueva, padre.getHijoDerecho());
                } else {
                    padre.setHijoDerecho(nueva);
                }
            }
        }
    }
    ///impresion del historial
    public String imprimir(NodoHistorial actual, String resultado) {
        if (actual != null) {
            resultado = this.imprimir(actual.getHijoIzquierdo(), resultado);
            resultado += "Cliente " +actual.getPrimer_nombre() + " " + actual.getSegundo_nombre() + "\nDATOS: \n    Correo: " + actual.getEmail() + "\n   Genero: " + actual.getGenero() + "\n    Fecha Llegada: " + actual.getLlegada() + "\n";
            resultado = this.imprimir(actual.getHijoDerecho(), resultado);

        }
        return resultado;
    }
}

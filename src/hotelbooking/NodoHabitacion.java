/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

import hotelbooking.ArbolHistorial;


public class NodoHabitacion {
   private int numero_hab;
   private int piso;
   private String tipo;
   private ArbolHistorial historial;
   private boolean ocupada;

    public NodoHabitacion(int numero_hab, int piso, String tipo) {
        this.numero_hab = numero_hab;
        this.piso = piso;
        this.tipo = tipo;
        historial = new ArbolHistorial();
        ocupada = false;
    }

    /**
     * @return the numero_hab
     */
    public int getNumero_hab() {
        return numero_hab;
    }

    /**
     * @param numero_hab the numero_hab to set
     */
    public void setNumero_hab(int numero_hab) {
        this.numero_hab = numero_hab;
    }

    /**
     * @return the piso
     */
    public int getPiso() {
        return piso;
    }

    /**
     * @param piso the piso to set
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the historial
     */
    public ArbolHistorial getHistorial() {
        return historial;
    }

    /**
     * @param historial the historial to set
     */
    public void setHistorial(ArbolHistorial historial) {
        this.historial = historial;
    }

    /**
     * @return the ocupada
     */
    public boolean isOcupada() {
        return ocupada;
    }

    /**
     * @param ocupada the ocupada to set
     */
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
   
   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

public class ArregloHabitaciones {

    NodoHabitacion[] habitaciones;

    public ArregloHabitaciones() {
        this.habitaciones = new NodoHabitacion[300];
        for (int i = 0; i < 300; i++) {
            this.habitaciones[i] = null;
        }
    }

    public void insertarHab(int numero_hab, int piso, String tipo) {
        habitaciones[numero_hab-1] = new NodoHabitacion(numero_hab, piso, tipo);
    }

    public NodoHabitacion buscarHab(int numero_hab) {
        return this.habitaciones[numero_hab-1];
    }

    public String verHistorial(int numero_hab) {
        return this.habitaciones[numero_hab-1].getHistorial().imprimir(habitaciones[numero_hab-1].getHistorial().raiz, "");
    }

    public void agregarHistorial(int numero_hab, String nombre, String apellido, String email, String genero, String llegada, int ci) {
        this.habitaciones[numero_hab-1].getHistorial().nuevoHistorial(nombre, apellido, email, genero, llegada, ci);
    }
    
    public NodoHabitacion asignarHab(String tipo){
        for (int i = 0; i < 300; i++) {
            if(this.habitaciones[i].getTipo().equals(tipo) && !this.habitaciones[i].isOcupada()){
                return this.habitaciones[i];
            }
        }
        return null;
    }
}

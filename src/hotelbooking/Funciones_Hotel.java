/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2kelvin;


public class Funciones_Hotel {
    public static ArbolReserva bdd_reservaciones;
    public static HashClientes bdd_clientes;
    public static ArregloHabitaciones bdd_habitaciones;

    public Funciones_Hotel(ArbolReserva bdd_reservaciones, HashClientes bdd_clientes, ArregloHabitaciones bdd_habitaciones) {
        this.bdd_reservaciones = bdd_reservaciones;
        this.bdd_clientes = bdd_clientes;
        this.bdd_habitaciones = bdd_habitaciones;
    }
    
    public String Check_in(int ci) {
        NodoReserva reserva = bdd_reservaciones.BuscarReservacion(ci);
        if (reserva != null) {
            NodoHabitacion habitacion = bdd_habitaciones.asignarHab(reserva.getTipo_hab());
            if (habitacion != null) {
                habitacion.setOcupada(true);
                this.bdd_clientes.Insertar( reserva.getPrimer_nombre(), reserva.getSegundo_nombre(), reserva.getEmail(), reserva.getGenero(), reserva.getCelular(), reserva.getFecha_llegada(), habitacion.getNumero_hab());
                this.bdd_reservaciones.EliminarReservacion(ci);
                return "Check-In realizado exitosamente!\nEl cliente " + reserva.getPrimer_nombre() + " " + reserva.getSegundo_nombre() + " se hospedará en la habitación " + habitacion.getNumero_hab();
            } else {
                return "No hay habitaciones de ese tipo disponibles por el momento";
            }
        } else {
            return "No hay reserva con esa cédula";
        }
    }

    public String Check_out(String nombre, String apellido, int ci) {
        NodoHash cliente = bdd_clientes.Buscar(nombre, apellido);
        System.out.println(cliente);
        if (cliente != null) {
            System.out.println("joya");
            NodoHabitacion habitacion = this.bdd_habitaciones.habitaciones[cliente.getNum_hab()-1];
            if (habitacion != null) {
                System.out.println("tn");
                habitacion.setOcupada(false);
                bdd_habitaciones.agregarHistorial(habitacion.getNumero_hab(), nombre, apellido, cliente.getEmail(), cliente.getGenero(), cliente.getLlegada(), ci);
                bdd_clientes.Eliminar(nombre, apellido);
                return "El cliente " + cliente.getPrimer_nombre() + " " + cliente.getSegundo_nombre() + " ha desalojado la habitación " + habitacion.getNumero_hab() + ".\nGracias por visitarnos!";
            }
        }
        return "Error, datos invalidos";
    }
    
    

}

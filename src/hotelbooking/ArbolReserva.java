/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

public class ArbolReserva {

    NodoReserva root;

    public ArbolReserva() {
        root = null;
    }
    ///creacion de la reservacion
    public void CrearReservacion(int ci, String primer_nombre, String segundo_nombre, String email, String genero, String tipo_hab, String celular, String fecha_llegada, String fecha_salida) {
        NodoReserva nueva = new NodoReserva(ci, primer_nombre, segundo_nombre, email, genero, tipo_hab, celular, fecha_llegada, fecha_salida);
        if (this.root != null) {
            this.insertar(nueva, this.root);
        } else {

            this.root = nueva;
        }
    }
    ///insertar una reservacion
    private void insertar(NodoReserva nueva, NodoReserva reservaActual) {
        if (reservaActual != null) {
            if (reservaActual.getCi() >= nueva.getCi()) {
                if (reservaActual.getHijoIzquierdo() != null) {
                    this.insertar(nueva, reservaActual.getHijoIzquierdo());
                } else {
                    reservaActual.setHijoIzquierdo(nueva);
                }
            } else if (reservaActual.getCi() < nueva.getCi()) {
                if (reservaActual.getHijoDerecho() != null) {
                    this.insertar(nueva, reservaActual.getHijoDerecho());
                } else {
                    reservaActual.setHijoDerecho(nueva);
                }
            }
        }
    }
    
    public NodoReserva BuscarReservacion(int ci) {
        return this.buscar(ci, root);
    }
    ///busqueda de reservacion
    private NodoReserva buscar(int ci, NodoReserva reservaActual) {
        if (reservaActual != null) {
            NodoReserva buscar = null;
            if (reservaActual.getCi() > ci) {
                buscar = this.buscar(ci, reservaActual.getHijoIzquierdo());
            } else if (reservaActual.getCi() < ci) {
                buscar = this.buscar(ci, reservaActual.getHijoDerecho());
            } else {
                return reservaActual;
            }
            return buscar;
        }
        return null;
    }

    public String imprimir(NodoReserva reservaActual, String txt) {
        if (reservaActual != null) {
            txt = this.imprimir(reservaActual.getHijoIzquierdo(), txt);
            txt += reservaActual.getCi() + "; ";
            txt = this.imprimir(reservaActual.getHijoDerecho(), txt);

        }
        return txt;
    }

    public void EliminarReservacion(int ci) {
        this.root = eliminar(this.root, ci);
        System.out.println(this.BuscarReservacion(ci));
    }

    private NodoReserva eliminar(NodoReserva reservaActual, int ci) {
        if (reservaActual == null) {
            return null;
        }

        if (ci < reservaActual.getCi()) {
            
            reservaActual.setHijoIzquierdo(eliminar(reservaActual.getHijoIzquierdo(), ci));
            
        } else if (ci > reservaActual.getCi()) {

            reservaActual.setHijoDerecho(eliminar(reservaActual.getHijoDerecho(), ci));

        } else {

            if (reservaActual.getHijoIzquierdo() == null && reservaActual.getHijoDerecho() == null) {

                reservaActual = null;

            } else if (reservaActual.getHijoIzquierdo() == null) {

                reservaActual = reservaActual.getHijoDerecho();

            } else if (reservaActual.getHijoDerecho() == null) {

                reservaActual = reservaActual.getHijoIzquierdo();

            } else {

                NodoReserva reservaMinima = min(reservaActual.getHijoDerecho());
                reservaActual.setCi(reservaMinima.getCi());
                reservaActual.setHijoDerecho(eliminar(reservaActual.getHijoDerecho(), reservaMinima.getCi()));
            }
        }

        if (reservaActual != null) {
            
            reservaActual.setAltura(1 + Math.max(rama(reservaActual.getHijoIzquierdo()), rama(reservaActual.getHijoDerecho())));
            
            int balance = rama(reservaActual.getHijoIzquierdo()) - rama(reservaActual.getHijoDerecho());

            if (balance > 1 && rama(reservaActual.getHijoIzquierdo().getHijoIzquierdo()) >= rama(reservaActual.getHijoIzquierdo().getHijoDerecho())) {

                reservaActual = rotarDerecha(reservaActual);

            } else if (balance > 1 && rama(reservaActual.getHijoIzquierdo().getHijoDerecho()) > rama(reservaActual.getHijoIzquierdo().getHijoIzquierdo())) {

                reservaActual.setHijoIzquierdo(rotarIzquierda(reservaActual.getHijoIzquierdo()));
                reservaActual = rotarDerecha(reservaActual);

            } else if (balance < -1 && rama(reservaActual.getHijoDerecho().getHijoDerecho()) >= rama(reservaActual.getHijoDerecho().getHijoIzquierdo())) {

                reservaActual = rotarIzquierda(reservaActual);

            } else if (balance < -1 && rama(reservaActual.getHijoDerecho().getHijoIzquierdo()) > rama(reservaActual.getHijoDerecho().getHijoDerecho())) {

                reservaActual.setHijoDerecho(rotarDerecha(reservaActual.getHijoDerecho()));
                reservaActual = rotarIzquierda(reservaActual);

            }
        }

        return reservaActual;
    }

    private NodoReserva min(NodoReserva reservaActual) {
        if (reservaActual.getHijoIzquierdo() == null) {
            return reservaActual;
        }
        return min(reservaActual.getHijoIzquierdo());
    }

    public NodoReserva rotarDerecha(NodoReserva reserva) {
        NodoReserva reserva_izq = reserva.getHijoIzquierdo();
        NodoReserva aux = reserva_izq.getHijoDerecho();

        reserva_izq.setHijoDerecho(reserva);
        reserva.setHijoIzquierdo(aux);

        reserva.setAltura(this.max(this.rama(reserva.getHijoIzquierdo()), this.rama(reserva.getHijoDerecho())) + 1);
        reserva_izq.setAltura(this.max(this.rama(reserva_izq.getHijoIzquierdo()), this.rama(reserva_izq.getHijoDerecho())) + 1);

        return reserva_izq;
    }

    public NodoReserva rotarIzquierda(NodoReserva reserva) {
        NodoReserva reserva_der = reserva.getHijoDerecho();
        NodoReserva aux = reserva_der.getHijoIzquierdo();

        reserva_der.setHijoIzquierdo(reserva);
        reserva.setHijoDerecho(aux);

        reserva.setAltura(this.max(this.rama(reserva.getHijoIzquierdo()), this.rama(reserva.getHijoDerecho())) + 1);
        reserva_der.setAltura(this.max(this.rama(reserva_der.getHijoIzquierdo()), this.rama(reserva_der.getHijoDerecho())) + 1);

        return reserva_der;
    }

    public int Balance(NodoReserva reservaActual) {
        if (reservaActual == null) {
            return 0;
        }
        return this.rama(reservaActual.getHijoIzquierdo()) - this.rama(reservaActual.getHijoDerecho());
    }

    public int rama(NodoReserva reservaActual) {
        if (reservaActual == null) {
            return 0;
        }
        return reservaActual.getAltura();
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }
}

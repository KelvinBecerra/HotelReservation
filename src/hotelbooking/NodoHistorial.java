/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;


public class NodoHistorial {
    private String primer_nombre;
    private String segundo_nombre;
    private String email;
    private String genero;
    private String llegada;
    private int ci;
    private NodoHistorial HijoIzquierdo;
    private NodoHistorial HijoDerecho;

    public NodoHistorial(String nombre, String apellido, String email, String genero, String llegada, int ci) {
        this.primer_nombre = nombre;
        this.segundo_nombre = apellido;
        this.email = email;
        this.genero = genero;
        this.llegada = llegada;
        this.ci = ci;
        this.HijoDerecho = null;
        this.HijoIzquierdo = null;
    }

/**
     * @return the primer_nombre
     */
    public String getPrimer_nombre() {
        return primer_nombre;
    }

    /**
     * @param primer_nombre the primer_nombre to set
     */
    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    /**
     * @return the segundo_nombre
     */
    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    /**
     * @param segundo_nombre the segundo_nombre to set
     */
    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }
    

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the llegada
     */
    public String getLlegada() {
        return llegada;
    }

    /**
     * @param llegada the llegada to set
     */
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    /**
     * @return the ci
     */
    public int getCi() {
        return ci;
    }

    /**
     * @param ci the ci to set
     */
    public void setCi(int ci) {
        this.ci = ci;
    }

    /**
     * @return the HijoIzquierdo
     */
    public NodoHistorial getHijoIzquierdo() {
        return HijoIzquierdo;
    }

    /**
     * @param HijoIzquierdo the HijoIzquierdo to set
     */
    public void setHijoIzquierdo(NodoHistorial HijoIzquierdo) {
        this.HijoIzquierdo = HijoIzquierdo;
    }

    /**
     * @return the HijoDerecho
     */
    public NodoHistorial getHijoDerecho() {
        return HijoDerecho;
    }

    /**
     * @param HijoDerecho the HijoDerecho to set
     */
    public void setHijoDerecho(NodoHistorial HijoDerecho) {
        this.HijoDerecho = HijoDerecho;
    }

    
    
    
    
    
    
}

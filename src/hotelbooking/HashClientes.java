/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;


public class HashClientes {
    ListaHash[] clientes;
    int size;
    
    public HashClientes(){
        this.clientes = new ListaHash[300];
        this.size = 300;
        for (int i = 0; i < 300; i++) {
            this.clientes[i] = new ListaHash();
            
        }
    }
    
    public int hashCode(String primer_nombre, String segundo_nombre){
        int hash = 14;/// conversion de nombre a un indice ya que el hash table trabaja llaves las cuales deben ser indices
        
        for (int i = 0; i < primer_nombre.length(); i++) {
            hash += primer_nombre.charAt(i);
        }
        
        for (int i = 0; i < segundo_nombre.length(); i++) {
            hash += segundo_nombre.charAt(i);
        }
        
        return hash % this.size;
    }
    
    public void Insertar(String primer_nombre, String segundo_nombre, String email, String genero, String llegada, String celular, int num_hab){
        this.clientes[this.hashCode(primer_nombre.toLowerCase(),segundo_nombre.toLowerCase())].insertar( primer_nombre,  segundo_nombre,  email,  genero,  llegada,  celular,  num_hab);
    }
    
    public void Eliminar(String primer_nombre, String segundo_nombre){
        this.clientes[this.hashCode(primer_nombre.toLowerCase(),segundo_nombre.toLowerCase())].eliminar( primer_nombre.toLowerCase(),  segundo_nombre.toLowerCase());
    }
    
    public NodoHash Buscar(String primer_nombre, String segundo_nombre){
        return this.clientes[this.hashCode(primer_nombre.toLowerCase(),segundo_nombre.toLowerCase())].buscar( primer_nombre.toLowerCase(),  segundo_nombre.toLowerCase());
    }
    
    public String imprimir(String primer_nombre, String segundo_nombre){
        return this.clientes[this.hashCode(primer_nombre.toLowerCase(),segundo_nombre.toLowerCase())].buscar( primer_nombre.toLowerCase(),  segundo_nombre.toLowerCase()).toString();
    }
}

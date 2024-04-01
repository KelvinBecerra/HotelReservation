/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelbooking;

import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IMenuInicial extends javax.swing.JFrame {

    public static HashClientes clientes;
    public static ArbolReserva reservas;
    public static ArregloHabitaciones habs;

    /**
     * Creates new form MenuInicial
     */
    public IMenuInicial(HashClientes h, ArbolReserva ar, ArregloHabitaciones ah) {
        initComponents();
        clientes = h;
        reservas = ar;
        habs = ah;
        if (h == null) {
            reservas = this.readHabsReservasFromCSV("reservas.csv");
            habs = readHabsFromCSV("habitaciones.csv");
            habs = readHistorialFromCSV("historico.csv");
            clientes = this.readClientesFromCSV("estado.csv");
            ///aqui simplemente llamamos a cada uno de los hash para inicializar 
        }
        this.setVisible(true);
    }

    public static ArbolReserva readHabsReservasFromCSV(String filePath) {/// simplemente lo que se hace es leer cada linea y agg al arbol de las reservas
        ArbolReserva nodes = new ArbolReserva(); /// nodes es una variable que solo definimos aqui
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(IMenuInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 9) {/// simplemente aqui testeamos que el dato sea correcto
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 9) {
                        throw new IOException("Invalid CSV format");
                    }
                    String ci = values[0].replace(".", "");
                    nodes.CrearReservacion(Integer.parseInt(ci), values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(IMenuInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        System.out.println(nodes.imprimir(nodes.root, ""));
        return nodes;
    }

    public static ArregloHabitaciones readHabsFromCSV(String filePath) {/// simplemente lo que se hace es leer cada linea y agg al arbol de las habitaciones
        ArregloHabitaciones nodes = new ArregloHabitaciones();/// nodes otra vez solo se inicializa aqui
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(IMenuInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 3) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 3) {
                        throw new IOException("Invalid CSV format");
                    }
                    nodes.insertarHab(Integer.parseInt(values[0]), Integer.parseInt(values[2]), values[1]);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(IMenuInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }

    public static HashClientes readClientesFromCSV(String filePath) {/// simplemente lo que se hace es leer cada linea y agg al hash de los clientes
        HashClientes nodes = new HashClientes();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(IMenuInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 7) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            NodoHash[] clientes = new NodoHash[10];
            for (int i = 0; i < 10; i++) {
                clientes[i] = null;
            }
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 7) {
                        throw new IOException("Invalid CSV format");
                    }
                    if (values[0].equals("")) {
                        for (int i = 0; i < 10; i++) {
                            if (clientes[i] == null) {
                                clientes[i] = new NodoHash(values[1], values[2], values[3], values[4], values[6], values[5], 0);
                                break;
                            }

                        }
                    } else {
                        nodes.Insertar(values[1], values[2], values[3], values[4], values[5], values[6], Integer.parseInt(values[0]));
                        for (int i = 0; i < 10; i++) {
                            if (clientes[i] != null) {
                                nodes.Insertar(clientes[i].getPrimer_nombre(), clientes[i].getSegundo_nombre(), clientes[i].getEmail(), clientes[i].getGenero(), clientes[i].getLlegada(), clientes[i].getCelular(), Integer.parseInt(values[0]));
                                clientes[i] = null;
                            }
                        }
                        habs.buscarHab(Integer.parseInt(values[0])).setOcupada(true);

                    }

                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(IMenuInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }

    public static ArregloHabitaciones readHistorialFromCSV(String filePath) {
        ArregloHabitaciones nodes = habs;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(IMenuInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 7) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 7) {
                        throw new IOException("Invalid CSV format");
                    }
                    String ci = values[0].replace(".", "");
                    nodes.agregarHistorial(Integer.parseInt(values[6]), values[1], values[2], values[3], values[4], values[5], Integer.parseInt(ci));
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(IMenuInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Amazon Ember Display", 0, 36)); // NOI18N
        jLabel1.setText("MENÚ INICIAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        jButton1.setFont(new java.awt.Font("Amazon Ember Display", 0, 18)); // NOI18N
        jButton1.setText("CHECK-OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, -1, -1));

        jButton2.setFont(new java.awt.Font("Amazon Ember Display", 0, 18)); // NOI18N
        jButton2.setText("HUÉSPEDES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, -1));

        jButton3.setFont(new java.awt.Font("Amazon Ember Display", 0, 18)); // NOI18N
        jButton3.setText("RESERVACIONES");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        jButton4.setFont(new java.awt.Font("Amazon Ember Display", 0, 18)); // NOI18N
        jButton4.setText("HISTORIAL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 130, -1));

        jButton5.setFont(new java.awt.Font("Amazon Ember Display", 0, 18)); // NOI18N
        jButton5.setText("CHECK-IN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here: 
        IMenuClientes mc = new IMenuClientes(clientes, reservas, habs);/// boton huespedes lleva a menu cliente
        mc.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        IMenuReserva mr = new IMenuReserva(clientes, reservas, habs);
        mr.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        IMenuHistorialHabitacion mhh = new IMenuHistorialHabitacion(clientes, reservas, habs);
        mhh.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        IMenuCheckIn mci = new IMenuCheckIn(clientes, reservas, habs);///boton checkin para acceder a menu del chekin
        mci.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        IMenuCheckOut mco = new IMenuCheckOut(clientes, reservas, habs);/// boton check out para acceder a menu del check out
        mco.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}

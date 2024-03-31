/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelbooking;

public class IMenuCheckIn extends javax.swing.JFrame {

    public Funciones_Hotel funciones;
    public static HashClientes clientes;
    public static ArbolReserva reservas;
    public static ArregloHabitaciones habs;

    /**
     * Creates new form MenuCheckIn
     */
    public IMenuCheckIn(HashClientes h, ArbolReserva ar, ArregloHabitaciones ah) {
        initComponents();
        this.clientes = h;
        this.reservas = ar;
        this.habs = ah;
        funciones = new Funciones_Hotel(ar, h, ah);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nroHab = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Amazon Ember Display", 0, 18)); // NOI18N
        jLabel1.setText("Habitación:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jButton2.setFont(new java.awt.Font("Amazon Ember Display", 0, 18)); // NOI18N
        jButton2.setText("Inicio");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 70, 30));

        jLabel2.setFont(new java.awt.Font("Amazon Ember Display", 0, 36)); // NOI18N
        jLabel2.setText("MENÚ DE CHECK-IN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        nroHab.setFont(new java.awt.Font("Amazon Ember Display", 0, 14)); // NOI18N
        nroHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel1.add(nroHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 220, 30));

        jLabel3.setFont(new java.awt.Font("Amazon Ember Display", 0, 18)); // NOI18N
        jLabel3.setText("Introduzca su cédula para iniciar su estadía:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 570, 130));

        jButton3.setFont(new java.awt.Font("Amazon Ember Display", 0, 18)); // NOI18N
        jButton3.setText("Registrarse");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        IMenuInicial menu = new IMenuInicial(clientes, reservas, habs);
        menu.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            this.jTextArea1.setText(funciones.Check_in(Integer.parseInt(this.nroHab.getText().replace(".", ""))));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.jTextArea1.setText("INGRESE UNA CÉDULA VÁLIDA");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nroHab;
    // End of variables declaration//GEN-END:variables
}

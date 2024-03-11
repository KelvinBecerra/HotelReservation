/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author KelvinCi
 */
public class IHome extends javax.swing.JFrame {

    /**
     * Creates new form IHomee
     */
    public IHome() {
        initComponents();
        this.setSize(550, 550);
    }
    boolean mostrarHistorial = false;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Buscar = new javax.swing.JButton();
        BuscarenCheckin = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        registro = new javax.swing.JButton();
        verhistorial = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOME");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Buscar.setBackground(new java.awt.Color(255, 255, 102));
        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, 140));

        BuscarenCheckin.setBackground(new java.awt.Color(255, 255, 102));
        BuscarenCheckin.setText("Check-In");
        BuscarenCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarenCheckinActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarenCheckin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, 140));

        jButton3.setBackground(new java.awt.Color(255, 255, 102));
        jButton3.setText("Check-Out");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 100, 120));

        registro.setBackground(new java.awt.Color(255, 255, 102));
        registro.setText("Registro");
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });
        getContentPane().add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, 140));

        verhistorial.setBackground(new java.awt.Color(255, 255, 102));
        verhistorial.setText("Ver historial");
        verhistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verhistorialActionPerformed(evt);
            }
        });
        getContentPane().add(verhistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, 120));

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imags/imagenhotel.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(550, 550));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -10, 700, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
        System.out.println("Presionaste el boton 'Buscar'");

        this.setVisible(false);

        IBuscar nuevoBuscar = new IBuscar();
        nuevoBuscar.setSize(550, 550);
        nuevoBuscar.setLocationRelativeTo(null);
        nuevoBuscar.setVisible(true);
    }//GEN-LAST:event_BuscarActionPerformed

    private void BuscarenCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarenCheckinActionPerformed
        // TODO add your handling code here:
        System.out.println("Presionaste el boton 'Check-in'");

        this.setVisible(false);
        ICheckin nueva = new ICheckin();
        nueva.setSize(550, 550);
        nueva.setLocationRelativeTo(null);
        nueva.setVisible(true);
    }//GEN-LAST:event_BuscarenCheckinActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.out.println("Presionaste el boton 'Check-out'");

        this.setVisible(false);

        ICheckOut nuevo = new ICheckOut();
        nuevo.setLocationRelativeTo(null);
        nuevo.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        // TODO add your handling code here:
        System.out.println("Presionaste el boton 'Registro'");

        this.setVisible(false);

        IRegistro nuevo = new IRegistro();
        nuevo.setLocationRelativeTo(null);
        nuevo.setVisible(true);
    }//GEN-LAST:event_registroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        IBienvenida nueva = new IBienvenida();
        nueva.setLocationRelativeTo(null);
        nueva.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void verhistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verhistorialActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        IHistorial nueva = new IHistorial();
        nueva.setLocationRelativeTo(null);
        nueva.setMostrar(true);

        nueva.setVisible(true);


    }//GEN-LAST:event_verhistorialActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton BuscarenCheckin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton registro;
    private javax.swing.JButton verhistorial;
    // End of variables declaration//GEN-END:variables
}

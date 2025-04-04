
package view;

import bd.connectionDB;
import controller.ReservaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Reserva;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author maudy
 */
public class FormularioReservas extends javax.swing.JDialog {

    private Reserva reserva;
    static private String Mode = "";
    static private int id_reserva = 0;
    private Reservas parent;
    ReservaDAO dao = new ReservaDAO();
    
    
    public FormularioReservas(Reservas parent, boolean modal, String Mode, int id_reserva) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        setLocationRelativeTo(null);
        jdcEntrada.setDateFormatString("yyyy-MM-dd");
        jdcSalida.setDateFormatString("yyyy-MM-dd");
        llenarCBHuesped(cbxHuesped);
        llenarCBHabitacion(cbxHabitacion);
        
        this.Mode = Mode;
        this.id_reserva = id_reserva;
        reserva = new Reserva();        
    
        if (Mode.equals("UPD") || Mode.equals("DLT")) {
            reserva = (Reserva) dao.getById(id_reserva);
            jdcEntrada.setDate(reserva.getFecha_entrada());
            jdcSalida.setDate(reserva.getFecha_salida());
            cbxHuesped.setSelectedItem(String.valueOf(reserva.getId_huesped()));
            cbxHabitacion.setSelectedItem(String.valueOf(reserva.getId_habitacion()));
            cbxEstado.setSelectedItem(reserva.getEstado());
        }     
    
        if (Mode.equals("INS")) {
            btnOperacion.setText("Insertar");
        } else if (Mode.equals("UPD")) {
            btnOperacion.setText("Modificar");
        } else if (Mode.equals("DLT")) {
            btnOperacion.setText("Borrar");
        }
    }
    private void llenarCBHuesped(JComboBox<String> comboBox) {
        String sql = "SELECT id_huesped FROM reservas";

        try (Connection con = connectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                comboBox.addItem(String.valueOf(rs.getInt("id_huesped")));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al llenar JComboBox: " + e.getMessage());
        }
    }
    
    private void llenarCBHabitacion(JComboBox<String> comboBox) {
        String sql = "SELECT id_habitacion FROM reservas";

        try (Connection con = connectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                comboBox.addItem(String.valueOf(rs.getInt("id_habitacion")));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al llenar JComboBox: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        cbxHuesped = new javax.swing.JComboBox<>();
        cbxHabitacion = new javax.swing.JComboBox<>();
        jdcEntrada = new com.toedter.calendar.JDateChooser();
        jdcSalida = new com.toedter.calendar.JDateChooser();
        btnOperacion = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtReserva = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reservas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha de entrada:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de salida:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Habitación:");

        btnCancelar.setBackground(new java.awt.Color(255, 69, 58));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 199, 199)));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbxHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHuespedActionPerformed(evt);
            }
        });

        btnOperacion.setBackground(new java.awt.Color(255, 69, 58));
        btnOperacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOperacion.setForeground(new java.awt.Color(255, 255, 255));
        btnOperacion.setText("Operacion");
        btnOperacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 199, 199)));
        btnOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperacionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID Reserva:");

        txtReserva.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Huesped:");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Confirmada", "Cancelada", " " }));
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reservation.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(69, 69, 69))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cbxHabitacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(29, 29, 29)
                                .addComponent(cbxHuesped, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnOperacion)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(41, 41, 41)
                                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtReserva)))
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcEntrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOperacion)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHuespedActionPerformed
       
    }//GEN-LAST:event_cbxHuespedActionPerformed

    private void btnOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperacionActionPerformed
        Date date = jdcEntrada.getDate();
        Date date2 = jdcSalida.getDate();
        String formattedDate="";
        String formattedDate2="";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = sdf.format(date);
            formattedDate2 = sdf.format(date2); 
            System.out.println(formattedDate);
        } else {
            System.out.println("La fecha es nula.");
        }
        
        if (Mode.equals("UPD")) {
            java.util.Date utilDateE = null, utilDateF=null;
            try {
                utilDateE = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
                utilDateF = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate2);
            } catch (ParseException ex) {
                Logger.getLogger(FormularioReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date sqlDate = new java.sql.Date(utilDateE.getTime());
            java.sql.Date sqlDate2 = new java.sql.Date(utilDateF.getTime());// Convertir a java.sql.Date
            reserva.setFecha_entrada(sqlDate);
            reserva.setFecha_salida(sqlDate2);
           // reserva.setId_huesped(I);
            reserva.setId_huesped(Integer.parseInt(cbxHuesped.getSelectedItem().toString()));
            reserva.setId_habitacion(Integer.parseInt(cbxHabitacion.getSelectedItem().toString()));
            reserva.setEstado(cbxEstado.getSelectedItem().toString());
            boolean operacion = dao.update(reserva);
            if (operacion) {
                parent.refrescarDatos();
                this.dispose();
            
            }
    }else if(Mode.equals("INS")){
        java.util.Date utilDateE = null, utilDateF=null;
            try {
                utilDateE = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
                utilDateF = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate2);
            } catch (ParseException ex) {
                Logger.getLogger(FormularioReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date sqlDate = new java.sql.Date(utilDateE.getTime());
            java.sql.Date sqlDate2 = new java.sql.Date(utilDateF.getTime());// Convertir a java.sql.Date
            reserva.setFecha_entrada(sqlDate);
            reserva.setFecha_salida(sqlDate2);
            reserva.setId_huesped(Integer.parseInt(cbxHuesped.getSelectedItem().toString()));
            reserva.setId_habitacion(Integer.parseInt(cbxHabitacion.getSelectedItem().toString()));
            reserva.setEstado(cbxEstado.getSelectedItem().toString());
            boolean operacion = dao.insert(reserva);
            if (operacion) {
                parent.refrescarDatos();
                this.dispose();
            
            }
    }
    }//GEN-LAST:event_btnOperacionActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        
    }//GEN-LAST:event_cbxEstadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioReservas dialog = new FormularioReservas(new Reservas(), true, Mode, id_reserva);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOperacion;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxHabitacion;
    private javax.swing.JComboBox<String> cbxHuesped;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdcEntrada;
    private com.toedter.calendar.JDateChooser jdcSalida;
    private javax.swing.JTextField txtReserva;
    // End of variables declaration//GEN-END:variables
}

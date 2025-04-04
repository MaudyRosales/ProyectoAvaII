
package view;

import controller.HuespedDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.Huesped;

/**
 *
 * @author maudy
 */
public class FormularioHotel extends javax.swing.JDialog {

    private Huesped huesped;
    static private String Mode = "";
    static private int id_huesped = 0;
    private ListadoHuespedes parent;
    HuespedDAO dao = new HuespedDAO();
    
    public FormularioHotel(ListadoHuespedes parent, boolean modal, String Mode, int id_huesped) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        setLocationRelativeTo(null);
    
        this.Mode = Mode;
        this.id_huesped = id_huesped;
        huesped = new Huesped();        
    
        if (Mode.equals("UPD") || Mode.equals("DLT")) {
            huesped = (Huesped) dao.getById(id_huesped);  // Obtener el huésped por id
            txtID.setText(String.valueOf(huesped.getId_huesped()));
            txtNombre.setText(huesped.getNombre());
            txtEmail.setText(huesped.getEmail());
            txtTelefono.setText(String.valueOf(huesped.getTelefono()));
            txtFecha.setText(new SimpleDateFormat("yyyy-MM-dd").format(huesped.getFecha_registro()));
        }      
    
        if (Mode.equals("INS")) {
            btnOperacion.setText("Insertar");
        } else if (Mode.equals("UPD")) {
            btnOperacion.setText("Modificar");
        } else if (Mode.equals("DLT")) {
            btnOperacion.setText("Borrar");
        }
    }

    
    private boolean validar(){
        if(txtNombre.getText().equals("") || txtNombre.getText().equals(null)){
            JOptionPane.showMessageDialog(parent, "Debe ingresar un nombre", "ERROR DE VALIDACIÓN", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
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
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnOperacion = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("E-mail:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Teléfono:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha registro:");

        txtID.setEditable(false);
        txtID.setEnabled(false);
        txtID.setFocusable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        btnOperacion.setBackground(new java.awt.Color(255, 69, 58));
        btnOperacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOperacion.setForeground(new java.awt.Color(255, 255, 255));
        btnOperacion.setText("Operación");
        btnOperacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 199, 199)));
        btnOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperacionActionPerformed(evt);
            }
        });

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Huespedes");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/huesped.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtID))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(btnOperacion, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOperacion)
                    .addComponent(btnCancelar))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperacionActionPerformed
    if (Mode.equals("INS")) {
        boolean validacion = validar();
        if (validacion) {
            Huesped newHuesped = new Huesped();
            newHuesped.setNombre(txtNombre.getText());
            newHuesped.setEmail(txtEmail.getText());

            String telefono = txtTelefono.getText();
            if (!telefono.matches("\\d+")) {
                JOptionPane.showMessageDialog(parent, "El teléfono debe contener solo números", "ERROR DE VALIDACIÓN", JOptionPane.ERROR_MESSAGE);
                return;
            }
            newHuesped.setTelefono(Integer.parseInt(telefono));

            try {
                java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(txtFecha.getText());
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Convertir a java.sql.Date
                newHuesped.setFecha_registro(sqlDate);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(parent, "La fecha es incorrecta. Por favor ingrese una fecha válida en formato yyyy-MM-dd.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean operacion = dao.insert(newHuesped);
            if (operacion) {
                parent.refrescarDatos();
                this.dispose();
            }
        }
    }

    if (Mode.equals("UPD")) {
        boolean validacion = validar();
        if (validacion) {
            huesped.setNombre(txtNombre.getText());
            huesped.setEmail(txtEmail.getText());
            
            String telefono = txtTelefono.getText();
            if (!telefono.matches("\\d+")) {
                JOptionPane.showMessageDialog(parent, "El teléfono debe contener solo números", "ERROR DE VALIDACIÓN", JOptionPane.ERROR_MESSAGE);
                return;
            }
            huesped.setTelefono(Integer.parseInt(telefono));

            // Validación de la fecha
            try {
                java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(txtFecha.getText());
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Convertir a java.sql.Date
                huesped.setFecha_registro(sqlDate);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(parent, "La fecha es incorrecta. Por favor ingrese una fecha válida en formato yyyy-MM-dd.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualizar el huesped
            boolean operacion = dao.update(huesped);
            if (operacion) {
                parent.refrescarDatos();
                this.dispose();
            }
        }
    }
    }//GEN-LAST:event_btnOperacionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
       
    }//GEN-LAST:event_txtTelefonoActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login();
                dialog.setLocationRelativeTo(null);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

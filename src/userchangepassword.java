
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class userchangepassword extends javax.swing.JInternalFrame {

    Socket socket;
    String email;
    DataOutputStream dos;
    DataInputStream dis;

    public userchangepassword(Socket socket, String email) {
        initComponents();
        this.socket = socket;
        this.email = email;

        try {
            if (socket != null) {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        oldpass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jLabel1.setText("Old  Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 60, 90, 36);

        oldpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldpassActionPerformed(evt);
            }
        });
        getContentPane().add(oldpass);
        oldpass.setBounds(130, 60, 180, 30);

        jLabel2.setText("New Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 150, 90, 30);

        newpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpassActionPerformed(evt);
            }
        });
        getContentPane().add(newpass);
        newpass.setBounds(130, 150, 180, 30);

        jLabel3.setText("Confirm Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 240, 110, 30);
        getContentPane().add(cpass);
        cpass.setBounds(130, 240, 180, 30);

        jButton1.setText("Save Changes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 330, 130, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String OldPassword = oldpass.getText();
        String NewPassword = newpass.getText();
        String ConfirmPassword = cpass.getText();
        if (OldPassword.equals("") || NewPassword.equals("") || ConfirmPassword.equals("")) {
            JOptionPane.showMessageDialog(this, "Fill Out Data");
        } else {
            try {
                if (ConfirmPassword.equals(NewPassword)) {
                    dos.writeBytes("changepassword\r\n");
                    dos.writeBytes(email + "\r\n");
                    dos.writeBytes(OldPassword + "\r\n");

                    String response = dis.readLine();

                    if (response.equals("successCP")) {

                        dos.writeBytes("changepassword1\r\n");
                        dos.writeBytes(email + "\r\n");
                        dos.writeBytes(OldPassword + "\r\n");
                        dos.writeBytes(NewPassword + "\r\n");

                        String res = dis.readLine();

                        if (res.equals("passwordchanged")) {
                            JOptionPane.showMessageDialog(rootPane, "Password changed successfully");
                            this.dispose();
                        } else if (res.equals("passwordnotchanged")) {
                            JOptionPane.showMessageDialog(rootPane, "Password not changed");
                        }
                    } else if (response.equals("failCP")) {
                        JOptionPane.showMessageDialog(rootPane, "Old password is not correct.");
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "New and confirm password doesnot match");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void oldpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldpassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField cpass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JPasswordField oldpass;
    // End of variables declaration//GEN-END:variables
}

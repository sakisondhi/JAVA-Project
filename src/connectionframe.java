
import java.awt.Color;
import java.net.Socket;
import javax.swing.JOptionPane;

public class connectionframe extends javax.swing.JFrame
{

    Socket socket;

    public connectionframe()
    {
        initComponents();
        setSize(510, 521);
        jpdata.setVisible(false);
        setTitle("Setup Connection");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Color cl = new Color(135, 206, 250);
        getContentPane().setBackground(cl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btconnect = new javax.swing.JButton();
        jpdata = new javax.swing.JPanel();
        btsignup = new javax.swing.JButton();
        btlogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btconnect.setText("CONNECT TO SERVER");
        btconnect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btconnectActionPerformed(evt);
            }
        });
        getContentPane().add(btconnect);
        btconnect.setBounds(130, 150, 180, 40);

        jpdata.setBackground(new java.awt.Color(135, 206, 250));
        jpdata.setLayout(null);

        btsignup.setText("SIGN UP");
        btsignup.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btsignupActionPerformed(evt);
            }
        });
        jpdata.add(btsignup);
        btsignup.setBounds(0, 10, 120, 30);

        btlogin.setText("LOG IN");
        btlogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btloginActionPerformed(evt);
            }
        });
        jpdata.add(btlogin);
        btlogin.setBounds(0, 43, 120, 30);

        getContentPane().add(jpdata);
        jpdata.setBounds(170, 190, 120, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconnectActionPerformed

        try
        {
            socket = new Socket("127.0.0.1", 4200);
            System.out.println("CLIENT CONNECTION BUILD");
            btconnect.setEnabled(false);
            jpdata.setVisible(true);

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Server is not running!!");
//            e.printStackTrace();
        }

    }//GEN-LAST:event_btconnectActionPerformed

    private void btsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsignupActionPerformed
        signup up = new signup(socket);
        up.setSize(500, 500);
        up.setVisible(true);
    }//GEN-LAST:event_btsignupActionPerformed

    private void btloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btloginActionPerformed

        userlogin ul = new userlogin(socket);
        ul.setVisible(true);
        ul.setSize(500, 600);

    }//GEN-LAST:event_btloginActionPerformed

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(connectionframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(connectionframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(connectionframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(connectionframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new connectionframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btconnect;
    private javax.swing.JButton btlogin;
    private javax.swing.JButton btsignup;
    private javax.swing.JPanel jpdata;
    // End of variables declaration//GEN-END:variables
}

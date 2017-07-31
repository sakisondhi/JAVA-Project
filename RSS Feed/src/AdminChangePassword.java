
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.util.Optional.empty;
import javax.swing.JOptionPane;

public class AdminChangePassword extends javax.swing.JInternalFrame
{

    String email = "puneettuteja@gmail.com";

    public AdminChangePassword()
    {
        initComponents();
        setTitle("Change Password");
        setSize(700, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 205, 170));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel1.setText("Old Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 110, 150, 40);

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel2.setText("New Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 150, 130, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel3.setText("Confirm Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 190, 170, 30);

        jButton1.setText("Save ");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(180, 240, 90, 30);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(180, 110, 200, 30);
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(180, 150, 200, 30);
        getContentPane().add(jPasswordField3);
        jPasswordField3.setBounds(180, 190, 200, 30);

        jLabel4.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel4.setText("Change Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 20, 220, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String Oldpassword = jPasswordField1.getText();
        String Newpassword = jPasswordField2.getText();
        String ConfirmPassword = jPasswordField3.getText();

        if (Oldpassword.equals("") || Newpassword.equals("") || ConfirmPassword.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Fill the Password Please");
        } else if (Newpassword.equals(ConfirmPassword))
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from admin where E_Mail='" + email + "' and "
                        + "password='" + Oldpassword + "'");
                if (rs.next())
                {
                    rs.updateString("password", Newpassword);
                    rs.updateRow();
                    JOptionPane.showMessageDialog(rootPane, "Password changed successfully");
                    this.dispose();
                } else
                {
                    JOptionPane.showMessageDialog(this, "Incorrect old password");
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        } else
        {
            JOptionPane.showMessageDialog(this, "Confirm Password and new password Does't Match");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables
}

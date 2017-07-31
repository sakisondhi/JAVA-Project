
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setTitle("LOGIN");
        setSize(450, 450);
        jLabel3.setSize(450, 450);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        Color cl = new Color(204, 204, 255);
        //getContentPane().setBackground(cl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        bt = new javax.swing.JButton();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        pf = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(134, 82, 186));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        getContentPane().setLayout(null);

        bt.setBackground(new java.awt.Color(255, 255, 255));
        bt.setText("Login");
        bt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(160, 280, 130, 30);

        lb1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setText("User Name:");
        getContentPane().add(lb1);
        lb1.setBounds(30, 150, 170, 31);

        lb2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setText("Password:");
        getContentPane().add(lb2);
        lb2.setBounds(30, 210, 150, 30);

        tf1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        tf1.setForeground(new java.awt.Color(51, 0, 51));
        tf1.setText("abc@gmail.com");
        tf1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(160, 150, 230, 30);

        pf.setText("123");
        getContentPane().add(pf);
        pf.setBounds(160, 210, 230, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Forgot password ?");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 330, 150, 30);

        jLabel1.setFont(new java.awt.Font("Meiryo UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN...");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 280, 70);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\VMM-63\\Desktop\\Shades-of-Blue-Color-Names11.gif")); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel3.setMinimumSize(new java.awt.Dimension(500, 500));
        jLabel3.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 470, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed

        String username = tf1.getText();
        String userpassword = pf.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select*from admin where e_mail='" + username + "' "
                    + "and password='" + userpassword + "'");

            if (rs.next()) {
                Admin_Item admin_Item = new Admin_Item();
                admin_Item.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username/password");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed

    }//GEN-LAST:event_tf1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String email = JOptionPane.showInputDialog(rootPane, "Enter your email?");

            if (email != null) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from admin where e_mail='" + email + "' ");

                if (rs.next()) {
                    String ques = rs.getString("security_question");
                    String ans = JOptionPane.showInputDialog(rootPane, ques);

                    if (ans != null) {
                        Statement stmt1 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs1 = stmt1.executeQuery("select*from admin where e_mail='" + email + "' and "
                                + "security_answer='" + ans + "'");

                        if (rs1.next()) {
                            String password = rs.getString("password");
                            JOptionPane.showMessageDialog(rootPane, "Your password is " + password);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Incorrect answer");
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Invalid email address");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JPasswordField pf;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}

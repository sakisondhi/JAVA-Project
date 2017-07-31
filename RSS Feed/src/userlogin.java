
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class userlogin extends javax.swing.JFrame
{

    Socket socket;
    DataOutputStream dos;
    DataInputStream dis;

    public userlogin(Socket mysock)
    {
        initComponents();
        setSize(400, 400);
        this.socket = mysock;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        if (socket != null)
        {
            try
            {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Username:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 90, 40);

        jTextField1.setText("abc@gmail.com");
        jTextField1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 20, 190, 30);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Password:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 90, 140, 50);

        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 170, 190, 30);

        jButton2.setText("FORGOT PASSWORD ?");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(150, 230, 190, 30);

        jPasswordField1.setText("12345");
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(150, 100, 190, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (socket != null)
        {
            String E_mail = jTextField1.getText();
            String Password = jPasswordField1.getText();
            if (E_mail.equals("") || Password.equals(""))
            {
                JOptionPane.showMessageDialog(this, "Fill Out Data");
            } else
            {
                try
                {

                    dos.writeBytes("login\r\n");
                    dos.writeBytes(E_mail + "\r\n");
                    dos.writeBytes(Password + "\r\n");

                    String response = dis.readLine();

                    if (response.equals("loginsuccess"))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Loginsuccessful");
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select*from userdetail where email='" + E_mail + "' "
                                + "and password='" + Password + "'");
                        if (rs.next())
                        {
                            userhome uh = new userhome(socket, E_mail);
                            uh.setVisible(true);
                            this.dispose();
                        }

                    } else if (response.equals("loginfail"))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Invalid username/password");
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String E_mail = JOptionPane.showInputDialog(this, "Enter your E_mail");
        if (E_mail != null)
        {
            try
            {
                dos.writeBytes("forgotpassword\r\n");
                dos.writeBytes(E_mail + "\r\n");

                String response = dis.readLine();
                if (response.equals("fpsuccess"))
                {
                    String sec_ques = dis.readLine();
                    String answer = JOptionPane.showInputDialog(rootPane, sec_ques);
                    if (answer != null)
                    {
                        dos.writeBytes("forgotpassword1\r\n");
                        dos.writeBytes(E_mail + "\r\n");
                        dos.writeBytes(answer + "\r\n");
                        String res = dis.readLine();
                        if (res.equals("fp1success"))
                        {
                            String password = dis.readLine();
                            JOptionPane.showMessageDialog(rootPane, "Your password is " + password);
                        } else if (res.equals("fp1fail"))
                        {
                            JOptionPane.showMessageDialog(rootPane, "Icorrect answer.");
                        }

                    }
                } else if (response.equals("fpfail"))
                {
                    JOptionPane.showMessageDialog(rootPane, "Invalid email address");
                }

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[])
    {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

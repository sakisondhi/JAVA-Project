
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class signup extends javax.swing.JFrame
{

    Socket socketsignup;
    DataOutputStream dos;
    DataInputStream dis;

    String sec_ques[] =
    {
        "what is your pet name",
        "what is your first phone number",
        "what is your nick name ",
        "what is your fav colour",
        "what is your lucky number",
        "what is your fav place"
    };

    public signup(Socket s)
    {
        initComponents();
        this.socketsignup = s;
        if (socketsignup != null)
        {
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(sec_ques));
        }
        try
        {
            dis = new DataInputStream(socketsignup.getInputStream());
            dos = new DataOutputStream(socketsignup.getOutputStream());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setSize(400, 400);
        setTitle("Sign UP");
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(sec_ques));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(219, 112, 147));
        getContentPane().setLayout(null);

        jLabel1.setText("USERNAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 30, 90, 30);

        jLabel2.setText("PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 70, 110, 40);

        jLabel3.setText("SECURITY QUESTION");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 130, 130, 20);

        jLabel4.setText("SECURITY ANSWER");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 180, 120, 30);

        jLabel5.setText("PHONE NO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 220, 70, 20);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(170, 30, 170, 30);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(170, 70, 170, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(170, 130, 200, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(170, 170, 150, 30);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(170, 210, 150, 30);

        jButton1.setText("SIGN UP");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(170, 260, 140, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String user = jTextField1.getText().trim();
        String password = jPasswordField1.getText().trim();
        String sec_ques = jComboBox1.getSelectedItem().toString();
        String sec_ans = jTextField2.getText();
        String phone_no = jTextField3.getText();

        if (user.equals("") || password.equals("") || sec_ques.equals("") || phone_no.equals("") || sec_ans.equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Fill all Required Data");

        } else
        {
            try
            {
                dos.writeBytes("signup\r\n");
                dos.writeBytes(user + "\r\n");
                dos.writeBytes(password + "\r\n");
                dos.writeBytes(sec_ques + "\r\n");
                dos.writeBytes(sec_ans + "\r\n");
                dos.writeBytes(phone_no + "\r\n");

                String msg = dis.readLine();
                if (msg.equals("success"))
                {
                    JOptionPane.showMessageDialog(rootPane, "Signed Up sucessfully");
                    this.dispose();
                } else if (msg.equals("fail"))
                {
                    JOptionPane.showMessageDialog(rootPane, "Username/Email already registered");
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public static void main(String args[])
    {

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new signup(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

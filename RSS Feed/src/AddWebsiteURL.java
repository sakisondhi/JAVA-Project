
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AddWebsiteURL extends javax.swing.JInternalFrame
{

    ArrayList<String> alcategory = new ArrayList<>();

    public AddWebsiteURL()
    {
        initComponents();
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                    Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select*from category");

                    while (rs.next())
                    {
                        String C_name = rs.getString("C_name");
                        alcategory.add(C_name);
                        System.out.println(C_name);
                    }
                    cbcname.setModel(new javax.swing.DefaultComboBoxModel(alcategory.toArray()));
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
        setSize(700, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Add Website");
        Color cl = new Color(204, 204, 255);
        getContentPane().setBackground(cl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbcname = new javax.swing.JComboBox();
        tfwebsitename = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tadesc = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Category");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 80, 140, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Website Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 130, 140, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Website URL");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 220, 120, 20);

        cbcname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcnameActionPerformed(evt);
            }
        });
        getContentPane().add(cbcname);
        cbcname.setBounds(180, 80, 200, 30);
        getContentPane().add(tfwebsitename);
        tfwebsitename.setBounds(180, 130, 200, 30);

        tadesc.setColumns(20);
        tadesc.setLineWrap(true);
        tadesc.setRows(5);
        jScrollPane1.setViewportView(tadesc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(180, 180, 200, 96);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(180, 300, 200, 40);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add Website URL");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 10, 210, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbcnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbcnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cname = cbcname.getSelectedItem().toString();
        String Websitename = tfwebsitename.getText();
        String url = tadesc.getText();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select*from website_url ");

            rs.moveToInsertRow();
            rs.updateString("url", url);
            rs.updateString("c_name", cname);
            rs.updateString("website name", Websitename);
            rs.insertRow();
            JOptionPane.showMessageDialog(this, "Website url added successfully");

            tadesc.setText("");
            tfwebsitename.setText("");
            cbcname.setSelectedItem(0);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbcname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tadesc;
    private javax.swing.JTextField tfwebsitename;
    // End of variables declaration//GEN-END:variables
}

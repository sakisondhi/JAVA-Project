
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditUrl extends javax.swing.JInternalFrame
{

    String urlid;
    String url;
    String websitename;
    String cname;
    ArrayList<String> alcategory = new ArrayList<>();

    public EditUrl(String ui, String u, String wname, String cname)
    {
        initComponents();
        this.urlid = ui;
        tfeurl.setText(wname);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        taeurl.setText(u);
        this.cname = cname;
        alcategory.add(cname);

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
                    cbeurl.setModel(new javax.swing.DefaultComboBoxModel(alcategory.toArray()));
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbeurl = new javax.swing.JLabel();
        tfeurl = new javax.swing.JTextField();
        lb1eurl = new javax.swing.JLabel();
        cbeurl = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taeurl = new javax.swing.JTextArea();

        getContentPane().setLayout(null);

        lbeurl.setText("Website Name");
        getContentPane().add(lbeurl);
        lbeurl.setBounds(20, 60, 180, 20);

        tfeurl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfeurlActionPerformed(evt);
            }
        });
        getContentPane().add(tfeurl);
        tfeurl.setBounds(130, 60, 290, 30);

        lb1eurl.setText("Website URL");
        getContentPane().add(lb1eurl);
        lb1eurl.setBounds(20, 130, 70, 20);

        cbeurl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbeurlActionPerformed(evt);
            }
        });
        getContentPane().add(cbeurl);
        cbeurl.setBounds(130, 230, 290, 30);

        jLabel1.setText("Select Categories");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 230, 110, 30);

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 300, 150, 40);

        taeurl.setColumns(20);
        taeurl.setRows(5);
        jScrollPane1.setViewportView(taeurl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(130, 120, 290, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cname = cbeurl.getSelectedItem().toString();
        String Websitename = taeurl.getText();
        String url = tfeurl.getText();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select*from website_url where c_name='" + cname + "'");

            if (rs.next())
            {
                rs.updateString("url", url);
                rs.updateString("c_name", cname);
                rs.updateString("website name", Websitename);
                rs.updateRow();
                JOptionPane.showMessageDialog(this, "Website url updated successfully");

                this.dispose();
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbeurlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbeurlActionPerformed

    }//GEN-LAST:event_cbeurlActionPerformed

    private void tfeurlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfeurlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfeurlActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbeurl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1eurl;
    private javax.swing.JLabel lbeurl;
    private javax.swing.JTextArea taeurl;
    private javax.swing.JTextField tfeurl;
    // End of variables declaration//GEN-END:variables
}

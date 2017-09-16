
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Add_Category extends javax.swing.JInternalFrame
{

    public Add_Category()
    {
        initComponents();
        setSize(700, 600);
        setTitle("Add Category");
        Color cl = new Color(255, 255, 240);
        getContentPane().setBackground(cl);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbname = new javax.swing.JLabel();
        tfcname = new javax.swing.JTextField();
        lbdesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tacdesc = new javax.swing.JTextArea();
        btphoto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btaddcategory = new javax.swing.JButton();
        lbphotopath = new javax.swing.JLabel();
        lbpath = new javax.swing.JLabel();
        lbphoto = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        lbname.setText("C_Name");
        getContentPane().add(lbname);
        lbname.setBounds(34, 28, 50, 14);

        tfcname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcnameActionPerformed(evt);
            }
        });
        getContentPane().add(tfcname);
        tfcname.setBounds(143, 25, 170, 20);

        lbdesc.setText("C_Desc");
        getContentPane().add(lbdesc);
        lbdesc.setBounds(34, 73, 40, 14);

        tacdesc.setColumns(20);
        tacdesc.setRows(5);
        jScrollPane1.setViewportView(tacdesc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(143, 73, 166, 96);

        btphoto.setText("Select");
        btphoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btphotoActionPerformed(evt);
            }
        });
        getContentPane().add(btphoto);
        btphoto.setBounds(150, 190, 170, 23);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(144, 240, 160, 0);

        btaddcategory.setText("Add");
        btaddcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddcategoryActionPerformed(evt);
            }
        });
        getContentPane().add(btaddcategory);
        btaddcategory.setBounds(181, 270, 120, 23);
        getContentPane().add(lbphotopath);
        lbphotopath.setBounds(180, 230, 140, 0);
        getContentPane().add(lbpath);
        lbpath.setBounds(150, 230, 160, 14);

        lbphoto.setText("Photo");
        getContentPane().add(lbphoto);
        lbphoto.setBounds(40, 190, 50, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btphotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btphotoActionPerformed

        JFileChooser jfc = new JFileChooser();

        int value = jfc.showOpenDialog(this);
        System.out.println(value);
        if (value == 0)
        {
            File selectedFile = jfc.getSelectedFile();
            lbpath.setText(selectedFile.getPath());
        }
    }//GEN-LAST:event_btphotoActionPerformed

    private void btaddcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddcategoryActionPerformed

        String C_name = tfcname.getText();
        String C_desc = tacdesc.getText();
        String filepath = lbpath.getText();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select*from category where c_name='" + C_name + "' ");

            if (rs.next())
            {
                JOptionPane.showMessageDialog(this, "already added");
            } else
            {
                rs.moveToInsertRow();
                rs.updateString("c_name", C_name);
                rs.updateString("c_desc", C_desc);
                rs.updateString("c_photo", filepath);
                rs.insertRow();
                JOptionPane.showMessageDialog(this, "category added successfully");
                tfcname.setText("");
                tacdesc.setText("");
                lbpath.setText("");
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btaddcategoryActionPerformed

    private void tfcnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcnameActionPerformed
    }//GEN-LAST:event_tfcnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btaddcategory;
    private javax.swing.JButton btphoto;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbdesc;
    private javax.swing.JLabel lbname;
    private javax.swing.JLabel lbpath;
    private javax.swing.JLabel lbphoto;
    private javax.swing.JLabel lbphotopath;
    private javax.swing.JTextArea tacdesc;
    private javax.swing.JTextField tfcname;
    // End of variables declaration//GEN-END:variables
}


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class EditCategory extends javax.swing.JInternalFrame {

    String catname;
    String desc;
    String photo;

    public EditCategory(String catname, String desc, String photo) {
        initComponents();
        this.catname = catname;
        this.desc = desc;
        this.photo = photo;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        tadesc.setText(this.desc);
        lbpath.setText(this.photo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tadesc = new javax.swing.JTextArea();
        lbphoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbpath = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        getContentPane().setLayout(null);

        jLabel3.setText("Description");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 40, 70, 14);

        jLabel4.setText("Photo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 150, 70, 14);

        tadesc.setColumns(20);
        tadesc.setLineWrap(true);
        tadesc.setRows(5);
        jScrollPane1.setViewportView(tadesc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(150, 20, 166, 96);
        getContentPane().add(lbphoto);
        lbphoto.setBounds(170, 130, 140, 70);

        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 220, 80, 23);
        getContentPane().add(lbpath);
        lbpath.setBounds(20, 220, 210, 30);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 280, 140, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser jfc = new JFileChooser();

        int value = jfc.showOpenDialog(this);
        System.out.println(value);
        if (value == 0) {
            File selectedFile = jfc.getSelectedFile();
            lbpath.setText(selectedFile.getPath());
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String desc = tadesc.getText();
        String Photo = lbphoto.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select*from category where c_name='" + this.catname + "'");
            if (rs.next()) {
                rs.updateString("C_desc", desc);
                rs.updateString("C_photo", Photo);
                rs.updateRow();
                JOptionPane.showMessageDialog(this, "Update Successfully");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbpath;
    private javax.swing.JLabel lbphoto;
    private javax.swing.JTextArea tadesc;
    // End of variables declaration//GEN-END:variables

}


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ViewWebsiteURL extends javax.swing.JInternalFrame {

    ArrayList<String> alWebsiteUrl = new ArrayList<String>();

    ArrayList<SingleUrl> alurls = new ArrayList<SingleUrl>();
    UrlModel model = new UrlModel();

    public ViewWebsiteURL() {
        initComponents();
        setTitle("View Website");
        setSize(700, 600);
        alWebsiteUrl.add("");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");

                    Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select*from category");

                    while (rs.next()) {
                        String C_name = rs.getString("C_name");
                        alWebsiteUrl.add(C_name);
                    }

                    cbcname.setModel(new javax.swing.DefaultComboBoxModel(alWebsiteUrl.toArray()));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        cbcname.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    String cname = cbcname.getSelectedItem().toString();
                    fetchWebsiteUrl(cname);
                }
            }
        });
        tbwebsiteurl.setModel(model);

    }

    private void fetchWebsiteUrl(String cname) {
        try {
            alurls.clear();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select*from website_url where c_name='" + cname + "'");

            while (rs.next()) {
                String wname = rs.getString("website name");
                String wurl = rs.getString("url");
                String urlid = rs.getString("url_id");

                SingleUrl singleUrl = new SingleUrl(wurl, wname, urlid);
                alurls.add(singleUrl);
            }

            model.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbwebsiteurl = new javax.swing.JTable();
        cbcname = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(tbwebsiteurl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 385, 130);
        getContentPane().add(cbcname);
        cbcname.setBounds(100, 20, 190, 30);

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(80, 240, 80, 23);

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(250, 240, 80, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int index = tbwebsiteurl.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Select A Row First");
        } else {
            SingleUrl c = alurls.get(index);
            String Websitename = c.websitename;
            String URl = c.url;
            String urlid = c.urlid;

            EditUrl ac = new EditUrl(urlid, URl, Websitename, cbcname.getSelectedItem().toString());
            ac.setSize(380, 400);
            this.getDesktopPane().add(ac);
            ac.setIconifiable(true);
            ac.setMaximizable(true);
            ac.setClosable(true);
            ac.setVisible(true);
            ac.moveToFront();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int index = tbwebsiteurl.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Select A Row First");
        } else {
            SingleUrl c = alurls.get(index);

            String url = c.url;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from website_url where url='" + url + "'     ");
                if (rs.next()) {
                    rs.deleteRow();
                    alurls.remove(index);
                    model.fireTableDataChanged();
                    JOptionPane.showMessageDialog(this, "Deleted successfully");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbcname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbwebsiteurl;
    // End of variables declaration//GEN-END:variables

    class SingleUrl {

        String url, websitename, urlid;

        public SingleUrl(String url, String websitename, String urlid) {
            this.url = url;
            this.websitename = websitename;
            this.urlid = urlid;
        }

    }

    class UrlModel extends AbstractTableModel {

        String colnames[]
                = {
                    "Sr.no", "Website name", "Url"
                };

        @Override
        public String getColumnName(int column) {
            return colnames[column]; //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getRowCount() {
            return alurls.size();
        }

        @Override
        public int getColumnCount() {
            return colnames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return rowIndex + 1;
            } else if (columnIndex == 1) {
                return alurls.get(rowIndex).websitename;
            } else if (columnIndex == 2) {
                return alurls.get(rowIndex).url;
            } else {
                return null;
            }
        }

    }

}

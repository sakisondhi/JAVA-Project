
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ViewCategories extends javax.swing.JInternalFrame
{

    ArrayList<Category> alcategories = new ArrayList<Category>();
    CategoryModel categoryModel = new CategoryModel();

    public ViewCategories()
    {
        initComponents();
        setTitle("View Category");
        setSize(700, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jTable1.setModel(categoryModel);
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
                        String cname = rs.getString("c_name");
                        String cdesc = rs.getString("c_desc");
                        String cphoto = rs.getString("c_photo");

                        Category c = new Category(cname, cdesc, cphoto);
                        alcategories.add(c);
                    }
                    categoryModel.fireTableDataChanged();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 10, 490, 250);

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 280, 90, 30);

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(430, 280, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index = jTable1.getSelectedRow();
        if (index == -1)
        {
            JOptionPane.showMessageDialog(this, "Select A Row First");
        } else
        {
            Category c = alcategories.get(index);

            String C_name = c.C_name;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from category where C_name='" + C_name + "'     ");
                if (rs.next())
                {
                    rs.deleteRow();
                    alcategories.remove(index);
                    categoryModel.fireTableDataChanged();
                    JOptionPane.showMessageDialog(this, "Deleted successfully");
                }
            } catch (Exception e)
            {

            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int index = jTable1.getSelectedRow();
        if (index == -1)
        {
            JOptionPane.showMessageDialog(this, "Select A Row First");
        } else
        {
            Category c = alcategories.get(index);
            String C_name = c.C_name;
            String C_desc = c.C_desc;
            String C_photo = c.C_photo;

            EditCategory ac = new EditCategory(C_name, C_desc, C_photo);
            ac.setSize(600, 500);
            this.getDesktopPane().add(ac);
            ac.setIconifiable(true);
            ac.setMaximizable(true);
            ac.setClosable(true);
            ac.setVisible(true);
            ac.moveToFront();
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    class Category
    {

        String C_name, C_desc, C_photo;

        public Category(String C, String d, String p)
        {
            this.C_name = C;
            this.C_desc = d;
            this.C_photo = p;
        }

    }

    class CategoryModel extends AbstractTableModel
    {

        String colnames[] =
        {
            "Sr.no", "Category name", "Category Description"
        };

        @Override
        public String getColumnName(int column)
        {
            return colnames[column]; //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getRowCount()
        {
            return alcategories.size();
        }

        @Override
        public int getColumnCount()
        {
            return colnames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {

            if (columnIndex == 0)
            {
                return rowIndex + 1;
            } else if (columnIndex == 1)
            {
                return alcategories.get(rowIndex).C_name;
            } else if (columnIndex == 2)
            {
                return alcategories.get(rowIndex).C_desc;
            }
            return null;
        }

    }

}

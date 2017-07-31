
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class userunsubscribecategories extends javax.swing.JInternalFrame
{

    Socket socket;
    String email;
    DataOutputStream dos;
    DataInputStream dis;

    String unsubcat = "";

    public userunsubscribecategories(Socket socket, String email)
    {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.socket = socket;
        this.email = email;

        try
        {
            if (socket != null)
            {
                dos = new DataOutputStream(socket.getOutputStream());
                dis = new DataInputStream(socket.getInputStream());
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                try
                {
                    dos.writeBytes("sendsubcategories\r\n");
                    dos.writeBytes(email + "\r\n");

                    String response = dis.readLine();
                    System.out.println(response);
                    showCheckboxes(response);

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

        }).start();

    }

    private void showCheckboxes(String response)
    {
        if (!response.equals("") && response.contains("~"))
        {
            String data[] = response.split("~");
            JCheckBox box;
            int y = 20;
            for (int i = 0; i < data.length; i++)
            {
                String text = data[i];
                box = new JCheckBox(data[i]);
                box.setBounds(20, y, 150, 20);
                jpcategories.add(box);
                box.setSelected(true);
                y = y + 30;
                jpcategories.repaint();

                box.addItemListener(new ItemListener()
                {

                    @Override
                    public void itemStateChanged(ItemEvent e)
                    {
                        if (e.getStateChange() == 1)
                        {
                            unsubcat = unsubcat.replace(text + "~", "");
                        } else if (e.getStateChange() == 2)
                        {
                            unsubcat = unsubcat + text + "~";
                        }
                    }
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jpcategories = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        javax.swing.GroupLayout jpcategoriesLayout = new javax.swing.GroupLayout(jpcategories);
        jpcategories.setLayout(jpcategoriesLayout);
        jpcategoriesLayout.setHorizontalGroup(
            jpcategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        jpcategoriesLayout.setVerticalGroup(
            jpcategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jpcategories);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 40, 350, 230);

        jButton1.setText("Unsubscribe");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 300, 200, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try
        {
            if (unsubcat.trim().equals(""))
            {
                JOptionPane.showMessageDialog(rootPane, "No category selected.....");
            } else
            {
                dos.writeBytes("deletecategory\r\n");
                dos.writeBytes(unsubcat + "\r\n");
                dos.writeBytes(email + "\r\n");

                String msg = dis.readLine();
                if (msg.equals("done"))
                {
                    jpcategories.removeAll();
                    jpcategories.repaint();

                    dos.writeBytes("sendsubcategories\r\n");
                    dos.writeBytes(email + "\r\n");
                    String response = dis.readLine();
                    showCheckboxes(response);
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpcategories;
    // End of variables declaration//GEN-END:variables
}

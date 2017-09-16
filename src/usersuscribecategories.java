
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class usersuscribecategories extends javax.swing.JInternalFrame
{

    Socket socket;
    
    
    String email;

    DataOutputStream dos;
    DataInputStream dis;

    String subcategory = "";

    public usersuscribecategories(Socket socket, String email)
    {
        initComponents();
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try
        {
            this.socket = socket;
            this.email = email;
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
                    dos.writeBytes("sendcategory\r\n");
                    dos.writeBytes(email + "\r\n");

                    String response = dis.readLine();
                    showCheckboxes(response);

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
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
                        y = y + 30;
                        jpcategories.repaint();

                        box.addItemListener(new ItemListener()
                        {

                            @Override
                            public void itemStateChanged(ItemEvent e)
                            {
                                if (e.getStateChange() == 1)
                                {
                                    subcategory = subcategory + text + "~";
                                } else if (e.getStateChange() == 2)
                                {
                                    subcategory = subcategory.replace(text + "~", "");
                                }
                            }
                        });
                    }
                }
            }
        }).start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jpcategories = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(350, 350));

        jpcategories.setOpaque(false);
        jpcategories.setPreferredSize(new java.awt.Dimension(348, 500));
        jpcategories.setLayout(null);
        jScrollPane1.setViewportView(jpcategories);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 30, 350, 220);

        jButton1.setText("Subscribe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 270, 140, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try
        {
            if (subcategory.trim().equals(""))
            {
                JOptionPane.showMessageDialog(rootPane, "No category selected.....");
            } else
            {
                dos.writeBytes("savecategory\r\n");
                dos.writeBytes(subcategory + "\r\n");
                dos.writeBytes(email + "\r\n");

                String msg = dis.readLine();
                if (msg.equals("done"))
                {
                    jpcategories.removeAll();
                    jpcategories.repaint();
                    dos.writeBytes("sendcategory\r\n");
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
                y = y + 30;
                jpcategories.repaint();

                box.addItemListener(new ItemListener()
                {

                    @Override
                    public void itemStateChanged(ItemEvent e)
                    {
                        if (e.getStateChange() == 1)
                        {
                            subcategory = subcategory + text + "~";
                        } else if (e.getStateChange() == 2)
                        {
                            subcategory = subcategory.replace(text + "~", "");
                        }
                    }
                });
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpcategories;
    // End of variables declaration//GEN-END:variables
}

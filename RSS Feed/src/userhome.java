
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import vmm.App;

public class userhome extends javax.swing.JFrame {

    Socket socket;
    String email;

    DataOutputStream dos;
    DataInputStream dis;

    public userhome(Socket socket, String email) {
        initComponents();
        this.socket = socket;
        this.email = email;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jpallnews.setSize(500, 500);
        setSize(700, 600);
        setTitle("User Home");
        if (socket != null) {
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        new Thread(new FetchNews()).start();

    }

    class FetchNews implements Runnable {

        @Override
        public void run() {
            try {
                isFetching = true;
                jpallnews.removeAll();
                jpallnews.repaint();
                dos.writeBytes("sendnews\r\n");
                dos.writeBytes(email + "\r\n");

                String response = dis.readLine();

                if (response.equals("nourl")) {
                    JOptionPane.showMessageDialog(rootPane, "No category subscribed");
                } else if (response.equals("receiveurl")) {
                    int size = dis.readInt();
                    ArrayList<String> alurl = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        alurl.add(dis.readLine());
                    }
                    response = dis.readLine();

                    fetchNews(alurl);
                }
                isFetching = false;
            } catch (Exception e) {
                isFetching = false;
                e.printStackTrace();
            }

        }

    }

    private void fetchNews(ArrayList<String> newslist) {
        try {
            int count = 0;
            for (int i = 0; i < newslist.size(); i++) {
                String s = newslist.get(i);
                App app = new App();
                SyndFeed feed = app.writenews(s);
                List<SyndEntry> list1 = (List<SyndEntry>) feed.getEntries();
                count = count + list1.size();
            }

            int panelheight = count * 430;
            int panelwidth = 400;
            Dimension d = new Dimension(panelwidth, panelheight);
            jpallnews.setPreferredSize(d);
            jpallnews.repaint();
            int y = 20;

            for (int i = 0; i < newslist.size(); i++) {
                String s = newslist.get(i);
                App app = new App();
                SyndFeed feed = app.writenews(s);

                List<SyndEntry> list1 = (List<SyndEntry>) feed.getEntries();

                for (int j = 0; j < list1.size(); j++) {
                    String title = list1.get(j).getTitle();
                    String link = list1.get(j).getLink();
                    Date pubdate = list1.get(i).getPublishedDate();
                    String desc = list1.get(i).getDescription().toString();
                    SingleNewsPanel newsPanel;
                    newsPanel = new SingleNewsPanel();
                    newsPanel.lblink.setText(link);
                    newsPanel.lblink.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (e.getClickCount() == 2) {
                                try {
                                    Desktop d = Desktop.getDesktop();
                                    URI uri = new URI(link);
                                    d.browse(uri);
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(rootPane, "Unable to open this news at this time!!");
                                }
                            }
                        }
                    });
                    newsPanel.lbtitle.setText(title);
                    if (pubdate != null) {
                        newsPanel.lbpubdate.setText(pubdate.toString());
                    } else {
                        newsPanel.lbpubdate.setText(new Date().toString());
                    }
                    if (desc.contains("value=")) {
                        String desc1 = desc.substring(desc.indexOf("value=") + 6);
                        newsPanel.editorpanenews.setContentType("text/html");
                        newsPanel.editorpanenews.setText(desc1);
                    } else {
                        newsPanel.editorpanenews.setContentType("text/html");
                        newsPanel.editorpanenews.setText(desc);
                    }

                    System.out.println(desc);
                    System.out.println("**********************************");
                    newsPanel.setBounds(20, y, 400, 400);
                    y = y + 400 + 15;
                    jpallnews.add(newsPanel);
                    jpallnews.repaint();
                }

            }
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpallnews = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(443, 350));

        jpallnews.setPreferredSize(new java.awt.Dimension(550, 3500));

        javax.swing.GroupLayout jpallnewsLayout = new javax.swing.GroupLayout(jpallnews);
        jpallnews.setLayout(jpallnewsLayout);
        jpallnewsLayout.setHorizontalGroup(
            jpallnewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );
        jpallnewsLayout.setVerticalGroup(
            jpallnewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3500, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jpallnews);

        jDesktopPane1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 40, 610, 430);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton1);
        jButton1.setBounds(20, 3, 190, 30);

        jMenu1.setText("User");

        jMenuItem1.setText("Change Password");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Subscribe");

        jMenuItem2.setText("Subscribe category");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Unsubscribe");

        jMenuItem3.setText("Unsubscribe Category");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        userchangepassword ac = new userchangepassword(socket, email);
        ac.setSize(380, 400);
        jDesktopPane1.add(ac);
        ac.setIconifiable(true);
        ac.setMaximizable(true);
        ac.setClosable(true);
        ac.setVisible(true);
        ac.moveToFront();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        usersuscribecategories ac = new usersuscribecategories(socket, email);
        ac.setSize(380, 400);
        jDesktopPane1.add(ac);
        ac.setIconifiable(true);
        ac.setMaximizable(true);
        ac.setClosable(true);
        ac.setVisible(true);
        ac.moveToFront();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        userunsubscribecategories ac = new userunsubscribecategories(socket, email);
        ac.setSize(380, 400);
        jDesktopPane1.add(ac);
        ac.setIconifiable(true);
        ac.setMaximizable(true);
        ac.setClosable(true);
        ac.setVisible(true);
        ac.moveToFront();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    boolean isFetching = false;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (isFetching == false) {
            new Thread(new FetchNews()).start();
        } else {
            JOptionPane.showMessageDialog(this, "Already fetching");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(System.currentTimeMillis());

        System.out.println(new Date(System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpallnews;
    // End of variables declaration//GEN-END:variables

    private void embedNewsToJPanel(String title, String link, int y) {
        SingleNewsPanel newsPanel;

        newsPanel = new SingleNewsPanel();
        newsPanel.lblink.setText(link);
        newsPanel.lbtitle.setText(title);
        newsPanel.setBounds(20, y, 400, 243);

        jpallnews.add(newsPanel);
        jpallnews.repaint();
    }

    class SingleNewsPanel extends javax.swing.JPanel {

        public SingleNewsPanel() {
            initComponents();
            editorpanenews.setEditable(false);
            editorpanenews.setFocusable(false);
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            lbtitle = new javax.swing.JLabel();
            lblink = new javax.swing.JLabel();
            lbpubdate = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            editorpanenews = new javax.swing.JEditorPane();

            setLayout(null);

            jPanel1.setLayout(null);
            jPanel1.add(lbtitle);

            lbtitle.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
            lbtitle.setForeground(new java.awt.Color(0, 153, 153));
            jPanel1.add(lbtitle);
            lbtitle.setBounds(10, 10, 360, 30);

            lblink.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
            lblink.setForeground(new java.awt.Color(0, 153, 153));
            jPanel1.add(lblink);
            lblink.setBounds(10, 50, 360, 30);

            lbpubdate.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
            lbpubdate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            jPanel1.add(lbpubdate);
            lbpubdate.setBounds(10, 90, 360, 30);

            add(jPanel1);
            jPanel1.setBounds(10, 10, 380, 90);

            jScrollPane1.setViewportView(editorpanenews);

            add(jScrollPane1);
            jScrollPane1.setBounds(10, 110, 380, 120);
        }// </editor-fold>                        

        // Variables declaration - do not modify                     
        public javax.swing.JEditorPane editorpanenews;
        public javax.swing.JPanel jPanel1;
        public javax.swing.JScrollPane jScrollPane1;
        public javax.swing.JLabel lblink;
        public javax.swing.JLabel lbpubdate;
        public javax.swing.JLabel lbtitle;
        // End of variables declaration                   
    }

}

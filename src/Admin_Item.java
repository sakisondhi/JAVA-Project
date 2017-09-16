
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Admin_Item extends javax.swing.JFrame {

    public Admin_Item() {
        initComponents();
        setSize(700, 600);
        jDesktopPane1.setSize(700, 600);
        setTitle("Admin Home");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        MyServer ms = new MyServer();
        Thread t1 = new Thread(ms);
        t1.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu3.setText("jMenu3");

        jMenuItem5.setText("jMenuItem5");

        jMenu4.setText("jMenu4");

        jMenuItem6.setText("jMenuItem6");

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jDesktopPane1.setBackground(new java.awt.Color(248, 248, 255));
        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 400, 280);

        jMenu1.setText("Add");

        jMenuItem1.setText("Add Category");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Add website url");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");

        jMenuItem2.setText("View Category");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setText("View Website url");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Others");

        jMenuItem7.setText("Change Password");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Add_Category ac = new Add_Category();
        ac.setSize(600, 500);
        jDesktopPane1.add(ac);
        ac.setIconifiable(true);
        ac.setMaximizable(true);
        ac.setClosable(true);
        ac.setVisible(true);
        ac.moveToFront();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        ViewCategories ac = new ViewCategories();
        ac.setSize(600, 500);
        jDesktopPane1.add(ac);
        ac.setIconifiable(true);
        ac.setMaximizable(true);
        ac.setClosable(true);
        ac.setVisible(true);
        ac.moveToFront();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        AddWebsiteURL ac = new AddWebsiteURL();
        ac.setSize(600, 500);
        jDesktopPane1.add(ac);
        ac.setIconifiable(true);
        ac.setMaximizable(true);
        ac.setClosable(true);
        ac.setVisible(true);
        ac.moveToFront();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ViewWebsiteURL url = new ViewWebsiteURL();
        url.setSize(600, 500);
        jDesktopPane1.add(url);
        url.setIconifiable(true);
        url.setClosable(true);
        url.setVisible(true);
        url.moveToFront();

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        AdminChangePassword ac1 = new AdminChangePassword();
        ac1.setSize(600, 500);
        jDesktopPane1.add(ac1);
        ac1.setIconifiable(true);
        ac1.setMaximizable(true);
        ac1.setClosable(true);
        ac1.setVisible(true);
        ac1.moveToFront();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Item().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration//GEN-END:variables

    public class MyServer implements Runnable {

        ServerSocket sersock;

        @Override
        public void run() {
            try {

                sersock = new ServerSocket(4200);
                System.out.println("SERVER SOCKET STARTED");
                while (true) {
                    Socket sock = sersock.accept();
                    ClientHandler ch = new ClientHandler(sock);
                    Thread t = new Thread(ch);
                    t.start();
                    System.out.println("CONNECTION ACCEPTED");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class ClientHandler implements Runnable {

        Socket sock;
        DataInputStream dis;
        DataOutputStream dos;

        public ClientHandler(Socket socket) {
            this.sock = socket;
        }

        public void run() {
            try {
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());
                while (true) {
                    String s = dis.readLine();
                    System.out.println(s);
                    if (s.equals("signup")) {
                        String user = dis.readLine();
                        String password = dis.readLine();
                        String sec_ques = dis.readLine();
                        String sec_ans = dis.readLine();
                        String phone_no = dis.readLine();
                        signup(user, password, sec_ques, sec_ans, phone_no);
                    } else if (s.equals("login")) {
                        String email = dis.readLine();
                        String password = dis.readLine();
                        checkLogin(email, password);
                    } else if (s.equals("forgotpassword")) {
                        String email = dis.readLine();
                        getSecQues(email);
                    } else if (s.equals("forgotpassword1")) {
                        String email = dis.readLine();
                        String answer = dis.readLine();
                        getPassword(email, answer);
                    } else if (s.equals("changepassword")) {
                        String email = dis.readLine();
                        String oldpassword = dis.readLine();
                        checkOldPassword(email, oldpassword);
                    } else if (s.equals("changepassword1")) {
                        String email = dis.readLine();
                        String oldpassword = dis.readLine();
                        String newpassword = dis.readLine();
                        changePassword(email, oldpassword, newpassword);
                    } else if (s.equals("sendcategory")) {
                        String email = dis.readLine();
                        sendCategory(email);
                    } else if (s.equals("savecategory")) {
                        String subcategory = dis.readLine();
                        String email = dis.readLine();
                        saveCategory(subcategory, email);
                    } else if (s.equals("sendsubcategories")) {
                        String email = dis.readLine();
                        sendSubCategory(email);
                    } else if (s.equals("deletecategory")) {
                        String unsubcategory = dis.readLine();
                        String email = dis.readLine();
                        deleteCategory(unsubcategory, email);
                    } else if (s.equals("sendnews")) {
                        String email = dis.readLine();
                        sendNews(email);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        private void signup(String user, String password, String sec_ques, String sec_ans, String phone_no) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from userdetail where email='" + user + "'");
                if (rs.next()) {
                    dos.writeBytes("fail\r\n");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("email", user);
                    rs.updateString("password", password);
                    rs.updateString("sec_ques", sec_ques);
                    rs.updateString("sec_ans", sec_ans);
                    rs.updateString("phone_no", phone_no);
                    rs.insertRow();
                    dos.writeBytes("success\r\n");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void checkLogin(String email, String password) {
            try {
                System.out.println(email);
                System.out.println(password);
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from userdetail where email='" + email + "' and password='" + password + "'");
                if (rs.next()) {
                    dos.writeBytes("loginsuccess\r\n");
                } else {
                    dos.writeBytes("loginfail\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        private void getSecQues(String email) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from userdetail where email='" + email + "'");

                if (rs.next()) {
                    String secque = rs.getString("sec_ques");
                    dos.writeBytes("fpsuccess\r\n");
                    dos.writeBytes(secque + "\r\n");
                } else {
                    dos.writeBytes("fpfail\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void getPassword(String email, String answer) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from userdetail where email='" + email + "' and sec_ans='" + answer + "'");

                if (rs.next()) {
                    String password = rs.getString("password");
                    dos.writeBytes("fp1success\r\n");
                    dos.writeBytes(password + "\r\n");
                } else {
                    dos.writeBytes("fp1fail\r\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        private void checkOldPassword(String email, String oldpassword) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from userdetail where email='" + email + "' and password='" + oldpassword + "'");

                if (rs.next()) {
                    dos.writeBytes("successCP\r\n");
                } else {
                    dos.writeBytes("failCP\r\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        private void changePassword(String email, String oldpassword, String newpassword) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from userdetail where email='" + email + "' and password='" + oldpassword + "'");
                if (rs.next()) {
                    rs.updateString("password", newpassword);
                    rs.updateRow();
                    dos.writeBytes("passwordchanged\r\n");
                } else {
                    dos.writeBytes("passwordnotchanged\r\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void sendCategory(String email) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from category where c_name "
                        + "not in (select cname from subscribe where user='" + email + "')");

                String categories = "";

                while (rs.next()) {
                    String cname = rs.getString("c_name");
                    categories = categories + cname + "~";
                }

                dos.writeBytes(categories + "\r\n");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void saveCategory(String subcategory, String email) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String allsubcategories[] = subcategory.split("~");
                for (int i = 0; i < allsubcategories.length; i++) {
                    String allsubcategory = allsubcategories[i];
                    ResultSet rs = stmt.executeQuery("select*from subscribe "
                            + "where cname='" + allsubcategory + "'"
                            + " and user='" + email + "'");
                    if (!rs.next()) {
                        rs.moveToInsertRow();
                        rs.updateString("user", email);
                        rs.updateString("cname", allsubcategory);
                        rs.insertRow();
                    }
                }
                dos.writeBytes("done\r\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void sendSubCategory(String email) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from subscribe where user='" + email + "'");
                String categories = "";
                while (rs.next()) {
                    String cname = rs.getString("cname");
                    categories = categories + cname + "~";
                }
                dos.writeBytes(categories + "\r\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void deleteCategory(String unsubcategory, String email) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String allsubcategories[] = unsubcategory.split("~");
                for (int i = 0; i < allsubcategories.length; i++) {
                    String allsubcategory = allsubcategories[i];
                    ResultSet rs = stmt.executeQuery("select*from subscribe "
                            + "where cname='" + allsubcategory + "'"
                            + " and user='" + email + "'");
                    if (rs.next()) {
                        rs.deleteRow();
                    }
                    rs.close();
                }
                dos.writeBytes("done\r\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void sendNews(String email) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select*from subscribe where user='" + email + "'");

                String categories = "";
                while (rs.next()) {
                    String cname = rs.getString("cname");
                    categories = categories + cname + "~";
                }

                fetchUrl(categories);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void fetchUrl(String categories) {
            String data[] = categories.split("~");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rss_feed", "root", "system");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ArrayList<String> alurl = new ArrayList<>();
                for (int i = 0; i < data.length; i++) {
                    String data1 = data[i];
                    ResultSet rs = stmt.executeQuery("select*from website_url where c_name='" + data1 + "'");
                    if (rs.next()) {
                        alurl.add(rs.getString("url"));
                    }
                    rs.close();
                }

                if (alurl.size() > 0) {
                    dos.writeBytes("receiveurl\r\n");
                    dos.writeInt(alurl.size());
                    for (int i = 0; i < alurl.size(); i++) {
                        dos.writeBytes(alurl.get(i) + "\r\n");
                    }
                    dos.writeBytes("doneurl\r\n");
                } else {
                    dos.writeBytes("nourl\r\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

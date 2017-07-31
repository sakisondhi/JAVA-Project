/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VMM-63
 */
public class SingleNewsPanel extends javax.swing.JPanel
{

    public SingleNewsPanel()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        lbtitle = new javax.swing.JLabel();
        lblink = new javax.swing.JLabel();
        lbpubdate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorpanenews = new javax.swing.JEditorPane();

        setLayout(null);

        jPanel1.setLayout(null);

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
        jPanel1.setBounds(10, 10, 380, 140);

        editorpanenews.setEditable(false);
        jScrollPane1.setViewportView(editorpanenews);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 180, 380, 120);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane editorpanenews;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblink;
    private javax.swing.JLabel lbpubdate;
    private javax.swing.JLabel lbtitle;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Arrow;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author Hosam
 */
public class SplashScreen extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        try {
            initComponents();
            setVisible(true);
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            mainImageLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\intech.png"));
            Thread launchSplash = new Thread(this);
            launchSplash.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runningProgressBar() {
        int i = 0;
        while (i <= 100) {
            try {
                Thread.sleep(30);
                progressBar.setValue(i);
                progressBar.setToolTipText("LOADING... " + Integer.toString(i) + "%");
                message.setText("LOADING... " + Integer.toString(i) + "%");
                message.validate();
                message.repaint();
                i++;
                if (i == 100) {
                    dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainImageLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hosam Mukhairez (Line Rotator) - Intech");
        setResizable(false);
        getContentPane().setLayout(null);

        mainImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(mainImageLabel);
        mainImageLabel.setBounds(60, 0, 300, 100);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Welcome to Project (Line Rotator)");
        getContentPane().add(titleLabel);
        titleLabel.setBounds(20, 110, 380, 30);

        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(message);
        message.setBounds(0, 140, 430, 40);
        getContentPane().add(progressBar);
        progressBar.setBounds(0, 140, 430, 40);

        setSize(new java.awt.Dimension(445, 221));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel mainImageLabel;
    private javax.swing.JLabel message;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            runningProgressBar();
            Thread startFrame = new Thread(new MainFrame());
            startFrame.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
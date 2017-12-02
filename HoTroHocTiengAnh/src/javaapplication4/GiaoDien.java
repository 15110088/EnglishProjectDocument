/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import AppPackage.AnimationClass;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URI;
import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author nghia
 */
public class GiaoDien {

    static JFrame frm;
    static Theme a = new Theme();
    JMenuBar mb;
    JButton btn1, btn2;
    JLabel lbn1, lbn2, lbn3, lbn5, lbn6, lbn7;
    public static JLabel lbn4 = new JLabel();
    JPanel pnl1, pnl2;
    Timer tm;
    AnimationClass AC = new AnimationClass();

    class ThreadDemo extends Thread {
        String[] anh = {"tieudexanh.jpg", "tieude.jpg", "tieudedo.jpg", "tieudevang.jpg", "tieudehong.jpg"};
        String[] anh1 = {"giaodien/1.jpg", "giaodien/2.jpg", "giaodien/3.jpg"};
        @Override
        public void run() {
            Random rand = new Random();

            try {
                for (int i = 0; i < 5; i++) {
                    int a = rand.nextInt(5);
                    int b = rand.nextInt(3);
                    setPic(lbn2, anh[a], 170, 50);
                    setPic(lbn4, anh1[b], 180, 338);
                    Thread.sleep(1000);
                    i = 0;
                }
            } catch (InterruptedException e) {
            }

        }

    }

    public GiaoDien() {
        ThreadDemo t = new ThreadDemo();
        t.start();

        //sildeshow();
    }
    static ImageIcon icon = new ImageIcon("MSM.jpg");

    public static void main(String[] args) {
        GiaoDien a = new GiaoDien();
        a.giaodien1();

    }

    public void giaodien1() {
        // khoi tao 
        frm = new JFrame();

        btn1 = new JButton();
        btn2 = new JButton();

        lbn1 = new JLabel();
        lbn2 = new JLabel();
        lbn3 = new JLabel();
        lbn5 = new JLabel();

        setPic(lbn1, "nen.jpg", 700, 500);
        setPic(lbn2, "tieude.jpg", 100, 50);
        setPic(lbn3, "btn//start.png", 100, 100);

        // chinh thong tin 
        frm.setSize(700, 500);

        btn1.setBounds(0, 65, 90, 30);
        btn2.setBounds(630, 70, 30, 30);
        setButton(btn2, "btn//exit.png", 30, 30);
        setButton(btn1, "btn//exit.png", 90, 30);
        btn2.setBorderPainted(false);

        lbn1.setBounds(0, 0, 700, 500);
        lbn2.setBounds(500, 30, 170, 30);
        lbn3.setBounds(300, 250, 100, 100);
        lbn4.setBounds(24, 65, 180, 338);

        setButton(lbn3, "btn//start.png", "btn//start.png", "btn//start2.png", 100, 100);

        lbn1.add(lbn2);

        lbn1.add(lbn3);
        lbn1.add(lbn4);
        //lbn1.add(btn1);      
        lbn1.add(btn2);

        frm.setUndecorated(true);
        frm.setLocation(200, 100);
        //chinh layout

        frm.setLayout(null);
        btn1.setLayout(null);
        lbn1.setLayout(null);
        lbn2.setLayout(null);
        lbn4.setLayout(null);
        lbn5.setLayout(null);

        //add 
        frm.add(lbn1);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI("https://www.facebook.com/n0410"));
                } catch (Exception ex) {
                    ex.printStackTrace();

                }

            }
        });

    }

    public static void setPic(JLabel lbn, String file, int dx, int dy) {
        try {
            BufferedImage image = ImageIO.read(new File(file));
            int x = lbn.getSize().width;
            int y = lbn.getSize().height;

            //  System.out.println(""+ix+" "+iy);
            ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
            lbn.setIcon(icon);
        } catch (Exception e) {
        }

    }

    public static void setButton(JButton lbn, String file, int dx, int dy) {
        try {
            BufferedImage image = ImageIO.read(new File(file));

            //  System.out.println(""+ix+" "+iy);
            ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
            lbn.setIcon(icon);
        } catch (Exception e) {
        }

    }

    public static void setButton(JLabel btn, String file1, String file2, String file3, int dx, int dy) {
        int x = btn.getSize().width;
        int y = btn.getSize().height;
        //  System.out.println(""+ix+" "+iy);

        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {// khi click
                try {
                    BufferedImage image = ImageIO.read(new File(file1));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                    btn.setIcon(icon);

                    a.frm1.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {//  nhan giữ
                try {

                    BufferedImage image = ImageIO.read(new File(file3));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                    btn.setIcon(icon);

                } catch (IOException ex) {
                    Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {// thả ra 
                try {
                    BufferedImage image = ImageIO.read(new File(file1));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                    btn.setIcon(icon);
                } catch (IOException ex) {
                    Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {//khi rê chuột vào nút
                try {
                    BufferedImage image = ImageIO.read(new File(file2));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                    btn.setIcon(icon);
                } catch (IOException ex) {
                    Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {// khi rê chuột khỏi nút
                try {
                    BufferedImage image = ImageIO.read(new File(file1));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                    btn.setIcon(icon);
                } catch (IOException ex) {
                    Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import static javaapplication4.GiaoDien.a;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author nghia
 */
public class Theme implements ActionListener {

    JFrame frm1 = new JFrame();

    JButton btn1, btn2, btn3, btn4, btn5, btnstart, btnsubmit,btnxemkq;

    JLabel lbn1, lbn2, lbn3, lbn5, lbn6, lbn7, lbn8, lbntuvung, lbnThoiGian, lbnsocau;

    JComboBox LuaChonCau;
    Hashtable table, table2;
    Enumeration names, names2;
    int point;
    String BienLuu2;
    SuLuDuLieu dl = new SuLuDuLieu();
    String[] chuoi;
    JTextField txt1;
    Timer timer;
    String path;
    public int dung = 0, sai = 0;//Cho biet đúng sai
    public int p, pp = 10;// thoi gian cua dong ho 
    int demluot;
    int mode = 1; // Che do choi (1 : Luyen Tap, 2 : Thu Thach)
    public Clip clip;
    public URL url;

    public Theme() {
        giaodien();
        playSound(0);
    }

    public void giaodien() {
        // khoi tao  

        lbn1 = new JLabel();// nen  
        lbn2 = new JLabel(); // ban tu vung
        lbn3 = new JLabel();// bang diem

        lbn5 = new JLabel();// next
        lbn6 = new JLabel();// goi y 
        lbn7 = new JLabel();// rank 
        lbn8 = new JLabel("0 Điểm");// O diem
        LuaChonCau = new JComboBox();
        lbnThoiGian = new JLabel("0");// O s
        lbntuvung = new JLabel();

        btn1 = new JButton("Open File");
        btn2 = new JButton("Luyện Tập");
        btn3 = new JButton("Thử Thách");
        btn4 = new JButton("Reset");
        btn5 = new JButton("Exit");
        btnsubmit = new JButton("Submit");

        txt1 = new JTextField();
        // chinh thong tin 

        frm1.setSize(700, 500);

        lbn1.setBounds(0, 0, 700, 505);// nen
        setPic(lbn1, "theme//nen.jpg", 700, 505);
        lbn2.setBounds(50, 150, 400, 200);// ban tu vung
        setPic(lbn2, "theme//tuvung.png", 400, 200);
        lbn3.setBounds(480, 150, 150, 260);
        setPic(lbn3, "theme//diem.png", 150, 260);
        // lbn5.setBounds(260, 400, 90, 30);
        lbn5.setBounds(313, 160, 80, 36);
        //
        setPic(lbn5, "btn//4.jpg", 80, 36);
        lbn6.setBounds(100, 360, 40, 30);
        setPic(lbn6, "btn//7.png", 40, 30);
        lbn7.setBounds(10, 10, 130, 70);
        setPic(lbn7, "diem//rank.jpg", 130, 70);
        lbn8.setBounds(40, 80, 100, 70);
        lbn8.setFont(new Font("Tomato", 0, 20));
        lbn8.setForeground(Color.CYAN);
        lbntuvung.setBounds(170, 50, 200, 100);// ban tu vung
        lbntuvung.setFont(new Font("Tomato", Font.PLAIN, 30));
        lbntuvung.setForeground(Color.RED);
        lbnThoiGian.setBounds(68, 155, 50, 50);
        lbnThoiGian.setFont(new Font("Tomato", 0, 20));
        lbnThoiGian.setForeground(Color.RED);

        btn1.setBackground(new Color(33, 150, 243));
        btn1.setBounds(50, 50, 100, 60);
        btn1.setFont(new Font("Tomato", Font.BOLD, 13));
        btn1.setForeground(Color.WHITE);

        btn2.setBackground(new Color(103, 58, 183));
        btn2.setBounds(170, 50, 100, 60);
        btn2.setFont(new Font("Tomato", Font.BOLD, 12));
        btn2.setForeground(Color.WHITE);

        btn3.setBackground(new Color(233, 30, 99));
        btn3.setBounds(290, 50, 100, 60);
        btn3.setFont(new Font("Tomato", Font.BOLD, 12));
        btn3.setForeground(Color.WHITE);

        btn4.setBackground(new Color(255, 152, 0));
        btn4.setBounds(410, 50, 100, 60);
        btn4.setFont(new Font("Tomato", Font.BOLD, 13));
        btn4.setForeground(Color.WHITE);

        btn5.setBackground(new Color(0, 200, 83));
        btn5.setBounds(530, 50, 100, 60);
        btn5.setFont(new Font("Tomato", Font.BOLD, 13));
        btn5.setForeground(Color.WHITE);

        btnsubmit.setBounds(365, 355, 80, 36);
        btnsubmit.setBackground(Color.decode("#bd7143"));
        btnsubmit.setFont(new Font("Tomato", Font.BOLD, 12));
        btnsubmit.setForeground(Color.WHITE);

        btnsubmit.addActionListener(this);

        LuaChonCau.setBounds(325, 165, 70, 30);
        LuaChonCau.addItem("5 cau");
        LuaChonCau.addItem("10 cau");
        LuaChonCau.addItem("20 cau");
        LuaChonCau.addActionListener(this);
        LuaChonCau.setVisible(false);
        LuaChonCau.getEditor().setItem("Choose");

        btnstart = new JButton("Start");
        btnstart.setBounds(200, 220, 95, 50);
        btnstart.setBackground(Color.decode("#bd7143"));
        btnstart.setFont(new Font("Tomato", Font.BOLD, 12));
        btnstart.setForeground(Color.WHITE);
        btnstart.setVisible(false);
        btnstart.addActionListener(this);
        
       

        lbnsocau = new JLabel("00");
        lbnsocau.setBounds(405, 160, 37, 34);
        lbnsocau.setBackground(Color.decode("#9db7b5"));
        lbnsocau.setHorizontalAlignment(JLabel.CENTER);
        lbnsocau.setFont(new Font("Tomato", Font.BOLD, 12));
        lbnsocau.setForeground(Color.red);
        lbnsocau.setOpaque(true);
        lbnsocau.setVisible(false);

        txt1.setBounds(150, 360, 200, 30);

        lbn1.add(btnstart);
        lbn1.add(lbnsocau);
        lbn1.add(btn1);
        lbn1.add(btn2);
        lbn1.add(btn3);
        lbn1.add(btn4);
        lbn1.add(btn5);
        lbn1.add(btnsubmit);
        lbn2.add(lbntuvung);
        lbn2.add(LuaChonCau);
        lbn2.add(lbn5);

        lbn1.add(lbn2);
        lbn1.add(lbn3);
        //  lbn1.add(lbn5);
        lbn1.add(lbn6);

        lbn3.add(lbn7);
        lbn3.add(lbn8);
        lbn3.add(lbnThoiGian);

        setButtonOK(lbn5, "btn//4.jpg", "btn//5.jpg", "btn//6.jpg", 80, 36);// nextt
        setButton(lbn6, "btn//7.png", "btn//7.png", "btn//8.png", 40, 30);// goi y 

        lbn1.add(txt1);
        //chinh layout

        frm1.setLayout(null);
        lbn3.setLayout(null);
        lbn1.setLayout(null);
        frm1.setBackground(new Color(63, 191, 65));
        //add 

        btn2.setEnabled(false);
        btn3.setEnabled(false);
        frm1.add(lbn1);

        frm1.setUndecorated(true);
        frm1.setLocation(200, 100);
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frm1.setVisible(true);

        //event
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        //;

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

    public void setButtonOK(JLabel btn, String file1, String file2, String file3, int dx, int dy) {
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

                    random();
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

    public void setButtonNext(JLabel btn, String file1, String file2, String file3, int dx, int dy) {
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
                
                    check();
                    
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

    public void random() {

        Random rand = new Random();
        int ex = dl.DemSoTu / 2 - 1;
        int tunhien = rand.nextInt(ex) + dl.DemSoTu / 2 + 1;
        lbntuvung.setText("" + table.get(chuoi[tunhien]));
        BienLuu2 = table.get(chuoi[tunhien]).toString();
    }

    public void check() {
        if (mode == 2 && (pp - demluot) == 1) {
            btnsubmit.setEnabled(false);//fix bug
        }
        if (txt1.getText().equals(table2.get(BienLuu2).toString())) {
            System.out.println(txt1.getText());
            System.out.println(table2.get(BienLuu2).toString());
            point++;
            lbn8.setText(point + " Điểm");
            txt1.setText("");
            dung++;
            System.out.println("dung");
            if (mode == 1) {
                clip.stop();
                playSound(3);
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
                }
                clip.stop();
            }

        } else {
            System.out.println(txt1.getText());
            System.out.println(table2.get(BienLuu2).toString());
            System.out.println("Sai");
            if (point != 0) {
                point--;
                lbn8.setText(point + " Điểm");
            }
            if (mode == 1) {
                clip.stop();
                playSound(2);
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
                }
                clip.stop();
            }
        }
        if (mode == 2) {
            System.out.println(url);
            clip.stop();
            playSound(3);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
            }
            clip.stop();
            playSound(4);
            demluot++;  // luu lai so cau da tra loi
            p = 10;   //chay timer lai
            lbnsocau.setText("" + (pp - demluot));
        }//Cho timer chay lai   
        random();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Thoigianchay a = new Thoigianchay();
        if (e.getSource() == btn1) {

            JFileChooser file = new JFileChooser();
            int value = file.showOpenDialog(null);
            try {

                String ten = file.getSelectedFile().getName();
                String dir = file.getCurrentDirectory().toString();
                path = dir + "\\" + ten;
            } catch (Exception e1) {
                int dialogButton = JOptionPane.INFORMATION_MESSAGE;
                JOptionPane.showMessageDialog(null, "Loi Duong Dan", "Congratulations", dialogButton);
            }

            System.out.println(path);
            try {

                dl.read(path);
                String d = dl.c.concat(dl.b);
                chuoi = d.split(" ");
                table = new Hashtable();
                table2 = new Hashtable();
                System.out.println(d);
                
                for (int i = 1; i < dl.DemSoTu / 2; i++) {
                    table.put(chuoi[(dl.DemSoTu / 2) + i], chuoi[i]);
                }

                for (int i = 1; i < dl.DemSoTu / 2; i++) {
                    table2.put(chuoi[i], chuoi[(dl.DemSoTu / 2) + i]);
                }
                names = table.keys();
                names2 = table2.keys();
                while (names.hasMoreElements()) {
                    String str = (String) names.nextElement();
                    System.out.println(str + ": "
                            + table.get(str));
                }
                while (names2.hasMoreElements()) {
                    String str = (String) names2.nextElement();
                    System.out.println(str + ": "
                            + table2.get(str));
                }

                random();
                btn3.setEnabled(true);

            } catch (IOException ex) {
                // Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == btn2) {//nut Luyen Tap
            clip.stop();
            playSound(0);
            random();
            mode = 1;
            btnsubmit.setEnabled(true);
            btn3.setEnabled(true);
            btn2.setEnabled(false);
            btnstart.setVisible(false);
            LuaChonCau.setVisible(false);
            lbnThoiGian.setText("");
            point = 0;
            lbn8.setText(point + " Điểm");
            lbn5.setVisible(true);
            lbnsocau.hide();

        }
        if (e.getSource() == btn3) {//nut Thu thach
            clip.stop();
            playSound(6);
            mode = 2;
            btnsubmit.setEnabled(false);
            btn2.setEnabled(true);
            btn3.setEnabled(false);
            LuaChonCau.setVisible(true);
            LuaChonCau.setEnabled(true);
            btnstart.setVisible(true);
            btnstart.setEnabled(false);
            lbn5.setVisible(false);
            lbntuvung.setText("");

        }

        if (e.getSource() == btn4) { //reset
            point = 0;
            lbn8.setText(point + " Điểm");
            dung = 0;
            demluot=pp;
            lbnThoiGian.setText("0");
            lbntuvung.setText("");
            btnstart.setVisible(true);
//               playSound(1);
//            try {
//                sleep(10);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
//            }
            clip.stop();

        }
        if (e.getSource() == btn5) {
            clip.stop();
            frm1.setVisible(false);
            frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            playSound(0);
        }
        if (e.getSource() == LuaChonCau) {
            lbnsocau.setVisible(true);
            btnstart.setEnabled(true);
            point = 0;
            lbn8.setText(point + " Điểm");
            demluot = 0;
            int chon = LuaChonCau.getSelectedIndex();
            if (chon == 0) {
                pp = 5;
            } else if (chon == 1) {
                pp = 10;
            } else if (chon == 2) {
                pp = 20;
            }
            lbnsocau.setText("" + pp);
            System.out.println(pp);
        }
        if (e.getSource() == btnstart) {
            btnsubmit.setEnabled(true);
            btn2.setEnabled(false);//nut Luyen Tap
            btnstart.setVisible(false);
            LuaChonCau.setEnabled(false);
            random();
            
            a.start();

            clip.stop();
            playSound(4);
        }
        if (e.getSource() == btnsubmit) {
            check();
        }
    }

    class Thoigianchay extends Thread {

        public void run() {

            try {
                p = 10;
                while (p > 0) {
                    p--;
                    lbnThoiGian.setText("" + p);

                    sleep(1000);
                    if (p == 0) {
                        check();
                    }
                    if (demluot == pp) {

                        System.out.println(url);

                        clip.stop();
                        playSound(5);//finish
                        System.out.println(url);
                        try {
                            sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        clip.stop();
                        JOptionPane.showMessageDialog(null, "So cau dung : " + dung + "\n So cau sai :" + (pp - dung));

                        playSound(6);
//                      int dialogButton = JOptionPane.OK_OPTION;
//                     JOptionPane.showConfirmDialog (null, "So cau dung : "+dung+"\n So cau sai :"+(pp-dung),"Congratulations",dialogButton);

                        btnstart.setVisible(true);
                        btnstart.setEnabled(false);
                        LuaChonCau.setEnabled(true);
                        lbnsocau.setVisible(false);
                        btn2.setEnabled(true);
                        txt1.setText("");
                        lbnThoiGian.setText("");
                        dung = 0;
                        lbntuvung.setText("");
                        p = -1;   //thoat 

                    }

                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void playSound(int signal) {
        try {
            if (signal == 0) // Nhạc mới vào 
            {
                url = this.getClass().getResource("a.wav");
            } else if (signal == 1)// Sau n bấm random để chơi
            {
                url = this.getClass().getResource("button.wav");

            } else if (signal == 2) {
                url = this.getClass().getResource("incorrect.wav");
            } else if (signal == 3) {
                url = this.getClass().getResource("correct.wav");
            } else if (signal == 4) {
                url = this.getClass().getResource("timer.wav");
            } else if (signal == 5) {
                url = this.getClass().getResource("finish.wav");
            } else if (signal == 6)// Sau n bấm random để chơi
            {
                url = this.getClass().getResource("nhacnen.wav");

            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
 
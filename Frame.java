package PING_PONG_GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Frame extends JPanel implements ActionListener, KeyListener {
    JFrame f;
    int unit_size = 25;
    Timer t;
    int width = 350;
    int height = 500;
    int delay = 30;
    int m1 = 2;
    int m2 = 4;
    int x1 = 0;
    int a = 0;
    int b = height;
    int y1 = 0;
    boolean run = false;
    boolean x = false;
    int b_width = 50;
    int b_height = 5;
    int score_i = 0;
    Random random = new Random();
    int rc = random.nextInt(3) + 1;

    Frame() {
        // this.setBounds(0,0,width,height);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(0));
        this.setFocusable(true);
        this.addKeyListener(this);
        start();
    }

    public void start() {
        run = true;
        t = new Timer(delay, this);
        t.start();
    }

    public void move() {
        if (run) {
            if (x1 >= width - unit_size || x1 < 0) {
                m1 = m1 * -1;
            }
            x1 -= m1;
            if (y1 < 0) {
                m2 = m2 * -1;
            }
            y1 -= m2;
            if (y1 >= b - unit_size && x1 >= a - 10 && x1 <= a + 47) {
                m2 = m2 * -1;
                score_i++;
            }
            y1 -= m2;
            repaint();
            // if(y1 >= a + 50 && x1 >= a && x1 <= a + b_width ){
            // m2=m2*-1;
            // }(y1 >= b - unit_size && x1+unit_size >= a && x1 <= a + b_width)
            // y1-=m2;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        score(g);
        block(g);
        draw(g);
        if (!run) {
            hii(g);
        }
    }

    public void draw(Graphics g) {
        if (run) {
            g.setColor(new Color(0xFF0000));
            g.fillOval(x1, y1, unit_size, unit_size);
        }
    }

    public void gameOver() {
        t.stop();
        run = false;
    }

    public void block(Graphics g) {
        if (run) {
            g.setColor(new Color(0x05BCC2));
            g.fillRect(a, b - 5, b_width, b_height);
        }
    }

    public void hii(Graphics g) {
        g.setFont(new Font("MV Boli", Font.BOLD, 20));
        g.setColor(new Color(0x0095FF));
        // FontMetrics mat=getFontMetrics(g.getFont());
        // g.drawString("GAME___OVER___",width-mat.stringWidth("GAME___OVER___")/2,height/2);
        g.drawString("GAME___OVER___", 100, 200);
    }

    // public void left() {
    // if(run){
    // if (a + 50 <= width) {
    // a = a + 10;
    // x = true;
    // repaint();
    // }
    // }
    // }
    // public void right () {
    // if (a - 10 >= 0) {
    //// a = a - 10;
    // x = true;
    // repaint();
    //
    // }
    // }
    public void score(Graphics g) {
        g.setColor(new Color(0xFD0000));
        g.setFont(new Font("MV Boli", Font.BOLD, 20));
        FontMetrics mat = getFontMetrics(g.getFont());
        g.drawString("SCORE " + score_i, width - mat.stringWidth("SCORE " + score_i) - 20, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        move();

        if (y1 + unit_size >= height) {
            gameOver();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (a >= 0) {
                a = a - 5;
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (a + 50 <= width) {
                a = a + 5;
            }

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyCode()); // Print the key code
    }
}

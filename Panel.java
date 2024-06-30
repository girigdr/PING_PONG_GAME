package PING_PONG_GAME;

import javax.swing.*;

public class Panel extends JFrame {
    Panel() {
        this.add(new Frame());
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("JAVA__PONG__GAME__");
        this.pack();
        this.setLocationRelativeTo(null);
    }
}

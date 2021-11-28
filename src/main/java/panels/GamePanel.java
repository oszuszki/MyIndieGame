package panels;

import appearance.Map;
import entities.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class GamePanel extends JPanel implements Runnable, KeyListener {

    private boolean settingUpMap = true;

    private Thread thread;
    boolean running = false;

    private int FPS =60;
    private long targetTime = 1000/FPS;
    int MAX_FRAME_SKIPS = 5;

    public static BufferedImage[] images;

    public GamePanel()  {
        addKeyListener(this);
        setFocusable(true);

        //temporary
        images = new BufferedImage[18];

        try {
            images[0] = ImageIO.read(this.getClass().getResourceAsStream("/redx.png"));
            images[1] = ImageIO.read(this.getClass().getResourceAsStream("/runr1.png"));
            images[2] = ImageIO.read(this.getClass().getResourceAsStream("/runr2.png"));
            images[3] = ImageIO.read(this.getClass().getResourceAsStream("/runr3.png"));
            images[4] = ImageIO.read(this.getClass().getResourceAsStream("/runr4.png"));
            images[5] = ImageIO.read(this.getClass().getResourceAsStream("/runl1.png"));
            images[6] = ImageIO.read(this.getClass().getResourceAsStream("/runl2.png"));
            images[7] = ImageIO.read(this.getClass().getResourceAsStream("/runl3.png"));
            images[8] = ImageIO.read(this.getClass().getResourceAsStream("/runl4.png"));
            images[9] = ImageIO.read(this.getClass().getResourceAsStream("/mel.png"));
            images[10] = ImageIO.read(this.getClass().getResourceAsStream("/calib.png"));
            images[11] = ImageIO.read(this.getClass().getResourceAsStream("/mer.png"));
            images[12] = ImageIO.read(this.getClass().getResourceAsStream("/arrow_l.png"));
            images[13] = ImageIO.read(this.getClass().getResourceAsStream("/arrow_r.png"));
            images[14] = ImageIO.read(this.getClass().getResourceAsStream("/spike_up.png"));
            images[15] = ImageIO.read(this.getClass().getResourceAsStream("/upr.png"));
            images[16] = ImageIO.read(this.getClass().getResourceAsStream("/upl.png"));
            images[17] = ImageIO.read(this.getClass().getResourceAsStream("/demo_ground.png"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        start();
    }


    public void start() {
        running = true;

        thread = new Thread(this);
        thread.start();

    }

    public void update() {
        repaint();
        Player.playerActions();
    }

    @Override
    public void run() {
        long start, diff, sleep, skippedFrames;

        while(running) {
            start = System.currentTimeMillis();
            skippedFrames = 0;

            update();

            diff = System.currentTimeMillis() - start;
            sleep = targetTime - diff;

            if (sleep > 0) {
                try {
                    //noinspection BusyWait
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (sleep < 0 && skippedFrames < MAX_FRAME_SKIPS) {
                sleep += targetTime;
                skippedFrames++;
            }
        }

    }

    public void paint(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.black);
        Map.draw(g);
        Player.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Player.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Player.keyReleased(e.getKeyCode());
    }
}

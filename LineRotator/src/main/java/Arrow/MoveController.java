/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arrow;

/**
 *
 * @author Hosam
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class MoveController extends JPanel implements Runnable {

    private double angleDegreesShift;
    Thread t;

    public MoveController() {
        angleDegreesShift = 90;
        setBackground(Color.black);
    }

    public void startRotate() {
        repaint();//*/
        if (t == null) {
            t = new Thread(this);
            t.start();//*/
        }
    }

    public void stopRotate() {
        if (t != null) {
            t.interrupt();
            t = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

        super.paintComponent(g2);

        int rectangleWidth = getWidth();
        int rectangleHeight = getHeight();

        int diameter, x, y;

        if (rectangleWidth <= rectangleHeight) {
            diameter = rectangleWidth;
            y = rectangleHeight / 2 - diameter / 2;
            x = 0;
        } else {
            diameter = rectangleHeight;
            y = 0;
            x = rectangleWidth / 2 - diameter / 2;

        }

        Line line = new Line(x + diameter / 2, y + diameter / 2, angleDegreesShift, diameter / 2, 3, 10);
        line.draw(g2);
    }

    @Override
    public void run() {
        try {
            while (true) {
                angleDegreesShift %= 360;
                angleDegreesShift += 10;
                repaint();
                Thread.sleep(30);
            }
        } catch (InterruptedException e) {
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arrow;

/**
 *
 * @author Hosam
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Line {

    private final int x;
    private final int y;
    private final int endX;
    private final int endY;
    private final double angleRadians;
    private final int lineThickness;

    public Line(int x, int y, double angleDegrees, int length, int lineThickness, int headSize) {
        super();
        this.x = x;
        this.y = y;
        this.lineThickness = lineThickness;

        this.angleRadians = Math.toRadians(angleDegrees);

        this.endX = (int) (x + (length - headSize) * Math.cos(-angleRadians));
        this.endY = (int) (y + (length - headSize) * Math.sin(-angleRadians));

    }    

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(lineThickness));

        g2.drawLine(x, y, endX, endY);

        AffineTransform tx1 = g2.getTransform();

        AffineTransform tx2 = (AffineTransform) tx1.clone();

        tx2.translate(endX, endY);
        tx2.rotate(angleRadians);

        g2.setTransform(tx2);

        g2.setTransform(tx1);
    }
}

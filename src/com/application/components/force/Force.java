package com.application.components.force;

import java.awt.*;

public class Force {
    private static Color ARROW_COLOR = new Color(0, 0, 0);
    private String label;
    private int magnitude;
    private int direction; // 1 == l to r, -1 == r to l;

    public Force(String label, int magnitude, int direction) {
        this.direction = direction;
        this.magnitude = magnitude;
        this.label = label;
    }

    public void apply(Graphics g) {
        int length = magnitude / 10;
        if (length <= 0)
            return;
        g.setColor(ARROW_COLOR);
        Point from = new Point(0, 0);
        Point to = new Point(from.x + direction * length, from.y);
        if (from.getY() < 5) {
            from = new Point(from.x, from.y - 5);
            to = new Point(to.x, to.y - 5);
        }
        arrowLine(g, from, to);
        g.drawString(label, to.x - direction * 20, to.y - 10);
    }

    private void arrowLine(Graphics g, Point from, Point to) {
        int d = 5;
        g.setColor(ARROW_COLOR);
        g.drawLine(from.x, from.y, to.x, to.y);
        g.fillOval(from.x - d / 2, from.y - d / 2, d, d);
        if (from.x > to.x) {
            g.fillPolygon(new int[] { to.x, to.x + d, to.x + d, to.x },
                    new int[] { to.y, to.y - d, to.y + d, to.y }, 4);
        } else {
            g.fillPolygon(new int[] { to.x, to.x - d, to.x - d, to.x },
                    new int[] { to.y, to.y - d, to.y + d, to.y }, 4);
        }
    }

}

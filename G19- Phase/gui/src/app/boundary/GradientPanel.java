/*
 * Hotel Management System - Gradient background panel helper
 * CSCI04C Programming in Java - Coursework Part 2
 * Date: 2026-04-24
 *
 * A minimal JPanel that paints a vertical linear gradient behind its
 * children. Used as the brand header panel on the Login screen and as
 * the sidebar on dashboard forms to give the application a consistent
 * navy-to-light-navy visual identity. Kept deliberately small so it
 * renders predictably inside the NetBeans Form Editor design tab.
 */
package app.boundary;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/** A JPanel that paints a top-to-bottom linear gradient behind its contents. */
public class GradientPanel extends JPanel {

    // Top colour of the gradient - defaults to the primary brand navy.
    private Color startColor = UITheme.PRIMARY;

    // Bottom colour of the gradient - defaults to the lighter brand navy.
    private Color endColor   = UITheme.PRIMARY_LIGHT;

    /** Creates a gradient panel using the default brand colours. */
    public GradientPanel() {
        setOpaque(true);
    }

    /** Returns the top colour of the gradient. */
    public Color getStartColor() { return startColor; }

    /** Sets the top colour of the gradient and repaints. */
    public void setStartColor(Color c) {
        if (c != null) { this.startColor = c; repaint(); }
    }

    /** Returns the bottom colour of the gradient. */
    public Color getEndColor() { return endColor; }

    /** Sets the bottom colour of the gradient and repaints. */
    public void setEndColor(Color c) {
        if (c != null) { this.endColor = c; repaint(); }
    }

    /** Paints the gradient, then lets Swing paint the panel's children on top. */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth();
            int h = getHeight();
            GradientPaint gp = new GradientPaint(0, 0, startColor, 0, h, endColor);
            g2.setPaint(gp);
            g2.fillRect(0, 0, w, h);
        } finally {
            g2.dispose();
        }
        super.paintComponent(g);
    }
}

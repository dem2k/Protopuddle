package defpackage;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;

/* renamed from: RotatedIcon  reason: default package */
public class RotatedIcon implements Icon {
    private boolean circularIcon;
    private double degrees;
    private Icon icon;
    private Rotate rotate;

    /* renamed from: RotatedIcon$Rotate */
    public enum Rotate {
        DOWN,
        UP,
        UPSIDE_DOWN,
        ABOUT_CENTER
    }

    public RotatedIcon(Icon icon2) {
        this(icon2, Rotate.UP);
    }

    public RotatedIcon(Icon icon2, Rotate rotate2) {
        this.icon = icon2;
        this.rotate = rotate2;
    }

    public RotatedIcon(Icon icon2, double degrees2) {
        this(icon2, degrees2, false);
    }

    public RotatedIcon(Icon icon2, double degrees2, boolean circularIcon2) {
        this(icon2, Rotate.ABOUT_CENTER);
        setDegrees(degrees2);
        setCircularIcon(circularIcon2);
    }

    public Icon getIcon() {
        return this.icon;
    }

    public Rotate getRotate() {
        return this.rotate;
    }

    public double getDegrees() {
        return this.degrees;
    }

    public void setDegrees(double degrees2) {
        this.degrees = degrees2;
    }

    public boolean isCircularIcon() {
        return this.circularIcon;
    }

    public void setCircularIcon(boolean circularIcon2) {
        this.circularIcon = circularIcon2;
    }

    public int getIconWidth() {
        if (this.rotate == Rotate.ABOUT_CENTER) {
            if (this.circularIcon) {
                return this.icon.getIconWidth();
            }
            double radians = Math.toRadians(this.degrees);
            double sin = Math.abs(Math.sin(radians));
            return (int) Math.floor((((double) this.icon.getIconWidth()) * Math.abs(Math.cos(radians))) + (((double) this.icon.getIconHeight()) * sin));
        } else if (this.rotate == Rotate.UPSIDE_DOWN) {
            return this.icon.getIconWidth();
        } else {
            return this.icon.getIconHeight();
        }
    }

    public int getIconHeight() {
        if (this.rotate == Rotate.ABOUT_CENTER) {
            if (this.circularIcon) {
                return this.icon.getIconHeight();
            }
            double radians = Math.toRadians(this.degrees);
            double sin = Math.abs(Math.sin(radians));
            return (int) Math.floor((((double) this.icon.getIconHeight()) * Math.abs(Math.cos(radians))) + (((double) this.icon.getIconWidth()) * sin));
        } else if (this.rotate == Rotate.UPSIDE_DOWN) {
            return this.icon.getIconHeight();
        } else {
            return this.icon.getIconWidth();
        }
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        int xAdjustment;
        int yAdjustment;
        Graphics2D g2 = (Graphics2D)g.create();
        int cWidth = this.icon.getIconWidth() / 2;
        int cHeight = this.icon.getIconHeight() / 2;
        if (this.icon.getIconWidth() % 2 == 0) {
            xAdjustment = 0;
        } else {
            xAdjustment = -1;
        }
        if (this.icon.getIconHeight() % 2 == 0) {
            yAdjustment = 0;
        } else {
            yAdjustment = -1;
        }
        if (this.rotate == Rotate.DOWN) {
            g2.translate(x + cHeight, y + cWidth);
            g2.rotate(Math.toRadians(90.0d));
            this.icon.paintIcon(c, g2, -cWidth, yAdjustment - cHeight);
        } else if (this.rotate == Rotate.UP) {
            g2.translate(x + cHeight, y + cWidth);
            g2.rotate(Math.toRadians(-90.0d));
            this.icon.paintIcon(c, g2, xAdjustment - cWidth, -cHeight);
        } else if (this.rotate == Rotate.UPSIDE_DOWN) {
            g2.translate(x + cWidth, y + cHeight);
            g2.rotate(Math.toRadians(180.0d));
            this.icon.paintIcon(c, g2, xAdjustment - cWidth, yAdjustment - cHeight);
        } else if (this.rotate == Rotate.ABOUT_CENTER) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setClip(x, y, getIconWidth(), getIconHeight());
            g2.translate((getIconWidth() - this.icon.getIconWidth()) / 2, (getIconHeight() - this.icon.getIconHeight()) / 2);
            g2.rotate(Math.toRadians(this.degrees), (double) (x + cWidth), (double) (y + cHeight));
            this.icon.paintIcon(c, g2, x, y);
        }
        g2.dispose();
    }
}

package defpackage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/* renamed from: Button  reason: default package */
public class Button extends JButton {
    public Button(String s, int x, int y, int width, int height) {
        setFont(Xf.font);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBorder(new LineBorder(Color.WHITE));
        setFocusPainted(false);
        setBounds(Xf.up(x), Xf.up(y), Xf.up(width), Xf.up(height));
        setText(s);
    }
}

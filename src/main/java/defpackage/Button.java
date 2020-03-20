package defpackage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/* renamed from: Button  reason: default package */
public class Button extends JButton {
    public Button(String s, int x, int y, int width, int height) {
        setFont(Sf.font);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBorder(new LineBorder(Color.WHITE));
        setFocusPainted(false);
        setBounds(Sf.t(x), Sf.t(y), Sf.t(width), Sf.t(height));
        setText(s);
    }
}

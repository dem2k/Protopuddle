package defpackage;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/* renamed from: Button  reason: default package */
public class Button extends JButton {
    private int sf=ScreenFactor.factor;
    public Button(String s, int x, int y, int width, int height) {
        setFont(new Font("Verdana",Font.BOLD,20));
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBorder(new LineBorder(Color.WHITE));
        setFocusPainted(false);
        setBounds(x*sf, y*sf, width*sf, height*sf);
        setText(s);
    }
}

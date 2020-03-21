package defpackage;

import java.awt.*;
import javax.swing.JTextField;

/* renamed from: TextField  reason: default package */
public class TextField extends JTextField {
    public TextField(String s, int x, int y, int width, int height) {
        setFont(Xf.font);
        setText(s);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setCaretColor(Color.white);
        setCaretPosition(getText().length());
        setBounds(Xf.up(x), Xf.up( y), Xf.up(width), Xf.up( height));
    }
}

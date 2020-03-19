package defpackage;

import java.awt.*;
import javax.swing.JTextField;

/* renamed from: TextField  reason: default package */
public class TextField extends JTextField {
    private int sf=ScreenFactor.factor;
    public TextField(String s, int x, int y, int width, int height) {
        setText(s);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setCaretColor(Color.white);
        setFont(ScreenFactor.font);
        setCaretPosition(getText().length());
        setBounds(x*sf, y*sf, width*sf, height*sf);
    }
}

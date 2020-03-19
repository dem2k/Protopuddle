package defpackage;

import java.awt.*;
import javax.swing.JLabel;

/* renamed from: Label  reason: default package */
public class Label extends JLabel {
    private int sf=ScreenFactor.factor;
    public Label(String s, int x, int y, int width, int height) {
        setFont(ScreenFactor.font?));
        setText(s);
        setForeground(Color.WHITE);
        setBounds(x*sf, y*sf, width*sf, height*sf);
    }
}

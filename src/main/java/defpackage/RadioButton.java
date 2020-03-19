package defpackage;

import java.awt.Color;
import javax.swing.JRadioButton;

/* renamed from: RadioButton  reason: default package */
public class RadioButton extends JRadioButton {
    private int sf=ScreenFactor.factor;
    public RadioButton(String s, int x, int y, int width, int height) {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBounds(x*sf, y*sf, width*sf, height*sf);
        setFocusPainted(false);
        setText(s);
    }
}

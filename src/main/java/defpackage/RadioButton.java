package defpackage;

import java.awt.Color;
import javax.swing.JRadioButton;

/* renamed from: RadioButton  reason: default package */
public class RadioButton extends JRadioButton {
    public RadioButton(String s, int x, int y, int width, int height) {
        setFont(Xf.font);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBounds(Xf.up(x), Xf.up( y), Xf.up( width), Xf.up( height));
        setFocusPainted(false);
        setText(s);
    }
}

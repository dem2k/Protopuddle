package defpackage;

import java.awt.Color;
import javax.swing.JRadioButton;

/* renamed from: RadioButton  reason: default package */
public class RadioButton extends JRadioButton {
    public RadioButton(String s, int x, int y, int width, int height) {
        setFont(Sf.font);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBounds(Sf.t(x),Sf.t( y),Sf.t( width),Sf.t( height));
        setFocusPainted(false);
        setText(s);
    }
}

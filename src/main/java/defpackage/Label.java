package defpackage;

import java.awt.*;
import javax.swing.JLabel;

/* renamed from: Label  reason: default package */
public class Label extends JLabel {
    public Label(String s, int x, int y, int width, int height) {
        setFont(Sf.font);
        setText(s);
        setForeground(Color.WHITE);
        setBounds(Sf.t(x),Sf.t( y),Sf.t( width),Sf.t( height));
    }
}

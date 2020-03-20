package defpackage;

import java.awt.*;

/**
 * @author DKL on 14.03.2020.
 */
public class Sf {
    public static final float factorx = 1.5f;
    public static final Font font = new Font("Verdana", Font.BOLD, (int)(10*factorx));
    public static final String resDir="/x1dot5";
    public static int t(int val){
        return (int)(val*factorx);
    }
}

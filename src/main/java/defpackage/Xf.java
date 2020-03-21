package defpackage;

import java.awt.*;

/**
 * @author DKL on 14.03.2020.
 */
public class Xf {
    private static final float xfactr = 1.5f;
    private static final String resDir = "/x1dot5";
    public static final Font font = new Font("Verdana", Font.BOLD, (int) (10 * xfactr));

    public static int up(int val) {
        return (int) (val * xfactr);
    }

    public static String dir(String resName) {
        return resDir + resName;
    }

    public static int dn(int val) {
        return (int) (val / xfactr);
    }
}

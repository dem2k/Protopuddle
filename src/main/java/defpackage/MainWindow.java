package defpackage;

import java.awt.*;
import javax.swing.*;

/* renamed from: MainWindow  reason: default package */
public class MainWindow extends JFrame {
    public static GameField mainGameField;

    public MainWindow() {
        setTitle("ProtoPuddle");
        setFont(Xf.font);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(Xf.dn(sSize.width), sSize.height - 96);
        setLayout(new BorderLayout());
        add(new Panel(), BorderLayout.WEST);
        mainGameField = new GameField();
        add(mainGameField, BorderLayout.CENTER);
        setVisible(true);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        if (sSize.width < 1280) {
            JScrollPane scroll = new JScrollPane(getContentPane());
            scroll.setVerticalScrollBarPolicy(22);
            scroll.setHorizontalScrollBarPolicy(31);
            setContentPane(scroll);
        }
    }

    public static void main(String[] args) {
        new MainWindow().setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource(Xf.dir("/icon.png"))));
    }
}

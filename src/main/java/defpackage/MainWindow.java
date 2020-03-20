package defpackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/* renamed from: MainWindow  reason: default package */
public class MainWindow extends JFrame {
    public static GameField mainGameField;

    public MainWindow() {
        setTitle("ProtoPuddle");
        setFont(Sf.font);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(sSize);
        setLayout(new BorderLayout());
        add(new Panel(), "West");
        mainGameField = new GameField();
        add(mainGameField, "Center");
        setVisible(true);
        setExtendedState(6);
        if (sSize.width < 1280) {
            JScrollPane scroll = new JScrollPane(getContentPane());
            scroll.setVerticalScrollBarPolicy(22);
            scroll.setHorizontalScrollBarPolicy(31);
            setContentPane(scroll);
        }
    }

    public static void main(String[] args) {
        new MainWindow().setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource(Sf.resDir+"/icon.png")));
    }
}

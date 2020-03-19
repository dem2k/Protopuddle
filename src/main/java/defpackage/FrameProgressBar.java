package defpackage;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/* renamed from: FrameProgressBar  reason: default package */
public class FrameProgressBar extends JFrame {
    JProgressBar progressBar = new JProgressBar();
    private int sf=ScreenFactor.factor;

    public FrameProgressBar() {
        setTitle("Progress");
        setSize(600*sf, 100*sf);
        getContentPane().setBackground(Color.BLACK);
        setLocation(500, 400);
        setResizable(false);
        setLayout( null);
        setUndecorated(true);
        setVisible(true);
        this.progressBar.setBounds(0, 0, 600, 100);
        this.progressBar.setBackground(Color.BLACK);
        this.progressBar.setStringPainted(true);
        setAlwaysOnTop(true);
        add(this.progressBar);
    }

    public void MinMax(int min, int max) {
        this.progressBar.setMinimum(min);
        this.progressBar.setMaximum(max);
    }

    public void Value(int value) {
        this.progressBar.setValue(value);
    }
}

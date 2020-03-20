package defpackage;

import java.awt.*;
import javax.swing.*;

/* renamed from: FrameProgressBar  reason: default package */
public class FrameProgressBar extends JFrame {
    JProgressBar progressBar = new JProgressBar();

    public FrameProgressBar() {
        setTitle("Progress");
        setSize(Sf.t(600), Sf.t(100));
        getContentPane().setBackground(Color.BLACK);
        setLocation(Sf.t(500), Sf.t(400));
        setResizable(false);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        this.progressBar.setBounds(Sf.t(0), Sf.t(0), Sf.t(600), Sf.t(100));
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

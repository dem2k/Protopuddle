package defpackage;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* renamed from: Tabs  reason: default package */
public class Tabs extends JTabbedPane {
    static final int INIT_SPEED = -500;
    static final int MAX_SPEED = 0;
    static final int MIN_SPEED = -1000;
    public static JLabel labelLiveCount;
    public static JLabel labelLiveNumber;

    public Tabs() {
        setFont(Xf.font);
        setBackground(Color.white);
        setPreferredSize(new Dimension(320, 1008));
        JPanel info = new JPanel();
        labelLiveCount = new JLabel();
        labelLiveCount.setForeground(Color.WHITE);
        info.add(labelLiveCount);
        labelLiveNumber = new JLabel();
        labelLiveNumber.setForeground(Color.WHITE);
        info.add(labelLiveNumber);
        info.setBackground(Color.BLACK);
        add("Info", info);
        JPanel settings = new JPanel();
        settings.setBackground(Color.BLACK);
        JLabel speedLabelSlow = new JLabel("Slow");
        speedLabelSlow.setForeground(Color.WHITE);
        settings.add(speedLabelSlow);
        JSlider speedSlider = new JSlider(MAX_SPEED, MIN_SPEED, MAX_SPEED, INIT_SPEED);
        speedSlider.setBackground(Color.BLACK);
        speedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                GameField.speed = ((JSlider) e.getSource()).getValue() * -1;
                GameField.timer.setDelay(GameField.speed);
            }
        });
        settings.add(speedSlider);
        JLabel speedLabelFast = new JLabel("Fast");
        speedLabelFast.setForeground(Color.WHITE);
        settings.add(speedLabelFast);
        add("Settings", settings);
    }
}

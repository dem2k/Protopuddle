package defpackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* renamed from: FrameNewPuddle  reason: default package */
public class FrameNewPuddle extends JFrame {
    public static int plantsSpeedFromSlider = 5;
    public int numberOfLiveCells = 10;
    public int numberOfPlants = 1000;
    private int sf=ScreenFactor.factor;

    public FrameNewPuddle() {
        setTitle("New Puddle");
        setSize(300*sf, 440*sf);
        getContentPane().setBackground(Color.BLACK);
        setLocation(500, 200);
        setResizable(false);
        setLayout( null);
        setVisible(false);
        add(new Label("Number of live cells", 10, 10, 150, 20));
        final TextField tfNumberOfLiveCells = new TextField("10", 170, 10, 100, 20);
        add(tfNumberOfLiveCells);
        tfNumberOfLiveCells.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (tfNumberOfLiveCells.getForeground() == Color.RED) {
                    tfNumberOfLiveCells.setText("10");
                    tfNumberOfLiveCells.setForeground(Color.WHITE);
                    FrameNewPuddle.this.numberOfLiveCells = 10;
                }
            }

            public void focusLost(FocusEvent e) {
                if (!tfNumberOfLiveCells.getText().matches("^[0-9]+") || tfNumberOfLiveCells.getText().length() >= 10) {
                    tfNumberOfLiveCells.setForeground(Color.RED);
                    tfNumberOfLiveCells.setText("1-" + ((((GameField.mapWidth - 2) * (GameField.mapHeight - 2)) - FrameNewPuddle.this.numberOfPlants) - 1));
                } else if ((((GameField.mapWidth - 2) * (GameField.mapHeight - 2)) - FrameNewPuddle.this.numberOfPlants) - 1 < Integer.parseInt(tfNumberOfLiveCells.getText()) || Integer.parseInt(tfNumberOfLiveCells.getText()) <= 0) {
                    tfNumberOfLiveCells.setForeground(Color.RED);
                    tfNumberOfLiveCells.setText("1-" + ((((GameField.mapWidth - 2) * (GameField.mapHeight - 2)) - FrameNewPuddle.this.numberOfPlants) - 1));
                } else {
                    tfNumberOfLiveCells.setForeground(Color.WHITE);
                    FrameNewPuddle.this.numberOfLiveCells = Integer.parseInt(tfNumberOfLiveCells.getText());
                }
            }
        });
        add(new Label("Live Cell Energy", 10, 40, 150, 20));
        final TextField tfLiveCellEnergy = new TextField("100", 170, 40, 100, 20);
        add(tfLiveCellEnergy);
        tfLiveCellEnergy.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (tfLiveCellEnergy.getForeground() == Color.RED) {
                    tfLiveCellEnergy.setText("100");
                    tfLiveCellEnergy.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!tfLiveCellEnergy.getText().matches("^[0-9]+") || tfLiveCellEnergy.getText().length() >= 10) {
                    tfLiveCellEnergy.setForeground(Color.RED);
                    tfLiveCellEnergy.setText("1-999999999");
                } else if (Integer.parseInt(tfLiveCellEnergy.getText()) > 0) {
                    tfLiveCellEnergy.setForeground(Color.WHITE);
                } else {
                    tfLiveCellEnergy.setForeground(Color.RED);
                    tfLiveCellEnergy.setText("1-999999999");
                }
            }
        });
        add(new Label("Max Damage", 10, 70, 150, 20));
        final TextField tfMaxDamage = new TextField("50", 170, 70, 100, 20);
        add(tfMaxDamage);
        tfMaxDamage.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (tfMaxDamage.getForeground() == Color.RED) {
                    tfMaxDamage.setText("50");
                    tfMaxDamage.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!tfMaxDamage.getText().matches("^[0-9]+") || tfMaxDamage.getText().length() >= 10) {
                    tfMaxDamage.setForeground(Color.RED);
                    tfMaxDamage.setText("1-999999999");
                } else if (Integer.parseInt(tfMaxDamage.getText()) > 0) {
                    tfMaxDamage.setForeground(Color.WHITE);
                } else {
                    tfMaxDamage.setForeground(Color.RED);
                    tfMaxDamage.setText("1-999999999");
                }
            }
        });
        add(new Label("Gen Length", 10, 100, 150, 20));
        final TextField tfGenLength = new TextField("15", 170, 100, 100, 20);
        add(tfGenLength);
        tfGenLength.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (tfGenLength.getForeground() == Color.RED) {
                    tfGenLength.setText("15");
                    tfGenLength.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!tfGenLength.getText().matches("^[0-9]+") || tfGenLength.getText().length() >= 3) {
                    tfGenLength.setForeground(Color.RED);
                    tfGenLength.setText("1-99");
                } else if (Integer.parseInt(tfGenLength.getText()) > 0) {
                    tfGenLength.setForeground(Color.WHITE);
                } else {
                    tfGenLength.setForeground(Color.RED);
                    tfGenLength.setText("1-99");
                }
            }
        });
        add(new Label("Min Energy For Division", 10, 130, 150, 20));
        final TextField tfMinEnergyForDivision = new TextField("50", 170, 130, 100, 20);
        add(tfMinEnergyForDivision);
        tfMinEnergyForDivision.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (tfMinEnergyForDivision.getForeground() == Color.RED) {
                    tfMinEnergyForDivision.setText("3");
                    tfMinEnergyForDivision.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!tfMinEnergyForDivision.getText().matches("^[0-9]+") || tfMinEnergyForDivision.getText().length() >= 9) {
                    tfMinEnergyForDivision.setForeground(Color.RED);
                    tfMinEnergyForDivision.setText("3-" + GameField.maxEnergyForDivision);
                } else if (Integer.parseInt(tfMinEnergyForDivision.getText()) <= 2 || Integer.parseInt(tfMinEnergyForDivision.getText()) > GameField.maxEnergyForDivision) {
                    tfMinEnergyForDivision.setForeground(Color.RED);
                    tfMinEnergyForDivision.setText("3-" + GameField.maxEnergyForDivision);
                } else {
                    tfMinEnergyForDivision.setForeground(Color.WHITE);
                    GameField.minEnergyForDivision = Integer.parseInt(tfMinEnergyForDivision.getText());
                }
            }
        });
        add(new Label("Max Energy For Division", 10, 160, 150, 20));
        TextField tfMaxEnergyForDivision = new TextField("10000", 170, 160, 100, 20);
        add(tfMaxEnergyForDivision);
        final TextField textField = tfMaxEnergyForDivision;
        tfMaxEnergyForDivision.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField.getForeground() == Color.RED) {
                    textField.setText(Integer.toString(GameField.minEnergyForDivision + 10000));
                    textField.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!textField.getText().matches("^[0-9]+") || textField.getText().length() >= 10) {
                    textField.setForeground(Color.RED);
                    textField.setText(GameField.minEnergyForDivision + "-999999999");
                } else if (Integer.parseInt(textField.getText()) >= GameField.minEnergyForDivision) {
                    textField.setForeground(Color.WHITE);
                    GameField.maxEnergyForDivision = Integer.parseInt(textField.getText());
                } else {
                    textField.setForeground(Color.RED);
                    textField.setText(GameField.minEnergyForDivision + "-999999999");
                }
            }
        });
        add(new Label("Number Of Plants", 10, 190, 150, 20));
        TextField tfNumberOfPlants = new TextField("1000", 170, 190, 100, 20);
        add(tfNumberOfPlants);
        final TextField textField2 = tfNumberOfPlants;
        tfNumberOfPlants.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField2.getForeground() == Color.RED) {
                    textField2.setText("1000");
                    textField2.setForeground(Color.WHITE);
                    FrameNewPuddle.this.numberOfPlants = 1000;
                }
            }

            public void focusLost(FocusEvent e) {
                if (!textField2.getText().matches("^[0-9]+") || textField2.getText().length() >= 10) {
                    textField2.setForeground(Color.RED);
                    textField2.setText("0-" + ((((GameField.mapWidth - 2) * (GameField.mapHeight - 2)) - FrameNewPuddle.this.numberOfLiveCells) - 1));
                } else if ((((GameField.mapWidth - 2) * (GameField.mapHeight - 2)) - FrameNewPuddle.this.numberOfLiveCells) - 1 < Integer.parseInt(textField2.getText()) || Integer.parseInt(textField2.getText()) < 0) {
                    textField2.setForeground(Color.RED);
                    textField2.setText("0-" + ((((GameField.mapWidth - 2) * (GameField.mapHeight - 2)) - FrameNewPuddle.this.numberOfLiveCells) - 1));
                } else {
                    textField2.setForeground(Color.WHITE);
                    FrameNewPuddle.this.numberOfPlants = Integer.parseInt(textField2.getText());
                }
            }
        });
        add(new Label("Plant Energy", 10, 220, 150, 20));
        TextField tfPlantEnergy = new TextField("20", 170, 220, 100, 20);
        add(tfPlantEnergy);
        final TextField textField3 = tfPlantEnergy;
        tfPlantEnergy.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField3.getForeground() == Color.RED) {
                    textField3.setText("20");
                    textField3.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!textField3.getText().matches("^[0-9]+") || textField3.getText().length() >= 10) {
                    textField3.setForeground(Color.RED);
                    textField3.setText("0-999999999");
                } else if (Integer.parseInt(textField3.getText()) >= 0) {
                    textField3.setForeground(Color.WHITE);
                } else {
                    textField3.setForeground(Color.RED);
                    textField3.setText("0-999999999");
                }
            }
        });
        add(new Label("Meat Energy", 10, 250, 150, 20));
        TextField tfMeatEnergy = new TextField("30", 170, 250, 100, 20);
        add(tfMeatEnergy);
        final TextField textField4 = tfMeatEnergy;
        tfMeatEnergy.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField4.getForeground() == Color.RED) {
                    textField4.setText("30");
                    textField4.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!textField4.getText().matches("^[0-9]+") || textField4.getText().length() >= 10) {
                    textField4.setForeground(Color.RED);
                    textField4.setText("0-999999999");
                } else if (Integer.parseInt(textField4.getText()) >= 0) {
                    textField4.setForeground(Color.WHITE);
                } else {
                    textField4.setForeground(Color.RED);
                    textField4.setText("0-999999999");
                }
            }
        });
        add(new Label("Max Age", 10, 280, 150, 20));
        TextField tfMaxAge = new TextField("10000", 170, 280, 100, 20);
        add(tfMaxAge);
        final TextField textField5 = tfMaxAge;
        tfMaxAge.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField5.getForeground() == Color.RED) {
                    textField5.setText("10000");
                    textField5.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!textField5.getText().matches("^[0-9]+") || textField5.getText().length() >= 10) {
                    textField5.setForeground(Color.RED);
                    textField5.setText("0-999999999");
                } else if (Integer.parseInt(textField5.getText()) > 0) {
                    textField5.setForeground(Color.WHITE);
                } else {
                    textField5.setForeground(Color.RED);
                    textField5.setText("0-999999999");
                }
            }
        });
        add(new Label("Plants Speed", 10, 310, 100, 20));
        JSlider jSlider = new JSlider(0, 0, 10, 5);
        jSlider.setBackground(Color.BLACK);
        jSlider.setForeground(Color.WHITE);
        jSlider.setBounds(170, 310, 100, 25);
        jSlider.setMajorTickSpacing(10);
        jSlider.setMinorTickSpacing(0);
        jSlider.setPaintLabels(true);
        add(jSlider);
        jSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                FrameNewPuddle.plantsSpeedFromSlider = ((JSlider) e.getSource()).getValue();
            }
        });
        JButton jButton = new JButton("Start");
        jButton.setBackground(Color.BLACK);
        jButton.setForeground(Color.WHITE);
        jButton.setBorder(new LineBorder(Color.WHITE));
        jButton.setBounds(95, 360, 100, 30);
        jButton.setFocusPainted(false);
        add(jButton);
        final TextField textField6 = tfNumberOfLiveCells;
        final TextField textField7 = tfLiveCellEnergy;
        final TextField textField8 = tfMaxDamage;
        final TextField textField9 = tfGenLength;
        final TextField textField10 = tfMaxEnergyForDivision;
        final TextField textField11 = tfMinEnergyForDivision;
        final TextField textField12 = tfNumberOfPlants;
        final TextField textField13 = tfPlantEnergy;
        final TextField textField14 = tfMeatEnergy;
        final TextField textField15 = tfMaxAge;
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField6.getForeground() == Color.RED || textField7.getForeground() == Color.RED || textField8.getForeground() == Color.RED || textField9.getForeground() == Color.RED || textField10.getForeground() == Color.RED || textField11.getForeground() == Color.RED || textField12.getForeground() == Color.RED || textField13.getForeground() == Color.RED || textField14.getForeground() == Color.RED || textField15.getForeground() == Color.RED) {
                    JOptionPane.showMessageDialog((Component) null, "Change red strings for start new Puddle.");
                    return;
                }
                GameField.timer.stop();
                for (int i = 0; i < GameField.numberOfCells; i++) {
                    GameField.cell[i] = null;
                }
                GameField.liveCount = Short.parseShort(textField6.getText());
                GameField.firstEnergy = Integer.parseInt(textField7.getText());
                GameField.maxDamage = Integer.parseInt(textField8.getText()) + 1;
                GameField.genLength = Integer.parseInt(textField9.getText()) + 15;
                GameField.maxEnergyForDivision = Integer.parseInt(textField10.getText());
                GameField.minEnergyForDivision = Integer.parseInt(textField11.getText());
                GameField.plantsCount = Integer.parseInt(textField12.getText());
                GameField.plantEnergy = Integer.parseInt(textField13.getText());
                GameField.meatEnergy = Integer.parseInt(textField14.getText());
                GameField.maxAgeLive = Integer.parseInt(textField15.getText());
                GameField.plantsSpeed = FrameNewPuddle.plantsSpeedFromSlider;
                Panel.sliderPlantsSpeed.setValue(FrameNewPuddle.plantsSpeedFromSlider);
                Panel.btnPause.setBackground(Color.BLACK);
                Panel.btnPause.setText("Pause");
                Panel.tfMaxDamage.setText(textField8.getText());
                Panel.tfPlantEnergy.setText(textField13.getText());
                Panel.tfMeatEnergy.setText(textField14.getText());
                Panel.rbMostProlific.setSelected(true);
                GameField.numberOfCells = 0;
                GameField.plantsNumber = 0;
                GameField.liveNumber = GameField.liveCount;
                GameField.oldestCell = 0;
                GameField.steps = 0;
                GameField.initGame();
                FrameNewPuddle.this.setVisible(false);
            }
        });
    }

    public void PressNewPuddleBtn() {
        setExtendedState(0);
        setLocation(500, 200);
        setVisible(true);
    }
}

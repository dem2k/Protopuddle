package defpackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/* renamed from: Panel  reason: default package */
public class Panel extends JPanel {
    static final int INIT_SPEED = -500;
    static final int MAX_SPEED = 0;
    static final int MIN_SPEED = -1000;
    public static ButtonGroup bGroup = new ButtonGroup();
    public static Button btnPause;
    public static JFileChooser fcOpenPuddle;
    public static JFileChooser fcSavePuddle;
    public static ImageIcon[] iiCol = new ImageIcon[10];
    public static ImageIcon iiLiveAnyColorU;
    public static ImageIcon iiarrowLeft;
    public static ImageIcon iiarrowRight;
    public static ImageIcon iiarrowUP;
    public static ImageIcon iieatMeat;
    public static ImageIcon iieatPlant;
    public static ImageIcon iiknife;
    public static ImageIcon iinoKnife;
    public static ImageIcon iipause;
    public static boolean isPause;
    public static Label[] labelColorCount = new Label[10];
    public static Label labelLiveCount;
    public static Label labelLiveNumber;
    public static Label labelMeatNumber;
    public static Label labelPlantsNumber;
    public static Label labelSelectedCellAge;
    public static Label labelSelectedCellChanceOfMutation;
    public static Label labelSelectedCellEatenMeat;
    public static Label labelSelectedCellEatenPlants;
    public static Label labelSelectedCellEnergy;
    public static Label labelSelectedCellEnergyForDivision;
    public static Label labelSelectedCellIcon;
    public static Label labelSelectedCellKills;
    public static Label labelSelectedCellMaxAge;
    public static Label labelSelectedCellNumber;
    public static Label labelSelectedCellNumberOfChildren;
    public static DefaultTableModel model;
    public static RadioButton rbMostProlific;
    public static RadioButton rbOldest;
    public static RadioButton rbYoungest;
    public static JSlider sliderPlantsSpeed;
    public static JScrollPane spTableGen = new JScrollPane();
    public static Object[][] tableData = new Object[MAX_SPEED][];
    public static JTable tableGen;
    public static TextField tfMaxDamage;
    public static TextField tfMeatEnergy;
    public static TextField tfPlantEnergy;
    public FileNameExtensionFilter filterCell;
    public FileNameExtensionFilter filterPuddle;

    public Panel() {
        setFont(Sf.font);
        String[] strArr = new String[2];
        strArr[MAX_SPEED] = "pddl";
        strArr[1] = "PDDL";
        this.filterPuddle = new FileNameExtensionFilter("*.pddl", strArr);
        String[] strArr2 = new String[2];
        strArr2[MAX_SPEED] = "cll";
        strArr2[1] = "CLL";
        this.filterCell = new FileNameExtensionFilter("*.cll", strArr2);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Sf.t(320), Sf.t(1008)));
        setLayout(null);
        FrameNewPuddle frameNewPuddle = new FrameNewPuddle();
        Button newPuddleBtn = new Button("New Puddle", 5, 10, 100, 30);
        final FrameNewPuddle frameNewPuddle2 = frameNewPuddle;
        newPuddleBtn.addActionListener(e -> frameNewPuddle2.PressNewPuddleBtn());
        add(newPuddleBtn);
        Button btnOpenPuddle = new Button("Open Puddle", 110, 10, 100, 30);
        btnOpenPuddle.addActionListener(e -> {
            if (Panel.btnPause.getText().equals("Pause")) {
                Panel.isPause = false;
                Panel.pauseSimulation();
            } else {
                Panel.isPause = true;
            }
            Panel.fcOpenPuddle = new JFileChooser();
            Panel.fcOpenPuddle.setFileFilter(Panel.this.filterPuddle);
            if (Panel.fcOpenPuddle.showOpenDialog(null) == 0) {
                new ThreadProgressbar().execute();
            }
        });
        add(btnOpenPuddle);
        Button btnSavePuddle = new Button("Save Puddle", 215, 10, 100, 30);
        btnSavePuddle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Panel.btnPause.getText().equals("Pause")) {
                    Panel.isPause = false;
                    Panel.pauseSimulation();
                } else {
                    Panel.isPause = true;
                }
                Panel.fcSavePuddle = new JFileChooser();
                Panel.fcSavePuddle.setFileFilter(Panel.this.filterPuddle);
                if (Panel.fcSavePuddle.showSaveDialog((Component) null) == 0) {
                    new ThreadProgressbarSave().execute();
                }
            }
        });
        add(btnSavePuddle);
        new Button("Open Cell", 5, 70, 100, 30);
        new Label("Number Of Cells:", 110, 70, 100, 30);
        new TextField("1", 215, 70, 100, 30);
        new Button("Add Cells", 110, 105, 100, 30);
        new Label("_____________________________________________", MAX_SPEED, 125, 320, 30).setForeground(Color.YELLOW);
        add(new Label("Settings:", 135, 45, 200, 30));
        add(new Label("Simulation Speed:", 5, 65, 200, 30));
        add(new Label("Slow", 5, 90, 50, 30));
        JSlider jSlider = new JSlider(MAX_SPEED, MIN_SPEED, MAX_SPEED, INIT_SPEED);
        jSlider.setBackground(Color.BLACK);
        jSlider.setForeground(Color.WHITE);
        jSlider.setPaintLabels(true);
        jSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                GameField.timer.start();
                GameField.speed = ((JSlider) e.getSource()).getValue() * -1;
                GameField.timer.setDelay(GameField.speed);
                Panel.btnPause.setText("Pause");
                Panel.btnPause.setBackground(Color.BLACK);
            }
        });
        jSlider.setBounds(Sf.t(50), Sf.t(90), Sf.t(230), Sf.t(30));
        add(jSlider);
        add(new Label("Fast", 290, 90, 25, 30));
        btnPause = new Button("Pause", 110, 120, 100, 30);
        add(btnPause);
        btnPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Panel.pauseSimulation();
            }
        });
        add(new Label("Plants Speed:", 5, 150, 80, 30));
        add(new Label("None", 5, 180, 50, 30));
        sliderPlantsSpeed = new JSlider(MAX_SPEED, MAX_SPEED, 10, 5);
        sliderPlantsSpeed.setBackground(Color.BLACK);
        sliderPlantsSpeed.setForeground(Color.WHITE);
        sliderPlantsSpeed.setBounds(Sf.t(50), Sf.t(180), Sf.t(230), Sf.t(30));
        add(sliderPlantsSpeed);
        sliderPlantsSpeed.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                GameField.plantsSpeed = ((JSlider) e.getSource()).getValue();
            }
        });
        add(new Label("Fast", 290, 180, 25, 30));
        add(new Label("Plant Energy", 10, 220, 80, 20));
        tfPlantEnergy = new TextField("20", 90, 220, 100, 20);
        add(tfPlantEnergy);
        tfPlantEnergy.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (Panel.tfPlantEnergy.getForeground() == Color.RED) {
                    Panel.tfPlantEnergy.setText("20");
                    Panel.tfPlantEnergy.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!Panel.tfPlantEnergy.getText().matches("^[0-9]+") || Panel.tfPlantEnergy.getText().length() >= 10) {
                    Panel.tfPlantEnergy.setForeground(Color.RED);
                    Panel.tfPlantEnergy.setText("0-999999999");
                } else if (Integer.parseInt(Panel.tfPlantEnergy.getText()) >= 0) {
                    Panel.tfPlantEnergy.setForeground(Color.WHITE);
                } else {
                    Panel.tfPlantEnergy.setForeground(Color.RED);
                    Panel.tfPlantEnergy.setText("0-999999999");
                }
            }
        });
        add(new Label("Meat Energy", 10, 250, 80, 20));
        tfMeatEnergy = new TextField("30", 90, 250, 100, 20);
        add(tfMeatEnergy);
        tfMeatEnergy.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (Panel.tfMeatEnergy.getForeground() == Color.RED) {
                    Panel.tfMeatEnergy.setText("30");
                    Panel.tfMeatEnergy.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!Panel.tfMeatEnergy.getText().matches("^[0-9]+") || Panel.tfMeatEnergy.getText().length() >= 10) {
                    Panel.tfMeatEnergy.setForeground(Color.RED);
                    Panel.tfMeatEnergy.setText("0-999999999");
                } else if (Integer.parseInt(Panel.tfMeatEnergy.getText()) >= 0) {
                    Panel.tfMeatEnergy.setForeground(Color.WHITE);
                } else {
                    Panel.tfMeatEnergy.setForeground(Color.RED);
                    Panel.tfMeatEnergy.setText("0-999999999");
                }
            }
        });
        add(new Label("Max Damage", 10, 280, 80, 20));
        tfMaxDamage = new TextField("50", 90, 280, 100, 20);
        add(tfMaxDamage);
        tfMaxDamage.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (Panel.tfMaxDamage.getForeground() == Color.RED) {
                    Panel.tfMaxDamage.setText("50");
                    Panel.tfMaxDamage.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (!Panel.tfMaxDamage.getText().matches("^[0-9]+") || Panel.tfMaxDamage.getText().length() >= 10) {
                    Panel.tfMaxDamage.setForeground(Color.RED);
                    Panel.tfMaxDamage.setText("1-999999999");
                } else if (Integer.parseInt(Panel.tfMaxDamage.getText()) > 0) {
                    Panel.tfMaxDamage.setForeground(Color.WHITE);
                } else {
                    Panel.tfMaxDamage.setForeground(Color.RED);
                    Panel.tfMaxDamage.setText("1-999999999");
                }
            }
        });
        Button btnApply = new Button("Apply", 200, 220, 100, 80);
        add(btnApply);
        btnApply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Panel.tfMaxDamage.getForeground() == Color.RED || Panel.tfPlantEnergy.getForeground() == Color.RED || Panel.tfMeatEnergy.getForeground() == Color.RED) {
                    JOptionPane.showMessageDialog((Component) null, "Change red strings for apply settings.");
                    return;
                }
                GameField.maxDamage = Integer.parseInt(Panel.tfMaxDamage.getText()) + 1;
                GameField.plantEnergy = Integer.parseInt(Panel.tfPlantEnergy.getText());
                GameField.meatEnergy = Integer.parseInt(Panel.tfMeatEnergy.getText());
            }
        });
        Label labelLine2 = new Label("_____________________________________________", MAX_SPEED, 290, 320, 30);
        labelLine2.setForeground(Color.YELLOW);
        add(labelLine2);
        add(new Label("Info:", 145, 310, 200, 30));
        labelLiveCount = new Label("Live Cells Count: " + GameField.liveCount, 10, 340, 130, 16);
        add(labelLiveCount);
        ImageIcon imageIcon = new ImageIcon(GameField.class.getResource(Sf.resDir + "/plant.png"));
        labelPlantsNumber = new Label(" - " + GameField.plantsCount, 165, 340, 60, 16);
        labelPlantsNumber.setIcon(imageIcon);
        add(labelPlantsNumber);
        ImageIcon imageIcon2 = new ImageIcon(GameField.class.getResource(Sf.resDir + "/meat.png"));
        labelMeatNumber = new Label(" - 0", 245, 340, 60, 16);
        labelMeatNumber.setIcon(imageIcon2);
        add(labelMeatNumber);
        iiCol[MAX_SPEED] = new ImageIcon(GameField.class.getResource(Sf.resDir + "/liveDarkRedU.png"));
        iiCol[1] = new ImageIcon(GameField.class.getResource(Sf.resDir + "/liveGreyU.png"));
        iiCol[2] = new ImageIcon(GameField.class.getResource(Sf.resDir + "/liveRedU.png"));
        iiCol[3] = new ImageIcon(GameField.class.getResource(Sf.resDir + "/liveYelowU.png"));
        iiCol[4] = new ImageIcon(GameField.class.getResource(Sf.resDir + "/livePurpleU.png"));
        iiCol[5] = new ImageIcon(GameField.class.getResource(Sf.resDir + "/liveOrangeU.png"));
        iiCol[6] = new ImageIcon(GameField.class.getResource(Sf.resDir + "/liveGreenU.png"));
        iiCol[7] = new ImageIcon(GameField.class.getResource(Sf.resDir + "/liveBlueU.png"));
        iiCol[8] = new ImageIcon(GameField.class.getResource(Sf.resDir + "/liveLightBlueU.png"));
        iiCol[9] = new ImageIcon(GameField.class.getResource(Sf.resDir + "/livePinkU.png"));
        labelColorCount[MAX_SPEED] = new Label("", 10, 360, 60, 16);
        add(labelColorCount[MAX_SPEED]);
        labelColorCount[1] = new Label("", 10, 380, 60, 16);
        add(labelColorCount[1]);
        labelColorCount[2] = new Label("", 10, 400, 60, 16);
        add(labelColorCount[2]);
        labelColorCount[3] = new Label("", 10, 420, 60, 16);
        add(labelColorCount[3]);
        labelColorCount[4] = new Label("", 10, 440, 60, 16);
        add(labelColorCount[4]);
        labelColorCount[5] = new Label("", 100, 360, 60, 16);
        add(labelColorCount[5]);
        labelColorCount[6] = new Label("", 100, 380, 60, 16);
        add(labelColorCount[6]);
        labelColorCount[7] = new Label("", 100, 400, 60, 16);
        add(labelColorCount[7]);
        labelColorCount[8] = new Label("", 100, 420, 60, 16);
        add(labelColorCount[8]);
        labelColorCount[9] = new Label("", 100, 440, 60, 16);
        add(labelColorCount[9]);
        labelLiveNumber = new Label("Number of Last Cell", 10, 460, 300, 15);
        add(labelLiveNumber);
        Button btnHideInfo = new Button("Hide Info", 230, 425, 80, 30);
        add(btnHideInfo);
        final Button button = btnHideInfo;
        btnHideInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (button.getText().equals("Hide Info")) {
                    button.setText("Show Info");
                    for (int i = Panel.MAX_SPEED; i < 10; i++) {
                        Panel.labelColorCount[i].setIcon((Icon) null);
                        Panel.labelColorCount[i].setText("");
                    }
                    Panel.labelLiveCount.setVisible(false);
                    Panel.labelPlantsNumber.setVisible(false);
                    Panel.labelMeatNumber.setVisible(false);
                    Panel.labelLiveNumber.setVisible(false);
                    return;
                }
                button.setText("Hide Info");
                GameField.countCellsMeatPlants();
                Panel.labelLiveNumber.setText("Count of All Created Cells: " + GameField.allCellsCount);
                Panel.labelLiveCount.setVisible(true);
                Panel.labelPlantsNumber.setVisible(true);
                Panel.labelMeatNumber.setVisible(true);
                Panel.labelLiveNumber.setVisible(true);
            }
        });
        Label labelLine3 = new Label("_____________________________________________", MAX_SPEED, 465, 320, 15);
        labelLine3.setForeground(Color.YELLOW);
        add(labelLine3);
        add(new Label("Selected Cell:", 115, 485, 200, 15));
        rbYoungest = new RadioButton("Youngest", 10, 500, 80, 15);
        bGroup.add(rbYoungest);
        rbYoungest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameField.rbSelectedCell();
                GameField.selectedCell();
                MainWindow.mainGameField.repaint();
            }
        });
        add(rbYoungest);
        rbOldest = new RadioButton("Oldest", 100, 500, 65, 15);
        bGroup.add(rbOldest);
        rbOldest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameField.rbSelectedCell();
                GameField.selectedCell();
                MainWindow.mainGameField.repaint();
            }
        });
        add(rbOldest);
        rbMostProlific = new RadioButton("Most Prolific", 175, 500, 100, 15);
        bGroup.add(rbMostProlific);
        rbMostProlific.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameField.rbSelectedCell();
                GameField.selectedCell();
                MainWindow.mainGameField.repaint();
            }
        });
        add(rbMostProlific);
        labelSelectedCellIcon = new Label("", 10, 520, 310, 16);
        labelSelectedCellIcon.setForeground(Color.RED);
        add(labelSelectedCellIcon);
        labelSelectedCellNumber = new Label("", 10, 540, 310, 15);
        add(labelSelectedCellNumber);
        labelSelectedCellAge = new Label("", 10, 555, 310, 15);
        add(labelSelectedCellAge);
        labelSelectedCellMaxAge = new Label("", 10, 570, 310, 15);
        add(labelSelectedCellMaxAge);
        labelSelectedCellEnergy = new Label("", 10, 585, 310, 15);
        add(labelSelectedCellEnergy);
        labelSelectedCellEnergyForDivision = new Label("", 10, 600, 310, 15);
        add(labelSelectedCellEnergyForDivision);
        labelSelectedCellChanceOfMutation = new Label("", 10, 615, 310, 15);
        add(labelSelectedCellChanceOfMutation);
        labelSelectedCellKills = new Label("", 10, 630, 310, 15);
        add(labelSelectedCellKills);
        labelSelectedCellNumberOfChildren = new Label("", 10, 645, 310, 15);
        add(labelSelectedCellNumberOfChildren);
        labelSelectedCellEatenPlants = new Label("", 10, 660, 310, 15);
        add(labelSelectedCellEatenPlants);
        labelSelectedCellEatenMeat = new Label("", 10, 675, 310, 15);
        add(labelSelectedCellEatenMeat);
        ImageIcon imageIcon3 = new ImageIcon(GameField.class.getResource(Sf.resDir + "/wall.png"));
        iiLiveAnyColorU = new ImageIcon(GameField.class.getResource(Sf.resDir + "/liveAnyColorU.png"));
        iiarrowUP = new ImageIcon(GameField.class.getResource(Sf.resDir + "/arrowUP.png"));
        iiarrowRight = new ImageIcon(GameField.class.getResource(Sf.resDir + "/arrowRight.png"));
        iiarrowLeft = new ImageIcon(GameField.class.getResource(Sf.resDir + "/arrowLeft.png"));
        iieatPlant = new ImageIcon(GameField.class.getResource(Sf.resDir + "/eatPlant.png"));
        iieatMeat = new ImageIcon(GameField.class.getResource(Sf.resDir + "/eatMeat.png"));
        iiknife = new ImageIcon(GameField.class.getResource(Sf.resDir + "/knife.png"));
        iinoKnife = new ImageIcon(GameField.class.getResource(Sf.resDir + "/noKnife.png"));
        iipause = new ImageIcon(GameField.class.getResource(Sf.resDir + "/pause.png"));
        Object[] columnNames = new Object[8];
        columnNames[MAX_SPEED] = "Gen";
        columnNames[1] = "None";
        columnNames[2] = "";
        columnNames[3] = "";
        columnNames[4] = "";
        columnNames[5] = "";
        columnNames[6] = "";
        columnNames[7] = "";
        model = new DefaultTableModel(new Object[MAX_SPEED][], columnNames) {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case Panel.MAX_SPEED /*0*/:
                        return Object.class;
                    default:
                        return ImageIcon.class;
                }
            }
        };
        tableGen = new JTable(model);
        SetIcon(tableGen, 2, iiLiveAnyColorU, "");
        SetIcon(tableGen, 4, imageIcon2, "");
        SetIcon(tableGen, 5, imageIcon, "");
        SetIcon(tableGen, 6, imageIcon3, "");
        SetIcon(tableGen, 7, iinoKnife, "");
        tableGen.setBackground(Color.BLACK);
        tableGen.setForeground(Color.WHITE);
        tableGen.setGridColor(Color.white);
        tableGen.setBorder(new LineBorder(Color.WHITE));
        tableGen.setRowHeight(Sf.t(19));
        tableGen.getColumnModel().getColumn(MAX_SPEED).setMinWidth(70);
        tableGen.getColumnModel().getColumn(1).setMinWidth(30);
        tableGen.setSelectionBackground(Color.GRAY);
        tableGen.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tableGen.setColumnSelectionAllowed(true);
        tableGen.setRowSelectionAllowed(true);
        JTableHeader headerTableGen = tableGen.getTableHeader();
        headerTableGen.setBackground(Color.BLACK);
        headerTableGen.setForeground(Color.WHITE);
        spTableGen = new JScrollPane(tableGen);
        spTableGen.setBounds(Sf.t(10), Sf.t(690), Sf.t(300), Sf.t(270));
        spTableGen.setBackground(Color.BLACK);
        spTableGen.getVerticalScrollBar().setBackground(Color.BLACK);
        spTableGen.setVisible(true);
        add(spTableGen);
        Button btnHideTable = new Button("Hide Table", 230, 660, 80, 30);
        add(btnHideTable);
        final Button button2 = btnHideTable;
        btnHideTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (button2.getText().equals("Hide Table")) {
                    button2.setText("Show Table");
                    Panel.spTableGen.setVisible(false);
                    return;
                }
                button2.setText("Hide Table");
                Panel.spTableGen.setVisible(true);
                GameField.addDataToTable();
                GameField.selectTableCell();
            }
        });
    }

    public static void SetIcon(JTable table, int col_index, ImageIcon icon, String name) {
        table.getTableHeader().getColumnModel().getColumn(col_index).setHeaderRenderer(new iconRenderer());
        table.getColumnModel().getColumn(col_index).setHeaderValue(new txtIcon(name, icon));
    }

    /* renamed from: Panel$iconRenderer */
    public static class iconRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
            txtIcon i = (txtIcon) obj;
            if (obj == i) {
                setIcon(i.imageIcon);
                setText(i.txt);
            }
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            setHorizontalAlignment(Panel.MAX_SPEED);
            return this;
        }
    }

    /* renamed from: Panel$txtIcon */
    public static class txtIcon {
        ImageIcon imageIcon;
        String txt;

        txtIcon(String text, ImageIcon icon) {
            this.txt = text;
            this.imageIcon = icon;
        }
    }

    public static void pauseSimulation() {
        String text = btnPause.getText();
        char c = 65535;
        switch (text.hashCode()) {
            case 76887510:
                if (text.equals("Pause")) {
                    c = 0;
                    break;
                }
                break;
            case 80204866:
                if (text.equals("Start")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case MAX_SPEED /*0*/:
                GameField.timer.stop();
                btnPause.setText("Start");
                btnPause.setBackground(Color.RED);
                return;
            case 1:
                GameField.timer.start();
                btnPause.setText("Pause");
                btnPause.setBackground(Color.BLACK);
                return;
            default:
                return;
        }
    }
}

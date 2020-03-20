package defpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/* renamed from: GameField  reason: default package */
public class GameField extends JPanel implements ActionListener {
    public static ImageIcon[] actionForDifferentColor = new ImageIcon[999999];
    public static ImageIcon[] actionForMeat = new ImageIcon[999999];
    public static ImageIcon[] actionForNone = new ImageIcon[9999999];
    public static ImageIcon actionForNoneBite;
    public static ImageIcon[] actionForPlant = new ImageIcon[999999];
    public static ImageIcon[] actionForSameColor = new ImageIcon[999999];
    public static ImageIcon[] actionForWall = new ImageIcon[999999];
    public static long allCellsCount = 0;
    public static Cell[] cell = new Cell[99999999];
    public static Cell cellForViewGen1;
    public static int[] collorCount = new int[10];
    public static int colorOpenedCell = -1;
    public static int emptyCells = 0;
    public static int emptyCount;
    public static int firstEnergy = 100;
    public static Image frame;
    public static int genLength = 30;
    public static ImageIcon iiliveBlueU;
    public static ImageIcon iiliveBlueUR;
    public static ImageIcon iiliveDarkRedU;
    public static ImageIcon iiliveDarkRedUR;
    public static ImageIcon iiliveGreenU;
    public static ImageIcon iiliveGreenUR;
    public static ImageIcon iiliveGreyU;
    public static ImageIcon iiliveGreyUR;
    public static ImageIcon iiliveLightBlueU;
    public static ImageIcon iiliveLightBlueUR;
    public static ImageIcon iiliveOrangeU;
    public static ImageIcon iiliveOrangeUR;
    public static ImageIcon iilivePinkU;
    public static ImageIcon iilivePinkUR;
    public static ImageIcon iilivePurpleU;
    public static ImageIcon iilivePurpleUR;
    public static ImageIcon iiliveRedU;
    public static ImageIcon iiliveRedUR;
    public static ImageIcon iiliveYelowU;
    public static ImageIcon iiliveYelowUR;
    public static short liveCount = 10;
    public static short liveNumber = liveCount;
    public static int lookSideOpenedCell = -1;
    public static int mapHeight = 60;
    public static int mapWidth = 60;
    public static int[][] map = ((int[][]) Array.newInstance(Integer.TYPE, new int[]{mapWidth, mapHeight}));
    public static int[][] empty = ((int[][]) Array.newInstance(Integer.TYPE, new int[]{2, mapWidth * mapHeight}));
    public static int maxAgeLive = 10000;
    public static int maxDamage = 21;
    public static int maxEnergyForDivision = 10000;
    public static int maxPercent;
    public static Image meat;
    public static int meatEnergy = 30;
    public static int minEnergyForDivision = 50;
    public static int[] noLife = new int[73];
    public static int numberOfCells = 0;
    public static int oldestCell = 0;
    public static int percent;
    public static Image plant;
    public static int plantEnergy = 20;
    public static int plantsCount = 1000;
    public static int plantsNumber = 0;
    public static int plantsSpeed = 5;
    public static int r;
    public static int space;
    public static int speed = 1000;
    public static int steps = 0;
    public static int tableHeight = 190;
    public static Timer timer;
    public static Image wall;
    public static int x;
    public static int y;
    private final byte DOT_SIZE = 16;

    public GameField() {
        Panel.rbMostProlific.setSelected(true);
        setBackground(Color.black);
        loadImages();
        timer = new Timer(speed, this);
        mouse();
        initGame();
    }

    public static void initGame() {
        boolean z;
        emptyCells = 0;
        cellForViewGen1 = null;
        allCellsCount = 0;
        int c = 2720;
        for (int i = 0; i < 6; i++) {
            noLife[i] = c;
            c++;
        }
        int c2 = 3120;
        for (int i2 = 6; i2 < 12; i2++) {
            noLife[i2] = c2;
            c2++;
        }
        int c3 = 2228;
        for (int i3 = 12; i3 < 18; i3++) {
            noLife[i3] = c3;
            c3++;
        }
        int c4 = 2928;
        for (int i4 = 18; i4 < 24; i4++) {
            noLife[i4] = c4;
            c4++;
        }
        int c5 = 3328;
        for (int i5 = 24; i5 < 30; i5++) {
            noLife[i5] = c5;
            c5++;
        }
        int c6 = 3928;
        for (int i6 = 30; i6 < 36; i6++) {
            noLife[i6] = c6;
            c6++;
        }
        int c7 = 3421;
        for (int i7 = 36; i7 < 40; i7++) {
            noLife[i7] = c7;
            c7++;
        }
        int c8 = 3821;
        for (int i8 = 40; i8 < 44; i8++) {
            noLife[i8] = c8;
            c8++;
        }
        int c9 = 3520;
        for (int i9 = 44; i9 < 47; i9++) {
            noLife[i9] = c9;
            c9 += 100;
        }
        int c10 = 3525;
        for (int i10 = 47; i10 < 50; i10++) {
            noLife[i10] = c10;
            c10 += 100;
        }
        int c11 = 2333;
        for (int i11 = 50; i11 < 53; i11++) {
            noLife[i11] = c11;
            c11 += 100;
        }
        int c12 = 3428;
        for (int i12 = 53; i12 < 56; i12++) {
            noLife[i12] = c12;
            c12 += 100;
        }
        int c13 = 4028;
        for (int i13 = 56; i13 < 59; i13++) {
            noLife[i13] = c13;
            c13 += 100;
        }
        int c14 = 4033;
        for (int i14 = 59; i14 < 62; i14++) {
            noLife[i14] = c14;
            c14 += 100;
        }
        noLife[62] = 2821;
        noLife[63] = 2922;
        noLife[64] = 3023;
        noLife[65] = 2828;
        noLife[66] = 3028;
        noLife[67] = 3033;
        noLife[68] = 3430;
        noLife[69] = 3530;
        noLife[70] = 4030;
        noLife[71] = 4130;
        noLife[72] = 2833;
        int i15 = 0;
        while (i15 < mapWidth) {
            int j = 0;
            while (j < mapHeight) {
                if (i15 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if ((j == mapHeight + -1) || ((z | (j == 0)) | (i15 == mapWidth + -1))) {
                    map[i15][j] = -1;
                } else {
                    map[i15][j] = -4;
                }
                j++;
            }
            i15++;
        }
        int i16 = 0;
        while (i16 < liveCount) {
            x = new Random().nextInt(mapWidth - 1) + 1;
            y = new Random().nextInt(mapHeight - 1) + 1;
            if (map[y][x] == -4) {
                cell[numberOfCells] = new Cell();
                i16++;
            }
        }
        for (int i17 = 0; i17 < plantsCount; i17++) {
            createPlant();
        }
        timer.start();
    }

    public void mouse() {
        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                int i = e.getY() / 16;
                int j = e.getX() / 16;
                if (GameField.map[i][j] >= 0) {
                    Panel.bGroup.clearSelection();
                    GameField.cellForViewGen1 = GameField.cell[GameField.map[i][j]];
                    Panel.labelSelectedCellIcon.setText("");
                    Panel.labelSelectedCellIcon.setIcon(GameField.cell[GameField.map[i][j]].picture);
                    Panel.labelSelectedCellNumber.setText("№: " + GameField.cell[GameField.map[i][j]].number);
                    Panel.labelSelectedCellAge.setText("Age: " + (GameField.cell[GameField.map[i][j]].gen[6] - GameField.cell[GameField.map[i][j]].stepsForDeath));
                    Panel.labelSelectedCellMaxAge.setText("Max Age: " + GameField.cell[GameField.map[i][j]].gen[6]);
                    Panel.labelSelectedCellEnergy.setText("Energy: " + GameField.cell[GameField.map[i][j]].energy);
                    Panel.labelSelectedCellEnergyForDivision.setText("Energy For Division: " + GameField.cell[GameField.map[i][j]].gen[4]);
                    Panel.labelSelectedCellChanceOfMutation.setText("Chance Of Mutation: " + GameField.cell[GameField.map[i][j]].gen[5] + "%");
                    Panel.labelSelectedCellKills.setText("Kills: " + GameField.cell[GameField.map[i][j]].kills);
                    Panel.labelSelectedCellNumberOfChildren.setText("Children: " + GameField.cell[GameField.map[i][j]].numberOfCildren);
                    Panel.labelSelectedCellEatenPlants.setText("Eaten Plants: " + GameField.cell[GameField.map[i][j]].eatenPlants);
                    Panel.labelSelectedCellEatenMeat.setText("Eaten Meat: " + GameField.cell[GameField.map[i][j]].eatenMeat);
                }
                GameField.selectedCell();
                GameField.this.repaint();
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public static void selectedCell() {
        if (cellForViewGen1 != null) {
            if (cellForViewGen1.energy <= 0) {
                if (Panel.labelSelectedCellIcon.getText().equals("")) {
                    Panel.labelSelectedCellEnergy.setText("Energy: 0");
                    switch (cellForViewGen1.causeOfDeath) {
                        case 1:
                            Panel.labelSelectedCellIcon.setText(" - Death (Low Energy)");
                            break;
                        case 2:
                            Panel.labelSelectedCellIcon.setText(" - Death (Age)");
                            Panel.labelSelectedCellAge.setText("Age: " + cellForViewGen1.gen[6]);
                            break;
                        case 3:
                            Panel.labelSelectedCellIcon.setText(" - Death (Low Energy Due To a Bite)");
                            break;
                    }
                }
            } else {
                Panel.labelSelectedCellIcon.setIcon(cellForViewGen1.picture);
                Panel.labelSelectedCellNumber.setText("№: " + cellForViewGen1.number);
                Panel.labelSelectedCellAge.setText("Age: " + (cellForViewGen1.gen[6] - cellForViewGen1.stepsForDeath));
                Panel.labelSelectedCellMaxAge.setText("Max Age: " + cellForViewGen1.gen[6]);
                Panel.labelSelectedCellEnergy.setText("Energy: " + cellForViewGen1.energy);
                Panel.labelSelectedCellEnergyForDivision.setText("Energy For Division: " + cellForViewGen1.gen[4]);
                Panel.labelSelectedCellChanceOfMutation.setText("Chance Of Mutation: " + cellForViewGen1.gen[5] + "%");
                Panel.labelSelectedCellKills.setText("Kills: " + cellForViewGen1.kills);
                Panel.labelSelectedCellNumberOfChildren.setText("Children: " + cellForViewGen1.numberOfCildren);
                Panel.labelSelectedCellEatenPlants.setText("Eaten Plants: " + cellForViewGen1.eatenPlants);
                Panel.labelSelectedCellEatenMeat.setText("Eaten Meat: " + cellForViewGen1.eatenMeat);
            }
        }
        if (Panel.spTableGen.isVisible() && Panel.labelSelectedCellIcon.getText().equals("")) {
            addDataToTable();
            selectTableCell();
        }
    }

    public static void rbSelectedCell() {
        if (Panel.rbYoungest.isSelected() || Panel.rbOldest.isSelected() || Panel.rbMostProlific.isSelected()) {
            Panel.labelSelectedCellIcon.setText("");
            int i = 0;
            while (true) {
                if (i >= numberOfCells) {
                    break;
                } else if (cell[i].energy > 0) {
                    cellForViewGen1 = cell[i];
                    break;
                } else {
                    i++;
                }
            }
            cellForViewGen1 = cell[0];
            for (int i2 = 0; i2 < numberOfCells; i2++) {
                if (cellForViewGen1.gen[6] - cellForViewGen1.stepsForDeath >= cell[i2].gen[6] - cell[i2].stepsForDeath && cell[i2].energy > 0) {
                    cellForViewGen1 = cell[i2];
                }
            }
        }
        if (Panel.rbOldest.isSelected()) {
            Panel.labelSelectedCellIcon.setText("");
            cellForViewGen1 = cell[0];
            for (int i3 = 0; i3 < numberOfCells; i3++) {
                if (cellForViewGen1.gen[6] - cellForViewGen1.stepsForDeath < cell[i3].gen[6] - cell[i3].stepsForDeath && cell[i3].energy > 0) {
                    cellForViewGen1 = cell[i3];
                }
            }
        }
        if (Panel.rbMostProlific.isSelected()) {
            Panel.labelSelectedCellIcon.setText("");
            cellForViewGen1 = cell[0];
            for (int i4 = 0; i4 < numberOfCells; i4++) {
                if (cellForViewGen1.numberOfCildren < cell[i4].numberOfCildren && cell[i4].energy > 0) {
                    cellForViewGen1 = cell[i4];
                }
            }
        }
    }

    public static void addDataToTable() {
        Panel.model.getDataVector().removeAllElements();
        Panel.SetIcon(Panel.tableGen, 3, cellForViewGen1.iiliveU, "");
        switch (cellForViewGen1.gen[3]) {
            case 0:
                actionForNoneBite = Panel.iipause;
                break;
            case 1:
                actionForNoneBite = Panel.iiarrowRight;
                break;
            case 2:
                actionForNoneBite = Panel.iiarrowLeft;
                break;
        }
        for (int i = 7; i < genLength; i++) {
            int n = i - 7;
            switch (cellForViewGen1.gen[i] / 100000) {
                case 0:
                    actionForNone[n] = Panel.iipause;
                    break;
                case 1:
                    actionForNone[n] = Panel.iiarrowRight;
                    break;
                case 2:
                    actionForNone[n] = Panel.iiarrowLeft;
                    break;
                case 3:
                    actionForNone[n] = Panel.iiarrowUP;
                    break;
            }
            switch ((cellForViewGen1.gen[i] % 100000) / 10000) {
                case 0:
                    actionForDifferentColor[n] = Panel.iipause;
                    break;
                case 1:
                    actionForDifferentColor[n] = Panel.iiarrowRight;
                    break;
                case 2:
                    actionForDifferentColor[n] = Panel.iiarrowLeft;
                    break;
                case 3:
                    actionForDifferentColor[n] = Panel.iiknife;
                    break;
            }
            switch (((cellForViewGen1.gen[i] % 100000) % 10000) / 1000) {
                case 0:
                    actionForSameColor[n] = Panel.iipause;
                    break;
                case 1:
                    actionForSameColor[n] = Panel.iiarrowRight;
                    break;
                case 2:
                    actionForSameColor[n] = Panel.iiarrowLeft;
                    break;
                case 3:
                    actionForSameColor[n] = Panel.iiknife;
                    break;
            }
            switch ((((cellForViewGen1.gen[i] % 100000) % 10000) % 1000) / 100) {
                case 0:
                    actionForMeat[n] = Panel.iipause;
                    break;
                case 1:
                    actionForMeat[n] = Panel.iiarrowRight;
                    break;
                case 2:
                    actionForMeat[n] = Panel.iiarrowLeft;
                    break;
                case 3:
                    actionForMeat[n] = Panel.iieatMeat;
                    break;
            }
            switch (((((cellForViewGen1.gen[i] % 100000) % 10000) % 1000) % 100) / 10) {
                case 0:
                    actionForPlant[n] = Panel.iipause;
                    break;
                case 1:
                    actionForPlant[n] = Panel.iiarrowRight;
                    break;
                case 2:
                    actionForPlant[n] = Panel.iiarrowLeft;
                    break;
                case 3:
                    actionForPlant[n] = Panel.iieatPlant;
                    break;
            }
            switch (((((cellForViewGen1.gen[i] % 100000) % 10000) % 1000) % 100) % 10) {
                case 0:
                    actionForWall[n] = Panel.iipause;
                    break;
                case 1:
                    actionForWall[n] = Panel.iiarrowRight;
                    break;
                case 2:
                    actionForWall[n] = Panel.iiarrowLeft;
                    break;
            }
        }
        Panel.model.addRow(new Object[]{"Pain U", actionForNone[0], actionForDifferentColor[0], actionForSameColor[0], actionForMeat[0], actionForPlant[0], actionForWall[0], actionForNoneBite});
        Panel.model.addRow(new Object[]{"Pain UR", actionForNone[1], actionForDifferentColor[1], actionForSameColor[1], actionForMeat[1], actionForPlant[1], actionForWall[1], actionForNoneBite});
        Panel.model.addRow(new Object[]{"Pain R", actionForNone[2], actionForDifferentColor[2], actionForSameColor[2], actionForMeat[2], actionForPlant[2], actionForWall[2], actionForNoneBite});
        Panel.model.addRow(new Object[]{"Pain DR", actionForNone[3], actionForDifferentColor[3], actionForSameColor[3], actionForMeat[3], actionForPlant[3], actionForWall[3], actionForNoneBite});
        Panel.model.addRow(new Object[]{"Pain D", actionForNone[4], actionForDifferentColor[4], actionForSameColor[4], actionForMeat[4], actionForPlant[4], actionForWall[4], actionForNoneBite});
        Panel.model.addRow(new Object[]{"Pain DL", actionForNone[5], actionForDifferentColor[5], actionForSameColor[5], actionForMeat[5], actionForPlant[5], actionForWall[5], actionForNoneBite});
        Panel.model.addRow(new Object[]{"Pain L", actionForNone[6], actionForDifferentColor[6], actionForSameColor[6], actionForMeat[6], actionForPlant[6], actionForWall[6], actionForNoneBite});
        Panel.model.addRow(new Object[]{"Pain UL", actionForNone[7], actionForDifferentColor[7], actionForSameColor[7], actionForMeat[7], actionForPlant[7], actionForWall[7], actionForNoneBite});
        for (int i2 = 8; i2 < genLength - 7; i2++) {
            Panel.model.addRow(new Object[]{"Gen" + String.valueOf(i2 - 7), actionForNone[i2], actionForDifferentColor[i2], actionForSameColor[i2], actionForMeat[i2], actionForPlant[i2], actionForWall[i2], actionForNoneBite});
        }
        if (genLength < 20) {
            for (int i3 = genLength; i3 < 20; i3++) {
                Panel.model.addRow(new Object[]{"", "", "", "", "", "", "", ""});
            }
        }
        Panel.tableGen.getTableHeader().repaint();
        Panel.model.fireTableDataChanged();
    }

    public static void selectTableCell() {
        int row;
        int col;
        if (cellForViewGen1.painSideForTable > -1) {
            row = cellForViewGen1.selfPainSide;
        } else if (cellForViewGen1.activeGen == 15) {
            row = genLength - 8;
        } else {
            row = cellForViewGen1.activeGen - 8;
        }
        switch (cellForViewGen1.front) {
            case -4:
                col = 1;
                break;
            case -3:
                col = 4;
                break;
            case -2:
                col = 5;
                break;
            case -1:
                col = 6;
                break;
            default:
                if (!cellForViewGen1.cantBite) {
                    for (int i = 0; i < map.length; i++) {
                        for (int j = 0; j < map[i].length; j++) {
                            if (map[i][j] < -4) {
                                System.out.println("i = " + i + "; j = " + j + "; map[i][j] = " + map[i][j]);
                            }
                        }
                    }
                    if (cellForViewGen1.front < -4) {
                        System.out.println("cellForViewGen1.number = " + cellForViewGen1.number);
                        System.out.println("cellForViewGen1.gen[1] = " + cellForViewGen1.gen[1]);
                        System.out.println("cellForViewGen1.front = " + cellForViewGen1.front);
                        for (int i2 = 0; i2 < map.length; i2++) {
                            for (int j2 = 0; j2 < map[i2].length; j2++) {
                                if (map[i2][j2] == 2) {
                                }
                                System.out.print(map[i2][j2] + "\t");
                            }
                            System.out.println();
                        }
                    }
                    if (cell[cellForViewGen1.front].gen[1] != cellForViewGen1.gen[1]) {
                        col = 2;
                        break;
                    } else {
                        col = 3;
                        break;
                    }
                } else {
                    col = 7;
                    break;
                }
        }
        Panel.tableGen.changeSelection(row, col, false, false);
    }

    public static void createPlant() {
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                if (map[i][j] == -4) {
                    empty[0][emptyCount] = i;
                    empty[1][emptyCount] = j;
                    emptyCount++;
                }
            }
        }
        r = new Random().nextInt(emptyCount);
        map[empty[0][r]][empty[1][r]] = -2;
        plantsNumber++;
        emptyCount = 0;
    }

    public void action() {
        if (liveNumber > 0) {
            for (int i = 0; i < numberOfCells; i++) {
                if (cell[i].energy > 0) {
                    cell[i].action();
                }
            }
            oldestCell = 0;
            if (cell[oldestCell].energy <= 0 && liveNumber > 0) {
                while (cell[oldestCell].energy <= 0) {
                    oldestCell++;
                }
            }
            if (oldestCell > 0) {
                for (int i2 = 0; i2 < numberOfCells - oldestCell; i2++) {
                    cell[i2] = cell[oldestCell + i2];
                    int[] iArr = cell[i2].gen;
                    iArr[0] = iArr[0] - oldestCell;
                }
                numberOfCells -= oldestCell;
            }
            for (int i3 = 0; i3 < mapHeight; i3++) {
                for (int j = 0; j < mapWidth; j++) {
                    if (map[i3][j] >= 0) {
                        int[] iArr2 = map[i3];
                        iArr2[j] = iArr2[j] - oldestCell;
                    }
                }
            }
            return;
        }
        for (int i4 = 0; i4 < 10; i4++) {
            Panel.labelColorCount[i4].setIcon((Icon) null);
            Panel.labelColorCount[i4].setText("");
        }
        if (emptyCells < 73) {
            if (map[noLife[emptyCells] % 100][noLife[emptyCells] / 100] == -4 || map[noLife[emptyCells] % 100][noLife[emptyCells] / 100] == -2) {
                map[noLife[emptyCells] % 100][noLife[emptyCells] / 100] = -5;
            }
            if (map[noLife[emptyCells] % 100][noLife[emptyCells] / 100] == -3) {
                map[noLife[emptyCells] % 100][noLife[emptyCells] / 100] = -6;
            }
            emptyCells++;
            return;
        }
        for (int i5 = 0; i5 < mapHeight; i5++) {
            for (int j2 = 0; j2 < mapWidth; j2++) {
                if (!(map[i5][j2] == -5 || map[i5][j2] == -4 || map[i5][j2] == -1 || map[i5][j2] == -6)) {
                    empty[0][emptyCount] = i5;
                    empty[1][emptyCount] = j2;
                    emptyCount++;
                }
            }
        }
        if (emptyCount > 0) {
            r = new Random().nextInt(emptyCount);
            map[empty[0][r]][empty[1][r]] = -4;
            emptyCount = 0;
            return;
        }
        timer.stop();
    }

    public static void countCellsMeatPlants() {
        int m = 0;
        int p = 0;
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                if (map[i][j] >= 0) {
                    int[] iArr = collorCount;
                    int i2 = cell[map[i][j]].gen[1];
                    iArr[i2] = iArr[i2] + 1;
                }
                if (map[i][j] == -2) {
                    p++;
                }
                if (map[i][j] == -3) {
                    m++;
                }
            }
        }
        Panel.labelPlantsNumber.setText(" - " + p);
        Panel.labelMeatNumber.setText(" - " + m);
        int max = 0;
        int col = 0;
        for (int i3 = 0; i3 < 10; i3++) {
            for (int j2 = 0; j2 < 10; j2++) {
                if (max < collorCount[j2]) {
                    max = collorCount[j2];
                    col = j2;
                }
            }
            if (max > 0) {
                Panel.labelColorCount[i3].setIcon(Panel.iiCol[col]);
                Panel.labelColorCount[i3].setText(" - " + max);
                collorCount[col] = 0;
            } else {
                Panel.labelColorCount[i3].setIcon((Icon) null);
                Panel.labelColorCount[i3].setText("");
            }
            max = 0;
        }
    }

    public void loadImages() {
        wall = new ImageIcon(GameField.class.getResource(Sf.resDir+"/wall.png")).getImage();
        plant = new ImageIcon(GameField.class.getResource(Sf.resDir+"/plant.png")).getImage();
        meat = new ImageIcon(GameField.class.getResource(Sf.resDir+"/meat.png")).getImage();
        frame = new ImageIcon(GameField.class.getResource(Sf.resDir+"/frame.png")).getImage();
        iiliveDarkRedU = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveDarkRedU.png"));
        iiliveDarkRedUR = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveDarkRedUR.png"));
        iiliveGreyU = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveGreyU.png"));
        iiliveGreyUR = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveGreyUR.png"));
        iiliveRedU = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveRedU.png"));
        iiliveRedUR = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveRedUR.png"));
        iiliveYelowU = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveYelowU.png"));
        iiliveYelowUR = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveYelowUR.png"));
        iilivePurpleU = new ImageIcon(GameField.class.getResource(Sf.resDir+"/livePurpleU.png"));
        iilivePurpleUR = new ImageIcon(GameField.class.getResource(Sf.resDir+"/livePurpleUR.png"));
        iiliveOrangeU = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveOrangeU.png"));
        iiliveOrangeUR = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveOrangeUR.png"));
        iiliveGreenU = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveGreenU.png"));
        iiliveGreenUR = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveGreenUR.png"));
        iiliveBlueU = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveBlueU.png"));
        iiliveBlueUR = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveBlueUR.png"));
        iiliveLightBlueU = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveLightBlueU.png"));
        iiliveLightBlueUR = new ImageIcon(GameField.class.getResource(Sf.resDir+"/liveLightBlueUR.png"));
        iilivePinkU = new ImageIcon(GameField.class.getResource(Sf.resDir+"/livePinkU.png"));
        iilivePinkUR = new ImageIcon(GameField.class.getResource(Sf.resDir+"/livePinkUR.png"));
    }

    /* access modifiers changed from: protected */
    public void paintComponent(Graphics g) {
        GameField.super.paintComponent(g);
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                if (map[i][j] == -1) {
                    g.drawImage(wall, j * Sf.t(16), i * Sf.t(16), this);
                }
                if (map[i][j] == -3 || map[i][j] == -6) {
                    g.drawImage(meat, j * Sf.t(16), i *Sf.t( 16), this);
                }
                if (map[i][j] >= 0) {
                    cell[map[i][j]].picture.paintIcon(this, g, j *Sf.t( 16), i *Sf.t( 16));
                }
                if (map[i][j] == -2 || map[i][j] == -5) {
                    g.drawImage(plant, j * Sf.t(16), i *Sf.t( 16), this);
                }
            }
        }
        if (cellForViewGen1 != null && cellForViewGen1.energy > 0) {
            g.drawImage(frame, (cellForViewGen1.coordX * Sf.t(16)) - 1, (cellForViewGen1.coordY *Sf.t( 16)) - 1, this);
        }
    }

    public void actionPerformed(ActionEvent e) {
        steps++;
        action();
        rbSelectedCell();
        selectedCell();
        if (liveNumber > 0) {
            if (Panel.labelLiveCount.isVisible()) {
                countCellsMeatPlants();
            }
            for (int i = 1; i < mapWidth; i++) {
                for (int j = 1; j < mapHeight; j++) {
                    if (map[i][j] == -4) {
                        space++;
                    }
                }
            }
            if (space > 1) {
                switch (plantsSpeed) {
                    case 1:
                        if (steps % 40 == 0) {
                            createPlant();
                            break;
                        }
                        break;
                    case 2:
                        if (steps % 30 == 0) {
                            createPlant();
                            break;
                        }
                        break;
                    case 3:
                        if (steps % 20 == 0) {
                            createPlant();
                            break;
                        }
                        break;
                    case 4:
                        if (steps % 10 == 0) {
                            createPlant();
                            break;
                        }
                        break;
                    case 5:
                        createPlant();
                        break;
                    case 6:
                        for (int i2 = 0; i2 < 10; i2++) {
                            if (space > 1) {
                                createPlant();
                                space--;
                            }
                        }
                        break;
                    case 7:
                        for (int i3 = 0; i3 < 20; i3++) {
                            if (space > 1) {
                                createPlant();
                                space--;
                            }
                        }
                        break;
                    case 8:
                        for (int i4 = 0; i4 < 30; i4++) {
                            if (space > 1) {
                                createPlant();
                                space--;
                            }
                        }
                        break;
                    case 9:
                        for (int i5 = 0; i5 < 40; i5++) {
                            if (space > 1) {
                                createPlant();
                                space--;
                            }
                        }
                        break;
                    case 10:
                        for (int i6 = 0; i6 < 50; i6++) {
                            if (space > 1) {
                                createPlant();
                                space--;
                            }
                        }
                        break;
                }
            }
            space = 0;
        }
        repaint();
        if (Panel.labelLiveCount.isVisible()) {
            Panel.labelLiveCount.setText("Live Cells Count: " + liveNumber);
        }
    }
}

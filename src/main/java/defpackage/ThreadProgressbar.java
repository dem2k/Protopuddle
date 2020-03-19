package defpackage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.SwingWorker;

/* renamed from: ThreadProgressbar  reason: default package */
public class ThreadProgressbar extends SwingWorker {
    /* access modifiers changed from: private */
    public FrameProgressBar frameProgressBar = new FrameProgressBar();

    public ThreadProgressbar() {
        addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equals(evt.getPropertyName())) {
                    ThreadProgressbar.this.frameProgressBar.Value(((Integer) evt.getNewValue()).intValue());
                }
            }
        });
        this.frameProgressBar.MinMax(0, 100);
    }

    public Void doInBackground() {
        File fileOpenPuddle = Panel.fcOpenPuddle.getSelectedFile();
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileOpenPuddle);
            try {
                prop.load(fileInputStream);
                GameField.mapWidth = Integer.valueOf(prop.getProperty("mapWidth")).intValue();
                GameField.mapHeight = Integer.valueOf(prop.getProperty("mapHeight")).intValue();
                GameField.maxDamage = Integer.valueOf(prop.getProperty("maxDamage")).intValue();
                Panel.tfMaxDamage.setText(String.valueOf(GameField.maxDamage - 1));
                GameField.genLength = Integer.valueOf(prop.getProperty("genLength")).intValue();
                GameField.maxEnergyForDivision = Integer.valueOf(prop.getProperty("maxEnergyForDivision")).intValue();
                GameField.minEnergyForDivision = Integer.valueOf(prop.getProperty("minEnergyForDivision")).intValue();
                GameField.liveCount = Short.valueOf(prop.getProperty("liveCount")).shortValue();
                GameField.liveNumber = Short.valueOf(prop.getProperty("liveNumber")).shortValue();
                GameField.firstEnergy = Integer.valueOf(prop.getProperty("firstEnergy")).intValue();
                GameField.plantsCount = Integer.valueOf(prop.getProperty("plantsCount")).intValue();
                GameField.plantEnergy = Integer.valueOf(prop.getProperty("plantEnergy")).intValue();
                Panel.tfPlantEnergy.setText(prop.getProperty("plantEnergy"));
                GameField.meatEnergy = Integer.valueOf(prop.getProperty("meatEnergy")).intValue();
                Panel.tfMeatEnergy.setText(prop.getProperty("meatEnergy"));
                GameField.plantsNumber = Integer.valueOf(prop.getProperty("plantsNumber")).intValue();
                GameField.x = Integer.valueOf(prop.getProperty("x")).intValue();
                GameField.y = Integer.valueOf(prop.getProperty("y")).intValue();
                GameField.numberOfCells = Integer.valueOf(prop.getProperty("numberOfCells")).intValue();
                GameField.speed = Integer.valueOf(prop.getProperty("speed")).intValue();
                GameField.steps = Integer.valueOf(prop.getProperty("steps")).intValue();
                GameField.plantsSpeed = Integer.valueOf(prop.getProperty("plantsSpeed")).intValue();
                Panel.sliderPlantsSpeed.setValue(Integer.valueOf(prop.getProperty("plantsSpeed")).intValue());
                GameField.maxAgeLive = Integer.valueOf(prop.getProperty("maxAgeLive")).intValue();
                GameField.allCellsCount = Long.valueOf(prop.getProperty("allCellsCount")).longValue();
                GameField.emptyCells = Integer.valueOf(prop.getProperty("emptyCells")).intValue();
                GameField.space = Integer.valueOf(prop.getProperty("space")).intValue();
                GameField.r = Integer.valueOf(prop.getProperty("r")).intValue();
                int n = GameField.numberOfCells;
                GameField.numberOfCells = 0;
                GameField.cell = new Cell[99999999];
                for (int i = 0; i < n; i++) {
                    GameField.x = Integer.valueOf(prop.getProperty("cell[" + i + "].coordX")).intValue();
                    GameField.y = Integer.valueOf(prop.getProperty("cell[" + i + "].coordY")).intValue();
                    int oldMapCount = GameField.map[GameField.y][GameField.x];
                    GameField.colorOpenedCell = Integer.valueOf(prop.getProperty("cell[" + i + "].gen[1]")).intValue();
                    GameField.lookSideOpenedCell = Integer.valueOf(prop.getProperty("cell[" + i + "].lookSide")).intValue();
                    GameField.cell[i] = new Cell();
                    GameField.cell[i].energy = Integer.valueOf(prop.getProperty("cell[" + i + "].energy")).intValue();
                    GameField.cell[i].painSide = Integer.valueOf(prop.getProperty("cell[" + i + "].painSide")).intValue();
                    GameField.cell[i].painSideForTable = Integer.valueOf(prop.getProperty("cell[" + i + "].painSideForTable")).intValue();
                    GameField.cell[i].selfPainSide = Integer.valueOf(prop.getProperty("cell[" + i + "].selfPainSide")).intValue();
                    GameField.cell[i].front = Integer.valueOf(prop.getProperty("cell[" + i + "].front")).intValue();
                    GameField.cell[i].activeGen = Integer.valueOf(prop.getProperty("cell[" + i + "].activeGen")).intValue();
                    GameField.cell[i].maxAge = Integer.valueOf(prop.getProperty("cell[" + i + "].maxAge")).intValue();
                    GameField.cell[i].stepsForDeath = Integer.valueOf(prop.getProperty("cell[" + i + "].stepsForDeath")).intValue();
                    GameField.cell[i].causeOfDeath = Integer.valueOf(prop.getProperty("cell[" + i + "].causeOfDeath")).intValue();
                    GameField.cell[i].food = Integer.valueOf(prop.getProperty("cell[" + i + "].food")).intValue();
                    GameField.cell[i].number = (long) Integer.valueOf(prop.getProperty("cell[" + i + "].number")).intValue();
                    GameField.cell[i].numberOfCildren = Integer.valueOf(prop.getProperty("cell[" + i + "].numberOfCildren")).intValue();
                    GameField.cell[i].kills = Integer.valueOf(prop.getProperty("cell[" + i + "].kills")).intValue();
                    GameField.cell[i].eatenPlants = Integer.valueOf(prop.getProperty("cell[" + i + "].eatenPlants")).intValue();
                    GameField.cell[i].eatenMeat = Integer.valueOf(prop.getProperty("cell[" + i + "].eatenMeat")).intValue();
                    for (int j = 0; j < GameField.genLength; j++) {
                        GameField.cell[i].gen[j] = Integer.valueOf(prop.getProperty("cell[" + i + "].gen[" + j + "]")).intValue();
                    }
                    if (GameField.cell[i].energy <= 0) {
                        GameField.map[GameField.cell[i].coordY][GameField.cell[i].coordX] = oldMapCount;
                    }
                    setProgress(i / ((n - 1) / 100));
                }
                GameField.allCellsCount = Long.valueOf(prop.getProperty("allCellsCount")).longValue();
                Panel.labelLiveNumber.setText("Count of All Created Cells: " + GameField.allCellsCount);
                Panel.labelLiveCount.setText("Live Cells Count: " + GameField.liveNumber);
                for (int i2 = 0; i2 < GameField.mapWidth; i2++) {
                    for (int j2 = 0; j2 < GameField.mapHeight; j2++) {
                        GameField.map[i2][j2] = Integer.valueOf(prop.getProperty("map[" + i2 + "][" + j2 + "]")).intValue();
                    }
                }
                FileInputStream fileInputStream2 = fileInputStream;
                return null;
            } catch (IOException e) {
                FileInputStream fileInputStream3 = fileInputStream;
                System.out.println("что-то пошло не так");
                return null;
            }
        } catch (IOException e2) {
            System.out.println("что-то пошло не так");
            return null;
        }
    }

    public void done() {
        this.frameProgressBar.setVisible(false);
        if (!Panel.isPause) {
            Panel.pauseSimulation();
            return;
        }
        Panel.rbMostProlific.setSelected(true);
        GameField.rbSelectedCell();
        GameField.selectedCell();
        GameField.countCellsMeatPlants();
        MainWindow.mainGameField.repaint();
    }
}

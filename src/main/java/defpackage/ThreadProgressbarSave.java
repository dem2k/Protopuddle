package defpackage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.swing.SwingWorker;

public class ThreadProgressbarSave extends SwingWorker {
  private FrameProgressBar frameProgressBar = new FrameProgressBar();
  
  public ThreadProgressbarSave() {
    addPropertyChangeListener(new PropertyChangeListener() {
          public void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName()))
              ThreadProgressbarSave.this.frameProgressBar.Value(((Integer)evt.getNewValue()).intValue()); 
          }
        });
    this.frameProgressBar.MinMax(0, 100);
  }
  
  protected Object doInBackground() throws Exception {
    File fileSavePuddle = Panel.fcSavePuddle.getSelectedFile();
    if (!Panel.fcSavePuddle.getSelectedFile().getAbsolutePath().endsWith(".pddl"))
      fileSavePuddle = new File(Panel.fcSavePuddle.getSelectedFile() + ".pddl"); 
    Properties prop = new Properties();
    try (FileWriter fwSavePuddle = new FileWriter(fileSavePuddle)) {
      prop.setProperty("mapWidth", String.valueOf(GameField.mapWidth));
      prop.setProperty("mapHeight", String.valueOf(GameField.mapHeight));
      prop.setProperty("maxDamage", String.valueOf(GameField.maxDamage));
      prop.setProperty("genLength", String.valueOf(GameField.genLength));
      prop.setProperty("maxEnergyForDivision", String.valueOf(GameField.maxEnergyForDivision));
      prop.setProperty("minEnergyForDivision", String.valueOf(GameField.minEnergyForDivision));
      prop.setProperty("liveCount", String.valueOf(GameField.liveCount));
      prop.setProperty("liveNumber", String.valueOf(GameField.liveNumber));
      prop.setProperty("firstEnergy", String.valueOf(GameField.firstEnergy));
      prop.setProperty("plantsCount", String.valueOf(GameField.plantsCount));
      prop.setProperty("plantEnergy", String.valueOf(GameField.plantEnergy));
      prop.setProperty("meatEnergy", String.valueOf(GameField.meatEnergy));
      prop.setProperty("plantsNumber", String.valueOf(GameField.plantsNumber));
      prop.setProperty("x", String.valueOf(GameField.x));
      prop.setProperty("y", String.valueOf(GameField.y));
      prop.setProperty("numberOfCells", String.valueOf(GameField.numberOfCells));
      prop.setProperty("speed", String.valueOf(GameField.speed));
      prop.setProperty("steps", String.valueOf(GameField.steps));
      prop.setProperty("plantsSpeed", String.valueOf(GameField.plantsSpeed));
      prop.setProperty("maxAgeLive", String.valueOf(GameField.maxAgeLive));
      prop.setProperty("allCellsCount", String.valueOf(GameField.allCellsCount));
      prop.setProperty("emptyCells", String.valueOf(GameField.emptyCells));
      prop.setProperty("space", String.valueOf(GameField.space));
      prop.setProperty("r", String.valueOf(GameField.r));
      int i;
      for (i = 0; i < GameField.mapWidth; i++) {
        for (int j = 0; j < GameField.mapHeight; j++)
          prop.setProperty("map[" + String.valueOf(i) + "][" + String.valueOf(j) + "]", String.valueOf(GameField.map[i][j])); 
      } 
      prop.store(fwSavePuddle, (String)null);
      for (i = 0; i < GameField.numberOfCells; i++) {
        prop = new Properties();
        prop.setProperty("cell[" + String.valueOf(i) + "].lookSide", String.valueOf((GameField.cell[i]).lookSide));
        prop.setProperty("cell[" + String.valueOf(i) + "].energy", String.valueOf((GameField.cell[i]).energy));
        prop.setProperty("cell[" + String.valueOf(i) + "].coordX", String.valueOf((GameField.cell[i]).coordX));
        prop.setProperty("cell[" + String.valueOf(i) + "].coordY", String.valueOf((GameField.cell[i]).coordY));
        prop.setProperty("cell[" + String.valueOf(i) + "].painSide", String.valueOf((GameField.cell[i]).painSide));
        prop.setProperty("cell[" + String.valueOf(i) + "].painSideForTable", String.valueOf((GameField.cell[i]).painSideForTable));
        prop.setProperty("cell[" + String.valueOf(i) + "].selfPainSide", String.valueOf((GameField.cell[i]).selfPainSide));
        prop.setProperty("cell[" + String.valueOf(i) + "].front", String.valueOf((GameField.cell[i]).front));
        prop.setProperty("cell[" + String.valueOf(i) + "].activeGen", String.valueOf((GameField.cell[i]).activeGen));
        prop.setProperty("cell[" + String.valueOf(i) + "].maxAge", String.valueOf((GameField.cell[i]).maxAge));
        prop.setProperty("cell[" + String.valueOf(i) + "].stepsForDeath", String.valueOf((GameField.cell[i]).stepsForDeath));
        prop.setProperty("cell[" + String.valueOf(i) + "].causeOfDeath", String.valueOf((GameField.cell[i]).causeOfDeath));
        prop.setProperty("cell[" + String.valueOf(i) + "].food", String.valueOf((GameField.cell[i]).food));
        prop.setProperty("cell[" + String.valueOf(i) + "].number", String.valueOf((GameField.cell[i]).number));
        prop.setProperty("cell[" + String.valueOf(i) + "].numberOfCildren", String.valueOf((GameField.cell[i]).numberOfCildren));
        prop.setProperty("cell[" + String.valueOf(i) + "].kills", String.valueOf((GameField.cell[i]).kills));
        prop.setProperty("cell[" + String.valueOf(i) + "].eatenPlants", String.valueOf((GameField.cell[i]).eatenPlants));
        prop.setProperty("cell[" + String.valueOf(i) + "].eatenMeat", String.valueOf((GameField.cell[i]).eatenMeat));
        for (int j = 0; j < GameField.genLength; j++)
          prop.setProperty("cell[" + String.valueOf(i) + "].gen[" + String.valueOf(j) + "]", String.valueOf((GameField.cell[i]).gen[j])); 
        prop.store(fwSavePuddle, (String)null);
        setProgress(i / (GameField.numberOfCells - 1) / 100);
      } 
    } catch (IOException e2) {
      System.out.println(e2.getMessage());
    } 
    return null;
  }
  
  public void done() {
    this.frameProgressBar.setVisible(false);
    if (!Panel.isPause)
      Panel.pauseSimulation(); 
  }
}

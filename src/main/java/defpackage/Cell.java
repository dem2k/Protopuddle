package defpackage;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/* renamed from: Cell  reason: default package */
public class Cell {
    int activeGen;
    boolean cantBite;
    int causeOfDeath = 0;
    int coordX;
    int coordY;
    int eatenMeat = 0;
    int eatenPlants = 0;
    int energy;
    int food;
    int front;
    int[] gen;
    ImageIcon iiliveU;
    ImageIcon iiliveUR;
    int kills = 0;
    int lookSide;
    int maxAge = GameField.maxAgeLive;
    long number;
    int numberOfCildren = 0;
    int painSide;
    int painSideForTable;
    public RotatedIcon picture;
    int selfPainSide;
    int stepsForDeath;

    public Cell() {
        GameField.allCellsCount++;
        this.number = GameField.allCellsCount;
        this.energy = GameField.firstEnergy;
        this.painSide = -1;
        if (GameField.lookSideOpenedCell < 0) {
            this.lookSide = new Random().nextInt(8);
        } else {
            this.lookSide = GameField.lookSideOpenedCell;
        }
        this.activeGen = 15;
        this.gen = new int[GameField.genLength];
        this.gen[0] = GameField.numberOfCells;
        if (GameField.colorOpenedCell < 0) {
            this.gen[1] = new Random().nextInt(10);
        } else {
            this.gen[1] = GameField.colorOpenedCell;
        }
        switch (this.gen[1]) {
            case 0:
                this.iiliveU = GameField.iiliveDarkRedU;
                this.iiliveUR = GameField.iiliveDarkRedUR;
                break;
            case 1:
                this.iiliveU = GameField.iiliveGreyU;
                this.iiliveUR = GameField.iiliveGreyUR;
                break;
            case 2:
                this.iiliveU = GameField.iiliveRedU;
                this.iiliveUR = GameField.iiliveRedUR;
                break;
            case 3:
                this.iiliveU = GameField.iiliveYelowU;
                this.iiliveUR = GameField.iiliveYelowUR;
                break;
            case 4:
                this.iiliveU = GameField.iilivePurpleU;
                this.iiliveUR = GameField.iilivePurpleUR;
                break;
            case 5:
                this.iiliveU = GameField.iiliveOrangeU;
                this.iiliveUR = GameField.iiliveOrangeUR;
                break;
            case 6:
                this.iiliveU = GameField.iiliveGreenU;
                this.iiliveUR = GameField.iiliveGreenUR;
                break;
            case 7:
                this.iiliveU = GameField.iiliveBlueU;
                this.iiliveUR = GameField.iiliveBlueUR;
                break;
            case 8:
                this.iiliveU = GameField.iiliveLightBlueU;
                this.iiliveUR = GameField.iiliveLightBlueUR;
                break;
            case 9:
                this.iiliveU = GameField.iilivePinkU;
                this.iiliveUR = GameField.iilivePinkUR;
                break;
        }
        if (this.lookSide % 2 == 0) {
            this.picture = new RotatedIcon((Icon) this.iiliveU, (double) ((this.lookSide / 2) * 90));
        } else {
            this.picture = new RotatedIcon((Icon) this.iiliveUR, (double) ((this.lookSide / 2) * 90));
        }
        this.gen[2] = new Random().nextInt(200001) - 100000;
        this.gen[3] = new Random().nextInt(3);
        this.gen[4] = new Random().nextInt((GameField.maxEnergyForDivision - GameField.minEnergyForDivision) + 1) + GameField.minEnergyForDivision;
        this.gen[5] = new Random().nextInt(100) + 1;
        this.gen[6] = new Random().nextInt(this.maxAge) + 1;
        this.stepsForDeath = this.gen[6];
        for (int j = 7; j < GameField.genLength; j++) {
            this.gen[j] = (new Random().nextInt(4) * 100000) + (new Random().nextInt(4) * 10000) + (new Random().nextInt(4) * 1000) + (new Random().nextInt(4) * 100) + (new Random().nextInt(4) * 10) + new Random().nextInt(3);
        }
        this.coordX = GameField.x;
        this.coordY = GameField.y;
        GameField.map[this.coordY][this.coordX] = this.gen[0];
        GameField.numberOfCells++;
        if (Panel.labelLiveCount.isVisible()) {
            Panel.labelLiveNumber.setText("Count of All Created Cells: " + GameField.allCellsCount);
        }
        GameField.colorOpenedCell = -1;
        GameField.lookSideOpenedCell = -1;
    }

    public void action() {
        this.stepsForDeath--;
        this.cantBite = false;
        look();
        if (this.painSide >= 0) {
            painReaction();
        } else {
            this.painSideForTable = -1;
            if (this.energy < this.gen[4] || this.front != -4) {
                noPainAction();
            } else {
                division();
            }
        }
        if (this.stepsForDeath <= 0 || this.energy <= 0) {
            if (this.energy <= 0) {
                this.causeOfDeath = 1;
            }
            if (this.stepsForDeath <= 0) {
                this.causeOfDeath = 2;
            }
            this.energy = 0;
            GameField.map[this.coordY][this.coordX] = -3;
            GameField.liveNumber = (short) (GameField.liveNumber - 1);
        }
    }

    public void division() {
        this.numberOfCildren++;
        GameField.liveNumber = (short) (GameField.liveNumber + 1);
        GameField.x = this.coordX;
        GameField.y = this.coordY;
        move();
        GameField.cell[GameField.numberOfCells] = new Cell();
        GameField.cell[GameField.numberOfCells - 1].energy = this.energy / 2;
        this.energy -= GameField.cell[GameField.numberOfCells - 1].energy;
        for (int i = 1; i < GameField.genLength; i++) {
            GameField.cell[GameField.numberOfCells - 1].gen[i] = this.gen[i];
        }
        GameField.cell[GameField.numberOfCells - 1].stepsForDeath = GameField.cell[GameField.numberOfCells - 1].gen[6];
        switch (GameField.cell[GameField.numberOfCells - 1].gen[1]) {
            case 0:
                GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveDarkRedU;
                GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveDarkRedUR;
                break;
            case 1:
                GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveGreyU;
                GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveGreyUR;
                break;
            case 2:
                GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveRedU;
                GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveRedUR;
                break;
            case 3:
                GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveYelowU;
                GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveYelowUR;
                break;
            case 4:
                GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iilivePurpleU;
                GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iilivePurpleUR;
                break;
            case 5:
                GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveOrangeU;
                GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveOrangeUR;
                break;
            case 6:
                GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveGreenU;
                GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveGreenUR;
                break;
            case 7:
                GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveBlueU;
                GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveBlueUR;
                break;
            case 8:
                GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveLightBlueU;
                GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveLightBlueUR;
                break;
            case 9:
                GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iilivePinkU;
                GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iilivePinkUR;
                break;
        }
        if (GameField.cell[GameField.numberOfCells - 1].lookSide % 2 == 0) {
            GameField.cell[GameField.numberOfCells - 1].picture = new RotatedIcon((Icon) GameField.cell[GameField.numberOfCells - 1].iiliveU, (double) ((GameField.cell[GameField.numberOfCells - 1].lookSide / 2) * 90));
        } else {
            GameField.cell[GameField.numberOfCells - 1].picture = new RotatedIcon((Icon) GameField.cell[GameField.numberOfCells - 1].iiliveUR, (double) ((GameField.cell[GameField.numberOfCells - 1].lookSide / 2) * 90));
        }
        if (this.gen[5] >= new Random().nextInt(100) + 1) {
            int mutationGen = new Random().nextInt(GameField.genLength - 1) + 1;
            if (mutationGen > 6) {
                GameField.cell[GameField.numberOfCells - 1].gen[mutationGen] = (new Random().nextInt(4) * 100000) + (new Random().nextInt(4) * 10000) + (new Random().nextInt(4) * 1000) + (new Random().nextInt(4) * 100) + (new Random().nextInt(4) * 10) + new Random().nextInt(3);
            }
            switch (mutationGen) {
                case 1:
                    GameField.cell[GameField.numberOfCells - 1].gen[mutationGen] = new Random().nextInt(10);
                    switch (GameField.cell[GameField.numberOfCells - 1].gen[mutationGen]) {
                        case 0:
                            GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveDarkRedU;
                            GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveDarkRedUR;
                            break;
                        case 1:
                            GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveGreyU;
                            GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveGreyUR;
                            break;
                        case 2:
                            GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveRedU;
                            GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveRedUR;
                            break;
                        case 3:
                            GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveYelowU;
                            GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveYelowUR;
                            break;
                        case 4:
                            GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iilivePurpleU;
                            GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iilivePurpleUR;
                            break;
                        case 5:
                            GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveOrangeU;
                            GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveOrangeUR;
                            break;
                        case 6:
                            GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveGreenU;
                            GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveGreenUR;
                            break;
                        case 7:
                            GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveBlueU;
                            GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveBlueUR;
                            break;
                        case 8:
                            GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iiliveLightBlueU;
                            GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iiliveLightBlueUR;
                            break;
                        case 9:
                            GameField.cell[GameField.numberOfCells - 1].iiliveU = GameField.iilivePinkU;
                            GameField.cell[GameField.numberOfCells - 1].iiliveUR = GameField.iilivePinkUR;
                            break;
                    }
                    if (GameField.cell[GameField.numberOfCells - 1].lookSide % 2 == 0) {
                        GameField.cell[GameField.numberOfCells - 1].picture = new RotatedIcon((Icon) GameField.cell[GameField.numberOfCells - 1].iiliveU, (double) ((GameField.cell[GameField.numberOfCells - 1].lookSide / 2) * 90));
                        return;
                    }
                    GameField.cell[GameField.numberOfCells - 1].picture = new RotatedIcon((Icon) GameField.cell[GameField.numberOfCells - 1].iiliveUR, (double) ((GameField.cell[GameField.numberOfCells - 1].lookSide / 2) * 90));
                    return;
                case 2:
                    GameField.cell[GameField.numberOfCells - 1].gen[mutationGen] = new Random().nextInt(200001) - 100000;
                    return;
                case 3:
                    GameField.cell[GameField.numberOfCells - 1].gen[mutationGen] = new Random().nextInt(3);
                    return;
                case 4:
                    GameField.cell[GameField.numberOfCells - 1].gen[mutationGen] = new Random().nextInt((GameField.maxEnergyForDivision - GameField.minEnergyForDivision) + 1) + GameField.minEnergyForDivision;
                    return;
                case 5:
                    GameField.cell[GameField.numberOfCells - 1].gen[mutationGen] = new Random().nextInt(100) + 1;
                    return;
                case 6:
                    GameField.cell[GameField.numberOfCells - 1].gen[mutationGen] = new Random().nextInt(this.maxAge) + 1;
                    GameField.cell[GameField.numberOfCells - 1].stepsForDeath = GameField.cell[GameField.numberOfCells - 1].gen[mutationGen];
                    return;
                default:
                    return;
            }
        }
    }

    public void look() {
        switch (this.lookSide) {
            case 0:
                this.front = GameField.map[this.coordY - 1][this.coordX];
                return;
            case 1:
                this.front = GameField.map[this.coordY - 1][this.coordX + 1];
                return;
            case 2:
                this.front = GameField.map[this.coordY][this.coordX + 1];
                return;
            case 3:
                this.front = GameField.map[this.coordY + 1][this.coordX + 1];
                return;
            case 4:
                this.front = GameField.map[this.coordY + 1][this.coordX];
                return;
            case 5:
                this.front = GameField.map[this.coordY + 1][this.coordX - 1];
                return;
            case 6:
                this.front = GameField.map[this.coordY][this.coordX - 1];
                return;
            case 7:
                this.front = GameField.map[this.coordY - 1][this.coordX - 1];
                return;
            default:
                return;
        }
    }

    public void painReaction() {
        for (int j = 0; j < 8; j++) {
            if (this.lookSide == j) {
                if (this.painSide >= this.lookSide) {
                    this.selfPainSide = this.painSide - this.lookSide;
                } else {
                    this.selfPainSide = (this.painSide - this.lookSide) + 8;
                }
            }
        }
        if (this.front == -4) {
            switch (this.gen[this.selfPainSide + 7] / 100000) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
                case 3:
                    move();
                    break;
            }
        }
        if (this.front >= 0 && GameField.cell[this.front].gen[1] != this.gen[1]) {
            switch ((this.gen[this.selfPainSide + 7] % 100000) / 10000) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
                case 3:
                    if (this.energy - GameField.cell[this.front].energy <= this.gen[2]) {
                        biteFail();
                        break;
                    } else {
                        bite();
                        break;
                    }
            }
        }
        if (this.front >= 0 && GameField.cell[this.front].gen[1] == this.gen[1]) {
            switch (((this.gen[this.selfPainSide + 7] % 100000) % 10000) / 1000) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
                case 3:
                    if (this.energy - GameField.cell[this.front].energy <= this.gen[2]) {
                        biteFail();
                        break;
                    } else {
                        bite();
                        break;
                    }
            }
        }
        if (this.front == -3) {
            switch ((((this.gen[this.selfPainSide + 7] % 100000) % 10000) % 1000) / 100) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
                case 3:
                    eat();
                    break;
            }
        }
        if (this.front == -2) {
            switch (((((this.gen[this.selfPainSide + 7] % 100000) % 10000) % 1000) % 100) / 10) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
                case 3:
                    eat();
                    break;
            }
        }
        if (this.front == -1) {
            switch (((((this.gen[this.selfPainSide + 7] % 100000) % 10000) % 1000) % 100) % 10) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
            }
        }
        this.painSide = -1;
    }

    public void noPainAction() {
        if (this.front == -4) {
            switch (this.gen[this.activeGen] / 100000) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
                case 3:
                    move();
                    break;
            }
        }
        if (this.front >= 0 && GameField.cell[this.front].gen[1] != this.gen[1]) {
            switch ((this.gen[this.activeGen] % 100000) / 10000) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
                case 3:
                    if (this.energy - GameField.cell[this.front].energy <= this.gen[2]) {
                        biteFail();
                        break;
                    } else {
                        bite();
                        break;
                    }
            }
        }
        if (this.front >= 0 && GameField.cell[this.front].gen[1] == this.gen[1]) {
            switch (((this.gen[this.activeGen] % 100000) % 10000) / 1000) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
                case 3:
                    if (this.energy - GameField.cell[this.front].energy <= this.gen[2]) {
                        biteFail();
                        break;
                    } else {
                        bite();
                        break;
                    }
            }
        }
        if (this.front == -3) {
            switch ((((this.gen[this.activeGen] % 100000) % 10000) % 1000) / 100) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
                case 3:
                    eat();
                    break;
            }
        }
        if (this.front == -2) {
            switch (((((this.gen[this.activeGen] % 100000) % 10000) % 1000) % 100) / 10) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
                case 3:
                    eat();
                    break;
            }
        }
        if (this.front == -1) {
            switch (((((this.gen[this.activeGen] % 100000) % 10000) % 1000) % 100) % 10) {
                case 1:
                    clockwiseRotation();
                    break;
                case 2:
                    counterClockwiseRotation();
                    break;
            }
        }
        this.activeGen++;
        if (this.activeGen == GameField.genLength) {
            this.activeGen = 15;
        }
    }

    public void move() {
        GameField.map[this.coordY][this.coordX] = -4;
        switch (this.lookSide) {
            case 0:
                this.coordY--;
                break;
            case 1:
                this.coordX++;
                this.coordY--;
                break;
            case 2:
                this.coordX++;
                break;
            case 3:
                this.coordX++;
                this.coordY++;
                break;
            case 4:
                this.coordY++;
                break;
            case 5:
                this.coordX--;
                this.coordY++;
                break;
            case 6:
                this.coordX--;
                break;
            case 7:
                this.coordX--;
                this.coordY--;
                break;
        }
        GameField.map[this.coordY][this.coordX] = this.gen[0];
        this.energy--;
    }

    public void clockwiseRotation() {
        if (this.lookSide == 7) {
            this.lookSide = 0;
        } else {
            this.lookSide++;
        }
        if (this.lookSide % 2 == 0) {
            this.picture = new RotatedIcon((Icon) this.iiliveU, (double) ((this.lookSide / 2) * 90));
        } else {
            this.picture = new RotatedIcon((Icon) this.iiliveUR, (double) ((this.lookSide / 2) * 90));
        }
        this.energy--;
    }

    public void counterClockwiseRotation() {
        if (this.lookSide == 0) {
            this.lookSide = 7;
        } else {
            this.lookSide--;
        }
        if (this.lookSide % 2 == 0) {
            this.picture = new RotatedIcon((Icon) this.iiliveU, (double) ((this.lookSide / 2) * 90));
        } else {
            this.picture = new RotatedIcon((Icon) this.iiliveUR, (double) ((this.lookSide / 2) * 90));
        }
        this.energy--;
    }

    public void bite() {
        switch (this.lookSide) {
            case 0:
                GameField.cell[GameField.map[this.coordY - 1][this.coordX]].energy -= new Random().nextInt(GameField.maxDamage);
                GameField.cell[GameField.map[this.coordY - 1][this.coordX]].painSide = 4;
                GameField.cell[GameField.map[this.coordY - 1][this.coordX]].painSideForTable = 4;
                if (GameField.cell[GameField.map[this.coordY - 1][this.coordX]].energy <= 0) {
                    GameField.cell[GameField.map[this.coordY - 1][this.coordX]].causeOfDeath = 3;
                    GameField.map[this.coordY - 1][this.coordX] = -3;
                    this.kills++;
                    GameField.liveNumber = (short) (GameField.liveNumber - 1);
                    break;
                }
                break;
            case 1:
                GameField.cell[GameField.map[this.coordY - 1][this.coordX + 1]].energy -= new Random().nextInt(GameField.maxDamage);
                GameField.cell[GameField.map[this.coordY - 1][this.coordX + 1]].painSide = 5;
                GameField.cell[GameField.map[this.coordY - 1][this.coordX + 1]].painSideForTable = 5;
                if (GameField.cell[GameField.map[this.coordY - 1][this.coordX + 1]].energy <= 0) {
                    GameField.cell[GameField.map[this.coordY - 1][this.coordX + 1]].causeOfDeath = 3;
                    GameField.map[this.coordY - 1][this.coordX + 1] = -3;
                    this.kills++;
                    GameField.liveNumber = (short) (GameField.liveNumber - 1);
                    break;
                }
                break;
            case 2:
                GameField.cell[GameField.map[this.coordY][this.coordX + 1]].energy -= new Random().nextInt(GameField.maxDamage);
                GameField.cell[GameField.map[this.coordY][this.coordX + 1]].painSide = 6;
                GameField.cell[GameField.map[this.coordY][this.coordX + 1]].painSideForTable = 6;
                if (GameField.cell[GameField.map[this.coordY][this.coordX + 1]].energy <= 0) {
                    GameField.cell[GameField.map[this.coordY][this.coordX + 1]].causeOfDeath = 3;
                    GameField.map[this.coordY][this.coordX + 1] = -3;
                    this.kills++;
                    GameField.liveNumber = (short) (GameField.liveNumber - 1);
                    break;
                }
                break;
            case 3:
                GameField.cell[GameField.map[this.coordY + 1][this.coordX + 1]].energy -= new Random().nextInt(GameField.maxDamage);
                GameField.cell[GameField.map[this.coordY + 1][this.coordX + 1]].painSide = 7;
                GameField.cell[GameField.map[this.coordY + 1][this.coordX + 1]].painSideForTable = 7;
                if (GameField.cell[GameField.map[this.coordY + 1][this.coordX + 1]].energy <= 0) {
                    GameField.cell[GameField.map[this.coordY + 1][this.coordX + 1]].causeOfDeath = 3;
                    GameField.map[this.coordY + 1][this.coordX + 1] = -3;
                    this.kills++;
                    GameField.liveNumber = (short) (GameField.liveNumber - 1);
                    break;
                }
                break;
            case 4:
                GameField.cell[GameField.map[this.coordY + 1][this.coordX]].energy -= new Random().nextInt(GameField.maxDamage);
                GameField.cell[GameField.map[this.coordY + 1][this.coordX]].painSide = 0;
                GameField.cell[GameField.map[this.coordY + 1][this.coordX]].painSideForTable = 0;
                if (GameField.cell[GameField.map[this.coordY + 1][this.coordX]].energy <= 0) {
                    GameField.cell[GameField.map[this.coordY + 1][this.coordX]].causeOfDeath = 3;
                    GameField.map[this.coordY + 1][this.coordX] = -3;
                    this.kills++;
                    GameField.liveNumber = (short) (GameField.liveNumber - 1);
                    break;
                }
                break;
            case 5:
                GameField.cell[GameField.map[this.coordY + 1][this.coordX - 1]].energy -= new Random().nextInt(GameField.maxDamage);
                GameField.cell[GameField.map[this.coordY + 1][this.coordX - 1]].painSide = 1;
                GameField.cell[GameField.map[this.coordY + 1][this.coordX - 1]].painSideForTable = 1;
                if (GameField.cell[GameField.map[this.coordY + 1][this.coordX - 1]].energy <= 0) {
                    GameField.cell[GameField.map[this.coordY + 1][this.coordX - 1]].causeOfDeath = 3;
                    GameField.map[this.coordY + 1][this.coordX - 1] = -3;
                    this.kills++;
                    GameField.liveNumber = (short) (GameField.liveNumber - 1);
                    break;
                }
                break;
            case 6:
                GameField.cell[GameField.map[this.coordY][this.coordX - 1]].energy -= new Random().nextInt(GameField.maxDamage);
                GameField.cell[GameField.map[this.coordY][this.coordX - 1]].painSide = 2;
                GameField.cell[GameField.map[this.coordY][this.coordX - 1]].painSideForTable = 2;
                if (GameField.cell[GameField.map[this.coordY][this.coordX - 1]].energy <= 0) {
                    GameField.cell[GameField.map[this.coordY][this.coordX - 1]].causeOfDeath = 3;
                    GameField.map[this.coordY][this.coordX - 1] = -3;
                    this.kills++;
                    GameField.liveNumber = (short) (GameField.liveNumber - 1);
                    break;
                }
                break;
            case 7:
                GameField.cell[GameField.map[this.coordY - 1][this.coordX - 1]].energy -= new Random().nextInt(GameField.maxDamage);
                GameField.cell[GameField.map[this.coordY - 1][this.coordX - 1]].painSide = 3;
                GameField.cell[GameField.map[this.coordY - 1][this.coordX - 1]].painSideForTable = 3;
                if (GameField.cell[GameField.map[this.coordY - 1][this.coordX - 1]].energy <= 0) {
                    GameField.cell[GameField.map[this.coordY - 1][this.coordX - 1]].causeOfDeath = 3;
                    GameField.map[this.coordY - 1][this.coordX - 1] = -3;
                    this.kills++;
                    GameField.liveNumber = (short) (GameField.liveNumber - 1);
                    break;
                }
                break;
        }
        this.energy--;
    }

    public void biteFail() {
        this.cantBite = true;
        switch (this.gen[3]) {
            case 1:
                clockwiseRotation();
                return;
            case 2:
                counterClockwiseRotation();
                return;
            default:
                return;
        }
    }

    public void eat() {
        switch (this.lookSide) {
            case 0:
                this.food = GameField.map[this.coordY - 1][this.coordX];
                GameField.map[this.coordY - 1][this.coordX] = -4;
                break;
            case 1:
                this.food = GameField.map[this.coordY - 1][this.coordX + 1];
                GameField.map[this.coordY - 1][this.coordX + 1] = -4;
                break;
            case 2:
                this.food = GameField.map[this.coordY][this.coordX + 1];
                GameField.map[this.coordY][this.coordX + 1] = -4;
                break;
            case 3:
                this.food = GameField.map[this.coordY + 1][this.coordX + 1];
                GameField.map[this.coordY + 1][this.coordX + 1] = -4;
                break;
            case 4:
                this.food = GameField.map[this.coordY + 1][this.coordX];
                GameField.map[this.coordY + 1][this.coordX] = -4;
                break;
            case 5:
                this.food = GameField.map[this.coordY + 1][this.coordX - 1];
                GameField.map[this.coordY + 1][this.coordX - 1] = -4;
                break;
            case 6:
                this.food = GameField.map[this.coordY][this.coordX - 1];
                GameField.map[this.coordY][this.coordX - 1] = -4;
                break;
            case 7:
                this.food = GameField.map[this.coordY - 1][this.coordX - 1];
                GameField.map[this.coordY - 1][this.coordX - 1] = -4;
                break;
        }
        if (this.food == -2) {
            this.energy += GameField.plantEnergy - 1;
            this.eatenPlants++;
        } else {
            this.energy += GameField.meatEnergy - 1;
            this.eatenMeat++;
        }
        this.stepsForDeath--;
    }
}

//========================================
//         Grid.java
//========================================

package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    protected void populate() {
        // 1. use makeCell to fill in cells
        // 2. use getNeighbors to set the neighbors field of each cell
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col] = this.makeCell(true);
            }
        }
        changed();
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].neighbors = getNeighbors(cells[row][col], 1);
            }
        }
    }

    // called when Populate and clear buttons are clicked
    public void repopulate(boolean randomly) {
        if (randomly) {
            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {
                    cells[row][col].reset(randomly);
                }
            }
        } else {
            // set the status of each cell to 0 (dead)
            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {
                    cells[row][col].reset(false);
                }
            }
        }
        // notify subscribers
        changed();
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */
        Set<Cell> neighbors = new HashSet<>();
        for (int row = Math.max(0, asker.row - radius); row <= Math.min(dim - 1, asker.row + radius); row++) {
            for (int col = Math.max(0, asker.col - radius); col <= Math.min(dim - 1, asker.col + radius); col++) {
                if (Math.abs(row - asker.row) + Math.abs(col - asker.col) <= radius) {
                    neighbors.add(cells[row][col]);
                }
            }
        }
        return neighbors;
    }


    // cell phases:

    public void observe() {
        // call each cell's observe method and notify subscribers
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].observe();
            }
        }
        changed();
    }

    public void interact() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].interact();
            }
        }
        changed();
    }

    public void update() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].interact();
            }
        }
        changed();
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}








/*
Some other files needed:

   GridFactory.java
   GridPanel.java
   ClearCommand.java
   RunCommand.java   // for Run1 and Run50 buttons
   PopulateCommand.java

*/
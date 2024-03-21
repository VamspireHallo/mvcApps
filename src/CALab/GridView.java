//========================================
//        ; GridView.java
//========================================

package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView  extends View {

    private CellView cellViews[][];

    public GridView(Model model) {
        super(model);

        Grid grid = (Grid) model;
        int size = grid.getDim();
        cellViews = new CellView[size][size];
        this.setLayout((new GridLayout(size, size)));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                /*
                Cell cell = new CellView(((Grid)model).getCell(row, col)
                cellViews[row][col] = cell
                set cell.row and cell.col here
                */
                Cell cell = grid.getCell(i, j);
                cellViews[i][j] = new CellView(cell);
                cell.row = i;
                cell.col = j;
                this.add(cellViews[i][j]);
            }
        }
    }

    public void update() {
        // call update method of each CellView
        Grid grid = (Grid) model;
        int size = grid.getDim();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                cellViews[row][col].update();
            }
        }
    }

}
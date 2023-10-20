package TP1;

import processing.core.PApplet;

import java.util.Random;

public abstract class AC {
    abstract int rules(int i, int j);
    boolean startGeneration = false;
    int ruleset;
    Cell[][] board;
    int columns, rows, cellDimension=10;
    public AC(PApplet p){
        rows = p.height/cellDimension;
        columns = p.width/cellDimension;
        board = new Cell[rows][columns];
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                board[i][j]= new Cell(i*cellDimension, j*cellDimension, 0, cellDimension);
            }
        }
    }
    public void computeNextGen(){
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                board[i][j].setState(rules(countNeighbours(i,j), board[i][j].getState()));
            }
        }
    }
    public void mouseClicked(int mouseX, int mouseY) {
        int i = mouseX / cellDimension;
        int j = mouseY / cellDimension;
        if (i >= 0 && i < rows && j >= 0 && j < columns) {
            board[i][j].setState(1 - board[i][j].getState());
        }
    }
    private int countNeighbours(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    int row = (x + i + rows) % rows;
                    int col = (y + j + columns) % columns;
                    count += board[row][col].getState();
                }
            }
        }
        return count;
    }

    public void display(PApplet p) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((board[i][j].getState() == 1))
                    p.fill(0);
                else
                    p.fill(255);
                p.stroke(0);
                p.rect(i * cellDimension, j * cellDimension, cellDimension, cellDimension);
            }
        }
    }
}

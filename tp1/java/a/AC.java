import processing.core.PApplet;

import java.util.Random;

public abstract class AC {
    abstract int rules(int i, int j);
    boolean startGeneration = false;
    Cell[][] board;
    int columns, rows, cellDimension=10;
    public AC(PApplet p){
        rows = p.height/cellDimension;
        columns = p.width/cellDimension;
        board = new Cell[columns][rows];
        for (int i=0; i<columns; i++){
            for (int j=0; j<rows; j++){
                board[i][j] = new Cell(i*cellDimension, j*cellDimension, 0, cellDimension);
            }
        }
    }
    public void randomizeBoard(){
        Random random = new Random();
        for (int i=0; i<columns; i++){
            for (int j=0; j<rows; j++){
                board[i][j] = new Cell(i*cellDimension, j*cellDimension, random.nextInt(2), cellDimension);
            }
        }
    }
    public void computeNextGen(){
        for (int i=0; i<columns; i++){
            for (int j=0; j<rows; j++){
                int neighbours = countNeighbours(i,j);
                int self = board[i][j].getState();
                int nextState = rules(neighbours, self);
                board[i][j].setNextState(nextState);
            }
        }
        for (int i=0; i<columns; i++){
            for (int j=0; j<rows; j++){
                board[i][j].setState();
            }
        }
    }
    public void mouseClicked(int mouseX, int mouseY) {
        int i = mouseX / cellDimension;
        int j = mouseY / cellDimension;
        if (i >= 0 && i < columns && j >= 0 && j < rows) {
            board[i][j].setNextState(1 - board[i][j].getState());
            board[i][j].setState();
        }
    }
    public int countNeighbours(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    int col = (x + i + columns) % columns;
                    int row = (y + j + rows) % rows;
                    count += board[col][row].getState();
                }
            }
        }
        return count;
    }

    public void display(PApplet p) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
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
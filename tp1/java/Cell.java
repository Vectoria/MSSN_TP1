package TP1;
public class Cell {
    private int state;
    private int dimension;
    private int x;
    private int y;
    public Cell(int x, int y, int state, int dimension){
        this.state = state;
        this.dimension = dimension;
        this.x = x;
        this.y = y;
    }
    public void setState(int state){
        this.state = state;
    }
    public int getState(){
        return this.state;
    }
}

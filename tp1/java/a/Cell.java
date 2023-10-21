public class Cell {
    private int state;
    private int nextState;
    private int dimension;
    private int x;
    private int y;
    public Cell(int x, int y, int state, int dimension){
        this.state = state;
        this.dimension = dimension;
        this.x = x;
        this.y = y;
        this.nextState = 0;
    }
    public void setState(){
        this.state = this.nextState;
    }
    public void setNextState(int state){
        this.nextState = state;
    }
    public int getState(){
        return this.state;
    }
}
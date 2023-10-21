import processing.core.PApplet;

public class GameOfLife extends AC{
    public GameOfLife(PApplet p) {
        super(p);
    }
    @Override
    int rules(int neighbours, int self) {
        if (neighbours < 2 && self == 1) {
            return 0; // Loneliness
        } else if (neighbours > 3 && self == 1) {
            return 0; // Overpopulation
        } else if (neighbours == 3 && self == 0) {
            return 1; // Reproduction
        } else {
            return self; // Stasis
        }

    }
}
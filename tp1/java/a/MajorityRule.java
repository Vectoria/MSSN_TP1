import processing.core.PApplet;
public class MajorityRule extends AC{
    public MajorityRule(PApplet p) {
        super(p);
    }
    @Override
    int rules(int neighbours, int self) {
        int total = neighbours+self;
        if (total<=4) return 0;
        else return 1;
    }
}
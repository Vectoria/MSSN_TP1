import processing.core.PApplet;

import java.util.Scanner;

import static com.sun.org.apache.xerces.internal.util.DOMUtil.getParent;

public class Sketch implements IProcessingApp {
    AC ac;
    @Override
    public void setup(PApplet parent) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose a ruleset. Type 0 for Game of life ruleset or 1 for Majority ruleset.");
        int chosenRuleset = keyboard.nextInt();
        while (chosenRuleset != 0 && chosenRuleset != 1) {
            System.out.println("Please, insert a valid ruleset (0 or 1):");
            chosenRuleset = keyboard.nextInt();
        }
        parent.frameRate(30);
        if (chosenRuleset == 0) {
            ac = new GameOfLife(parent);
        } else if (chosenRuleset == 1) {
            ac = new MajorityRule(parent);
        }
        System.out.println("Choose a starting board. Type 0 for custom board or 1 for random board.");
        int chosenBoardType = keyboard.nextInt();
        while (chosenBoardType != 0 && chosenBoardType != 1) {
            System.out.println("Please, insert a valid board type (0 or 1):");
            chosenBoardType = keyboard.nextInt();
        }
        if (chosenBoardType==1) ac.randomizeBoard();
        System.out.println("After you're finished with customizing your board, press ENTER to start the generation.");
        ac.display(parent);
    }
    @Override
    public void draw(PApplet parent, float dt) {
        if (ac.startGeneration) {
            ac.computeNextGen();

        }
        ac.display(parent);
    }
    @Override
    public void keyPressed(PApplet p) {
        if (p.keyCode == PApplet.ENTER) ac.startGeneration = true;
    }
    @Override
    public void mousePressed(PApplet p) {
        if (p.mouseButton == PApplet.LEFT) ac.mouseClicked(p.mouseX, p.mouseY);
    }
}
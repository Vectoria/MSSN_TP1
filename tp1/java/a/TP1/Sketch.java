package TP1;

import processing.core.PApplet;

import static com.sun.org.apache.xerces.internal.util.DOMUtil.getParent;

public class Sketch implements IProcessingApp {
    GameOfLife ac;
    @Override
    public void setup(PApplet parent) {
        parent.frameRate(10);
        ac = new GameOfLife(parent);
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
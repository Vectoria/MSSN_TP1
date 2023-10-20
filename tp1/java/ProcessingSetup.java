package TP1;

import processing.core.PApplet;

public class ProcessingSetup extends PApplet {
    public static IProcessingApp app;
    private int lastUpdate;
    @Override
    public void settings() {
        size(800, 800);
    }
    @Override
    public void setup() {
        app.setup(this);
        lastUpdate = millis();
    }
    @Override
    public void draw() {
        int now = millis();
        float dt = (now - lastUpdate) / 1000f;
        lastUpdate = now;
        app.draw(this, dt);
    }
    public static void main(String[] args) {
        app = new Sketch();
        PApplet.main(TP1.ProcessingSetup.class);
    }
    @Override
    public void mousePressed() {
        app.mousePressed(this);
    }
    @Override
    public void keyPressed() {
        app.keyPressed(this);
    }
}
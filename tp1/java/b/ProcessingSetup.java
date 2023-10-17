package tp1.java.b;

import processing.core.PApplet;

public class ProcessingSetup extends PApplet {
    public static IProcessingApp app;
    private int lastUpdate;
    @Override
    public void settings() {
        size(1024, 768);
    }
    @Override
    public void setup() {
        app.setup(this);
        lastUpdate = millis();
        noStroke();
        fill(0);
        background(255);
    }
    @Override
    public void draw() {
        background(255);
        int now = millis();
        float dt = (now - lastUpdate) / 1000f;
        lastUpdate = now;
        app.draw(this, dt);
    }
    public static void main(String[] args) {
        app = new DLA();
        PApplet.main(ProcessingSetup.class);
    }
}
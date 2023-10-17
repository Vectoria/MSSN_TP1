package tp1.java.b;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class DLA implements IProcessingApp {


    private static final int NUM_WALKERS = 100;
    private static final int NUM_STEPS_PER_FRAME = 90;
    private List<Walker> walkers;
    private int parar = 0;

    @Override
    public void setup(PApplet p) {
        walkers = new ArrayList<Walker>();
        Walker estacionario = new Walker(p.width / 2, p.height / 2);
        walkers.add(estacionario);

        for (int i = 0; i != NUM_WALKERS; ++i) {
            Walker w = new Walker(p);
            walkers.add(w);
        }
    }

    @Override
    public void draw(PApplet p, float dt) {
        p.background(255);

        for (int i = 0; i != NUM_STEPS_PER_FRAME; ++i) {
            for (Walker w : walkers) {
                w.wander(p);
                parar = w.getParar();
                w.updateState(walkers, p);


            }
        }
        for (int i = 0; i < parar; i++) {
            Walker a = new Walker(p);
            walkers.add(i, a);
        }


        for (Walker w : walkers) {
            //w.displayBolas(p);
            w.displayQuadrado(p);
            //w.displayTriangulo(p);

        }
    }
}

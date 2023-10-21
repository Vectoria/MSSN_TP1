package tp1.java.b;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class DLA implements IProcessingApp {


    private static final int NUM_WALKERS = 150;
    private static final int NUM_STEPS_PER_FRAME = 90;
    private List<Walker> walkers;

    @Override
    public void setup(PApplet p) {
        walkers = new ArrayList<Walker>();
        p.fill(231,20,105);
        Walker estacionario = new Walker(p.width / 2, p.height / 2,p);
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
               // parar = w.getParar();
                w.updateState(walkers, p);

            }
            if(Walker.num_wander<NUM_WALKERS){
                Walker.num_parados++;
                int novo=  NUM_WALKERS-Walker.num_wander;
                Walker w= new Walker( p.width/2,p.height/2,p);
                for(int idx=0; idx<novo; idx++){
                    w= new Walker(p);
                    walkers.add(w);
                }
            }
        }


        for (Walker w : walkers) {

           // w.displayBolas(p);
            w.displayQuadrado(p);
            //w.displayTriangulo(p);
            System.out.println("parados= "+ Walker.num_parados+ " Wander= " + Walker.num_wander);

        }
    }

}

package tp1.java.b;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.List;

public class Walker  {
    private PVector pos;
    private State state;
    private int radius = 5;
    private int colour;
    public static int num_wander=0;
    public static int num_parados=0;
    private static float r=231, g=20,b=105;
    public enum State{
        STOPPED,
        WANDER
    }

    public Walker(PApplet p) {
        //pos = new PVector(p.random(p.width), p.random(p.height));
        pos = new PVector(p.width/2, p.height/2);
        PVector step = PVector.random2D();
        step.mult(p.width/2);
        pos.add(step);
        //state = State.WANDER;
        setState(p,State.WANDER);
    }

    // Seed estacionÃ¡ria
    public Walker(int x, int y, PApplet p) {

        pos = new PVector(x, y);
        setState(p,State.STOPPED);
    }

    public State getState(){
        return state;
    }

    public void setState(PApplet p,State state) {
        this.state = state;
        if(state==State.STOPPED){
           //colour= p.color(231,20,105);
            colour= p.color(r,g,b);
            b-=0.06;
            g+=0.06;
            //colour= p.color(p.random(255),p.random(255),p.random(255));
           //num_parados++;
        }
        else{
            colour =p.color(0,0,240);
            num_wander++;
        }
    }
    // mostrar no relatorio sobre como ver os displays, e comentar os displays que n vou mostrar no DLA, AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

    public void displayBolas(PApplet p) {
        p.fill(colour);
        p.circle(pos.x, pos.y, 2 * radius);
    }

    public void displayQuadrado(PApplet p) {
        p.fill(colour);
        p.rect(pos.x, pos.y, 2 * radius, 2*radius);
    }

    public void displayTriangulo(PApplet p) {
        p.fill(colour);
        p.triangle(pos.x-radius*2,pos.y,pos.x,pos.y-2*radius,pos.x+2*radius,pos.y);
    }


    public void wander(PApplet p) {
        if(state == State.WANDER) {
            PVector step = PVector.random2D();
            pos.add(step);
            pos.lerp(new PVector(p.width / 2, p.height / 2), 0.0002f);
            pos.x = PApplet.constrain(pos.x, 0, p.width);
            pos.y = PApplet.constrain(pos.y, 0, p.height);
        }
    }




    public void updateState(List<Walker> walkers, PApplet p) {
        if(state == State.STOPPED) return;

        for(Walker w : walkers){
            if(w.state == State.STOPPED) {
                float dist = PVector.dist(pos, w.pos);

                if(dist < 2 * radius) {
                   // parar++;
                    setState(p, State.STOPPED);
                    num_wander--;
                    break;
                }
            }
        }
    }

}

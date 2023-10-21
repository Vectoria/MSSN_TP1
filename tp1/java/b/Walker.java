package tp1.java.b;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.List;

public class Walker  {
    private PVector pos;
    private State state;
    private int radius = 5;
    private int parar=0;

    public enum State{
        STOPPED,
        WANDER
    }

    public Walker(PApplet p) {
        pos = new PVector(p.random(p.width), p.random(p.height));
        state = State.WANDER;
    }

    // Seed estacionÃ¡ria
    public Walker(int x, int y) {
        pos = new PVector(x, y);
        state = State.STOPPED;
    }

    public State getState(){
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    // mostrar no relatorio sobre como ver os displays, e comentar os displays que n vou mostrar no DLA, AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

    public void displayBolas(PApplet p) {
        if(state==State.STOPPED){
            p.fill(231,20,105);
        }
        else{
            p.fill(0,0,240);
        }
        p.circle(pos.x, pos.y, 2 * radius);
    }

    public void displayQuadrado(PApplet p) {
        if(state==State.STOPPED){
            p.fill(231,20,105);
        }
        else{
            p.fill(0,0,240);
        }
        p.rect(pos.x, pos.y, 2 * radius, 2*radius);
    }

    public void displayTriangulo(PApplet p) {
        if(state==State.STOPPED){
            p.fill(231,20,105);
        }
        else{
            p.fill(0,0,240);
        }
        //bueda fixe
       // p.triangle(pos.x,pos.y,radius*2,radius*2,-radius*2,-radius*2);
        p.triangle(pos.x-radius*2,pos.y,pos.x,pos.y-2*radius,pos.x+2*radius,pos.y);
    }


    public void wander(PApplet p) {
        if(state == State.WANDER) {
            PVector step = PVector.random2D();
           // step.mult(p.width/2);
            pos.add(step);
            pos.lerp(new PVector(p.width / 2, p.height / 2), 0.0002f);
            pos.x = PApplet.constrain(pos.x, 0, p.width);
            pos.y = PApplet.constrain(pos.y, 0, p.height);
        }
    }

    public PVector getPos() {
        return pos;
    }
    public PVector getPos(Walker w) {
        return w.pos;
    }

    public int getRadius() {
        return radius;
    }

    public int getParar() {
        return parar;
    }

    public void updateState(List<Walker> walkers, PApplet p) {
        if(state == State.STOPPED) return;

        for(Walker w : walkers){
            if(w.state == State.STOPPED) {
                float dist = PVector.dist(pos, w.pos);

                if(dist < 2 * radius) {
                   // parar++;
                    setState(State.STOPPED);
                    break;
                }
            }
        }
    }

}

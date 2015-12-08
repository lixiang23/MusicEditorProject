package cs3500.music.controller;

/**
 * Created by nancyli on 11/20/15.
 */
public interface ControllerInterface {

    /**
     * sets up the mouse handlers
     */
    void mouseSetUp();


    /**
     * sets up key handlers
     */
    void keySetUp();

    /**
     * finds which beat the mouse location corresponds too
     * @param x represents the mouse x location
     * @return the beat at which the mouseX is located
     */

    Double getBeat(int x);

    /**
     * finds which pitch the mouse location corresponds too
     * @param y represents the mouse y location
     * @return the pitch at which the mouseY is located
     */
    Double getPitch(int y);

    /**
     * finds the highest pitch
     * @return midiIndex of the highest pitch
     */
    int highestPitch();
}

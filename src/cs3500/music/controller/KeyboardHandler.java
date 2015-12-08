package cs3500.music.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyboardHandler implements KeyListener {
    Map<Integer, Runnable> type;
    Map<Integer, Runnable> press;
    Map<Integer, Runnable> release;

    /**
     * constructs a KeyboardHandler
     */
    KeyboardHandler() {
        this.type = new HashMap<>();
        this.press = new HashMap<>();
        this.release = new HashMap<>();


    }

    /**
     * Getters for this class
     */
    public Map<Integer,Runnable> getType() {
        return this.type;
    }
    public Map<Integer, Runnable> getPress() {
        return this.press;
    }
    public Map<Integer, Runnable> getRelease() {
        return this.release;
    }


    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e is a keyevent
     */
    @Override
    //run keyevent that is in map
    public void keyTyped(KeyEvent e) {
        if (type.containsKey(e.getKeyCode())) {
            type.get(e.getKeyCode()).run();
        }
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e is a key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (press.containsKey(e.getKeyCode())) {
            press.get(e.getKeyCode()).run();
        }
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e is a keyevent
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (release.containsKey(e.getKeyCode())) {
            release.get(e.getKeyCode()).run();
        }

    }

    /**
     * adds to the type map if it is not already in the map
     * @param e is a keyevent
     * @param run a a runnable
     */
    public void addType(int e, Runnable run) {
        type.putIfAbsent(e, run);
    }

    /**
     * adds to the press map if it it not already in the map
     * @param e is a key event
     * @param run a runnable
     */
    public void addPress(int e, Runnable run) {
        System.out.println("does it map");
        this.press.putIfAbsent(e, run);

    }

    /**
     * adds to the release map if it is not already in the map
     * @param e is a key event
     * @param run a runnable
     */
    public void addRelease(int e, Runnable run) {
        release.putIfAbsent(e, run);
    }

}

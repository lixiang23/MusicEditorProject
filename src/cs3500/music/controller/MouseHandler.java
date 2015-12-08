package cs3500.music.controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    int X;
    int Y;

    /**
     * constructs a MouseHandler
     */
    MouseHandler() {
        this.X = 0;
        this.Y = 0;
    }
    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e is a MouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " +
            e.getY());
        this.X = e.getX();
        this.Y = e.getY();
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e is a MouseEvent
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e is a MouseEvent
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e is a MouseEvent
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     *  @param e is a MouseEvent
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}

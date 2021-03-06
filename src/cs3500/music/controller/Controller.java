package cs3500.music.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.sound.midi.InvalidMidiDataException;
import javax.swing.*;

import cs3500.music.model.*;
import cs3500.music.util.*;
import cs3500.music.view.*;

public class Controller implements ControllerInterface {
  private KeyboardHandler keyboardHandler;
  private MouseHandler mouseHandler;
  private Composition model;
  private ViewModel viewModel;
  private ViewInterface view;
  private Timer timer;


  /**
   * creates a Controller
   *
   * @param view  represents the view
   * @param model represents the model
   */
  public Controller(ViewInterface view, Composition model) {
    this.keyboardHandler = new KeyboardHandler();
    this.mouseHandler = new MouseHandler();
    this.view = view;
    this.model = model;
    this.keySetUp();
    this.mouseSetUp();
    this.timer = new Timer(model.getTempo() / 1250, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        view.updateTime();
      }
    });
    this.timer.stop();
    this.viewModel = ViewModel.fromComposition(model);

  }



//  @Override
//  public Double getBeat(int x) {
//    return null;
//  }
//
//  @Override
//  public Double getPitch(int y) {
//    return null;
//  }
//
//  @Override
//  public int highestPitch() {
//    return 0;
//  }





  /**
   * sets up mouse handler
   */
  public void mouseSetUp() {
    view.getGuiView().addMouseListener(this.mouseHandler);
  }


  /**
   * sets up key handler
   */
  public void keySetUp() {
    Note n = new Note(0, 0, 0, 0, 0);

    /**
     *pauses when space key is presssed
     */
    keyboardHandler.addPress(KeyEvent.VK_SPACE, () -> {
      timer.stop();
      view.pause();
    });

    /**
     starts when p key is pressed
     */
    keyboardHandler.addPress(KeyEvent.VK_P, () -> {
      timer.start();
      view.play();
    });

    /**
     * restarts the composition from the beginning when home key is pressed
     * for macs press fn + left keys
     */

    keyboardHandler.addPress(KeyEvent.VK_HOME, () -> {
      timer.restart();
      view.setCurrentTime(0);
      view.start();
    });

    /**
     * adds a note of the same instrument and volute when
     * a key is pressed
     * first click with mouse at desired location then press a
     */
    keyboardHandler.addPress(KeyEvent.VK_A, () -> {
//      model.addNote((getBeat(mouseHandler.X).intValue()), (getBeat(mouseHandler.X).intValue() + 1),
//              1, highestPitch() - getPitch(mouseHandler.Y).intValue(), 60);
      view.getGuiView().updateFrame(viewModel);

    });


    /**
     * removes the note at mouse location when r is pressed
     */
    keyboardHandler.addPress(KeyEvent.VK_R, () -> {
//      model.removeNote((getBeat(mouseHandler.X).intValue()),
//              model.getNoteOnBeat((getBeat(mouseHandler.X).intValue()),
//                      highestPitch() - getPitch(mouseHandler.Y).intValue()));
      view.getGuiView().updateFrame(viewModel);


    });

    // edits the note (removing the note and placing it at another beat)
    /**
     * edits the note when e is pressed
     * it removes the note and places it at another beat
     */
    keyboardHandler.addPress(KeyEvent.VK_E, () -> {
//      model.addNote((getBeat(mouseHandler.X).intValue()),
//              n.getDuration() + (getBeat(mouseHandler.X).intValue()),
//              n.getInstrument(),
//              highestPitch() - getPitch(mouseHandler.Y).intValue(), n.getVolume());
      view.getGuiView().updateFrame(viewModel);

    });
    view.getGuiView().addKeyListener(keyboardHandler);

  }

  @Override
  public Double getBeat(int x) {
    return null;
  }

  @Override
  public Double getPitch(int y) {
    return null;
  }

  @Override
  public int highestPitch() {
    return 0;
  }

//  /**
//   * finds which beat the mouse location corresponds too
//   *
//   * @param x represents the mouse x location
//   * @return the beat at which the mouseX is located
//   */
//
//  public Double getBeat(int x) {
//    return this.view.getGuiView().getGui().getDisplayPanel().getBeat(x);
//  }
//
//  /**
//   * finds which pitch the mouse location corresponds too
//   *
//   * @param y represents the mouse y location
//   * @return the pitch at which the mouseY is located
//   */
//  public Double getPitch(int y) {
//    return this.view.getGuiView().getGui().getDisplayPanel().getPitch(y);
//  }
//
//  /**
//   * finds the highest pitch
//   *
//   * @return midiIndex of the highest pitch
//   */
//  public int highestPitch() {
//    return this.view.getGuiView().getGui().getDisplayPanel().highestPitch();
//  }

}


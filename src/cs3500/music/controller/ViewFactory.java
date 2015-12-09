package cs3500.music.controller;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

import cs3500.music.model.*;
import cs3500.music.view.*;

/**
 * represents the view factory you can pick which one you want to make
 */
public class ViewFactory {
  public View view;
  private Composition model = new ModelImplToCompositionAdapter();

  /**
   * creates a view
   */
  public ViewFactory() {

  }

  /**
   * sets this model to the given model
   *
   * @param model represents the given model
   */
  public void setModel(ModelImplToCompositionAdapter model) {
    this.model = model;
  }

  /**
   * builder class for view allows you to pick which view you want to build
   *
   * @param viewName string name of view interface you want
   * @return a ViewInterface
   */
  public View build(String viewName) {
    if (viewName.equals("console")) {
      view = new ConsoleView();
    } else if (viewName.equals("visual")) {
      view = new GuiViewFrame();
    } else if (viewName.equals("midi")) {
      view = new MidiViewImpl();
    } else if (viewName.equals("composite")) {
      view = new CompositeView(new GuiViewFrame(), new MidiViewImpl());
    }
    return view;
  }

}

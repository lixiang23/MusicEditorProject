

package cs3500.music.view;

import cs3500.music.Controller.KeyboardHandler;

import java.awt.event.MouseAdapter;

/**
 * Created by sabrinakantor on 11/18/15.
 */


/**
 * Represents a composite view
 */
public class CompositeView implements View {
  GuiView guiView;
  View midiView;
  boolean isPlaying;

  /**
   * constructs a new composite view
   *
   * @param guiView  the gui of the view
   * @param midiView the midi of the view
   */
  public CompositeView(GuiView guiView, View midiView) {
    this.guiView = guiView;
    this.midiView = midiView;
    isPlaying = false;
  }

  public CompositeView(GuiView guiView, StringBuilder sb) {
    this.guiView = guiView;
    this.midiView = new MidiViewImpl(sb);
    isPlaying = false;
  }

  /**
   * adds the mouseAdapter to all panes
   *
   * @param ml the mouse adapter
   */
  public void mouseListener(MouseAdapter ml) {
    this.guiView.addMouseListener(ml);
    this.guiView.scrollPaneListener(ml);
  }

  /**
   * adds the keyListener to all panes
   *
   * @param kbh the key listener
   */
  public void keyListener(KeyboardHandler kbh) {
    this.guiView.addKeyListener(kbh);
  }

  /**
   * Renders the given viewModel
   *
   * @param viewModel the viewModel to render
   */
  public void render(ViewModel viewModel) {
    guiView.render(viewModel);
    this.renderMidi(viewModel);

  }

  /**
   * Renders the midi of the given ViewModel
   *
   * @param viewModel the composition to render with midi
   */
  public void renderMidi(ViewModel viewModel) {
    midiView.render(viewModel);
  }

  /**
   * updates the gui with the new given ViewModel
   *
   * @param viewModel the viewModel with which to update the gui
   */
  public void updateGui(ViewModel viewModel) {
    guiView.updateFrame(viewModel);

  }


  /**
   * updates the timer
   */
  public void updateTime() {
    guiView.updateTime();
    midiView.updateTime();

  }

  /**
   * restarts the timer
   */
  public void restartTime() {
    guiView.restartTime();
    midiView.restartTime();
  }

  /**
   * sets the time to the end
   */
  public void setTimeToEnd(int beat) {
    guiView.setTimeToEnd(beat);
    midiView.setTimeToEnd(beat);
  }

  /**
   * updates midi with the given ViewModel
   *
   * @param viewModel the viewModel with which to update midi
   */
  public void updateMidi(ViewModel viewModel) {
    midiView.render(viewModel);
  }


}

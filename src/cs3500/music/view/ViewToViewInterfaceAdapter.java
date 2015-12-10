package cs3500.music.view;

import java.util.Objects;

import javax.sound.midi.InvalidMidiDataException;

/**
 * Created by margmra on 12/8/2015.
 */
public class ViewToViewInterfaceAdapter implements ViewInterface {
  GuiView guiView;
  View midiView;
  ViewModel viewModel;

  public ViewToViewInterfaceAdapter(GuiView guiView, View midiView, ViewModel viewModel) {
    this.guiView = Objects.requireNonNull(guiView);
    this.midiView = Objects.requireNonNull(midiView);
    this.viewModel = Objects.requireNonNull(viewModel);
  }

  @Override
  public GuiView getGuiView() {
    guiView.render(viewModel);
    return guiView;
  }

  public View getMidiView() {
    try {
      midiView.renderMidi(viewModel);
    } catch (InvalidMidiDataException e) {
      e.printStackTrace();
    }
    return midiView;
  }

  /**
   * Pauses the composition at the certain beat
   */
  @Override
  public void pause() {
  }

  /**
   * Plays the composition
   */
  @Override
  public void play() {

  }

  /**
   * Plays the composition from the beginning
   */
  @Override
  public void start() {

  }

  /**
   * updates the current time
   */
  @Override
  public void updateTime() {
    guiView.updateTime();
    midiView.updateTime();
  }

  /**
   * sets the current time to an integer
   *
   * @param t represents the integer current time is set to
   */
  @Override
  public void setCurrentTime(int t) {
    guiView.restartTime();
    midiView.restartTime();
  }
}

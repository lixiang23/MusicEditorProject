package cs3500.music.view;

import cs3500.music.Controller.KeyboardHandler;

import javax.sound.midi.InvalidMidiDataException;
import java.awt.event.MouseAdapter;

/**
 * Created by sabrinakantor on 11/11/15.
 */
public interface View {

  /**
   * Renders the View
   */
  void render(ViewModel viewModel);

  /**
   * updates the timer
   */
  void updateTime();

  /**
   * restarts the timer
   */
  void restartTime();

  /**
   * sets the timer to the end of the piece
   */
  void setTimeToEnd(int lastBeat);


  /**
   * Updates the midiView with the given viewModel
   *
   * @param viewModel
   */
  void updateMidi(ViewModel viewModel);

  /**
   * Adds the given mouseAdapter
   *
   * @param mh the given mouseAdapter
   */
  void mouseListener(MouseAdapter mh);

  /**
   * Adds the given mouseAdapter
   *
   * @param kbh the given mouseAdapter
   */
  void keyListener(KeyboardHandler kbh);

  /**
   * Renders midi based on the given ViewModel
   *
   * @param viewModel
   * @throws InvalidMidiDataException
   */
  void renderMidi(ViewModel viewModel) throws InvalidMidiDataException;

  /**
   * Updates the guiView with the given ViewModel
   *
   * @param viewModel
   */
  void updateGui(ViewModel viewModel);
}

package cs3500.music.view;

import cs3500.music.Controller.KeyboardHandler;
import cs3500.music.model.Composition;
import cs3500.music.model.CompositionImpl;
import cs3500.music.model.Playable;

import java.awt.event.MouseAdapter;
import java.util.List;

/**
 * Created by sabrinakantor on 11/11/15.
 */

/**
 * Represents the console view of the music editor
 */
public class ConsoleView implements View {
  public ConsoleView() {
  }

  /**
   * Renders the notes and their durations in the console
   */
  public void render(ViewModel viewModel) {
    System.out.println(notesOnTop(viewModel));
    for (int beat = 0; beat < viewModel.lastNote() + 1; beat++) {
      String beatString = "";
      String beatTemplate = "%2d";

      beatString += String.format(beatTemplate, beat);

      List<Playable> notesAtLine = viewModel.whatIsPlayingAt(beat);

      char[] charArray = new char[(viewModel.highestPitch() - viewModel.lowestPitch() + 1) * 4];
      for (int x = 0; x < (viewModel.highestPitch() - viewModel.lowestPitch()) * 4 + 2; x++) {
        charArray[x] = '-';
      }

      for (int i = 0; i < notesAtLine.size(); i++) {
        Playable aNotesAtLine = notesAtLine.get(i);
        if (aNotesAtLine.getStart() == beat) {
          int index =
                  CompositionImpl.getNumPitch(aNotesAtLine.getPitch(), aNotesAtLine.getOctave())
                          - viewModel.lowestPitch();
          charArray[index * 4] = 'X';

        } else {
          int index =
                  CompositionImpl.getNumPitch(aNotesAtLine.getPitch(), aNotesAtLine.getOctave())
                          - viewModel.lowestPitch();
          charArray[index * 4] = '|';

        }
      }
      System.out.println(beatString + " " + new String(charArray));
    }
  }

  @Override
  public void updateTime() {

  }

  @Override
  public void restartTime() {

  }

  @Override
  public void setTimeToEnd(int beat){

  }

  @Override
  public void updateMidi(ViewModel viewModel) {

  }

  @Override
  public void mouseListener(MouseAdapter mh) {

  }

  @Override
  public void keyListener(KeyboardHandler kbh) {

  }

  @Override
  public void renderMidi(ViewModel viewModel) {

  }

  @Override
  public void updateGui(ViewModel viewModel) {

  }

  /**
   * Creates the notes on top in the console view
   *
   * @return an array of characters representing the notes on top
   */
  char[] notesOnTop(ViewModel viewModel) {
    int range = 4 * (viewModel.highestPitch() - viewModel.lowestPitch());
    char[] result = new char[range];
    String resultString = "  ";
    String pitchTemplate = "%4s";
    for (int i = viewModel.lowestPitch(); i < viewModel.highestPitch() + 1; i++) {
      int pitch = i % 12;
      int octave = (i - pitch) / 12;
      String pitchOctave =
              String.format(pitchTemplate, CompositionImpl.noteNames(pitch) +
                      Integer.toString(octave) + " ");

      resultString += pitchOctave;


    }
    result = resultString.toCharArray();
    return result;
  }

}

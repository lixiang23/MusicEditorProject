package cs3500.music.model;

/**
 * Created by nancyli on 12/2/15.
 */
public interface NoteInterface {

  /**
   * Getter methods
   */
  int getPitchNum();
  int getDuration();
  int getIndex();
  int getVolume();
  int getOctave();
  int getInstrument();

//  /**
//   * sets the note to the given note
//   *
//   * @return new note, setted to the given note
//   */
//  void setNote(Note n);

  /**
   * Converts the pitch to a String Note
   *
   * @return the String version of the pitch
   */
  String pitchToString();
}

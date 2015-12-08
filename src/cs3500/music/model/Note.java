package cs3500.music.model;

/**
 * Created by margmra on 11/11/2015.
 */
public class Note implements NoteInterface{

  private int midiIndex;
  private int duration;
  private int instrument;
  private int volume;

  /**
   * creates a Note
   *
   * @param midiIndex  represents midiIndex of a note
   * @param duration   represents duration of a note
   * @param instrument represents the instrument of the note
   * @param volume     represents the volume of a note
   */
  public Note(int midiIndex, int duration, int instrument, int volume) {
    this.duration = duration;
    this.instrument = instrument;
    this.volume = volume;
    this.midiIndex = midiIndex;
  }

  Note(int duration) {
    duration = 1;
  }

  /**
   * finds the pitch of the note 0 - C 1 - C# 2 - D 3 - D# 4 - E 5 - F 6 - F# 7 - G 8 - G# 9 - A 10
   * - A# 11 - B
   *
   * @return the pitch of the note
   */
  public int getPitch() {
    return midiIndex % 12;
  }

  /**
   * gets the duration of the note
   *
   * @return duration of note
   */
  public int getDuration() {
    return this.duration;
  }

  /**
   * finds the octave of the note
   *
   * @return the octave of the note
   *
   * ex: note of midiIndex: 65 65/12 = 5 note is in the fifth octave
   */
  public int getOctave() {
    return midiIndex / 12;
  }

  /**
   * gets the midiIndex of the note
   *
   * @return midiIndexx
   */
  public int getIndex() {
    return this.midiIndex;
  }

  /**
   * gets the volume of the the note
   *
   * @return volume
   */
  public int getVolume() {
    return this.volume;
  }

  /**
   * gets the instrument of the note
   *
   * @return the instrument
   */
  public int getInstrument() {
    return this.instrument;
  }

  @Override
  public void setNote(Note n) {
    this.midiIndex = n.midiIndex;
    this.duration = n.duration;
    this.instrument = n.instrument;
    this.volume = n.volume;
  }

  @Override
  public String pitchToString() {
    int pitch = this.getPitch();
    String pitchString;
    switch (pitch) {
      case 0:
        pitchString = "C";
        break;
      case 1:
        pitchString = "C#";
        break;
      case 2:
        pitchString = "D";
        break;
      case 3:
        pitchString = "D#";
        break;
      case 4:
        pitchString = "E";
        break;
      case 5:
        pitchString = "F";
        break;
      case 6:
        pitchString = "F#";
        break;
      case 7:
        pitchString = "G";
        break;
      case 8:
        pitchString = "G#";
        break;
      case 9:
        pitchString = "A";
        break;
      case 10:
        pitchString = "A#";
        break;
      case 11:
        pitchString = "B";
        break;
      default:
        pitchString = "Invalid note";
        break;
    }
    return pitchString;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Note)) {
      return false;
    }
    Note note = (Note) o;

    return (this.midiIndex == note.midiIndex) &&
            (this.duration == note.duration) &&
            (this.instrument == note.instrument) &&
            (this.volume == note.volume);
  }
}

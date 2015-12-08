package cs3500.music.model;

/**
 * Created by nancyli on 12/7/15.
 */
public class NoteToPlayableAdapter extends Playable implements NoteInterface{

  public NoteToPlayableAdapter(Pitch pitch, int octave, int start, int duration) {
    super(pitch, octave, start, duration);
  }

  //FIX THIS!!!
  public int getPitch() {
    return null;
  }

  public int getDuration() {
    return duration;
  }

  public int getVolume() {
    return volume;
  }

  public int getOctave() {
    return octave;
  }
  public int getInstrument() {
    return instrument;
  }

  @Override
  public int getIndex() {
    return octave * 12;
  }

  @Override
  public void setNote(Note n) {
    this.pitch = null;
    this.octave = n.getOctave();
    this.start = n.getStartBeat();
    this.duration = n.getDuration();

  }

  @Override
  public String pitchToString() {
    return null;
  }
}

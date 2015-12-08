package cs3500.music.model;

/**
 * Created by nancyli on 12/7/15.
 */
public class NoteToPlayableAdapter extends Playable implements NoteInterface{
  public NoteToPlayableAdapter(Pitch pitch, int octave, int start, int duration) {
    super(pitch, octave, start, duration);
  }

  @Override
  public int getIndex() {
    return 0;
  }

  @Override
  public void setNote(Note n) {

  }

  @Override
  public String pitchToString() {
    return null;
  }
}

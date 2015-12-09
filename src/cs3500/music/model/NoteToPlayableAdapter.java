package cs3500.music.model;

/**
 * Created by nancyli on 12/7/15.
 */
public class NoteToPlayableAdapter extends Playable implements NoteInterface{

  public NoteToPlayableAdapter(Pitch pitch, int octave, int start, int duration) {
    super(pitch, octave, start, duration);
  }

  //FIX THIS!!!
  @Override
  public int getPitchNum() {
    return CompositionImpl.getNumPitch(pitch,octave) % 12;
  }

  public Pitch getPitch() {
    return pitch;
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

//  @Override
//  public void setNote(Note n) {
//    //FIX PITCH!!!!!!!!!!!!
//    this.pitch = n.
//    this.octave = n.getOctave();
//    this.start = n.getStartBeat();
//    this.duration = n.getDuration();
//  }

  @Override
  public String pitchToString() {
    return null;
  }
}

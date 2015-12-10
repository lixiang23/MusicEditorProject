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


  public static Pitch midiIndexToPitch(int midiIndex) {
    int pitchNum = midiIndex % 12;
    Pitch pitch;
    switch (pitchNum) {
      case 0:
        pitch = Pitch.C;
        break;
      case 1:
        pitch = Pitch.CSHARP;
        break;
      case 2:
        pitch = Pitch.D;
        break;
      case 3:
        pitch = Pitch.DSHARP;
        break;
      case 4:
        pitch = Pitch.E;
        break;
      case 5:
        pitch = Pitch.F;
        break;
      case 6:
        pitch = Pitch.FSHARP;
        break;
      case 7:
        pitch = Pitch.G;
        break;
      case 8:
        pitch = Pitch.GSHARP;
        break;
      case 9:
        pitch = Pitch.A;
        break;
      case 10:
        pitch = Pitch.ASHARP;
        break;
      case 11:
        pitch = Pitch.B;
        break;
      default:
        pitch = null;
        break;
    }
    return pitch;
  }

}

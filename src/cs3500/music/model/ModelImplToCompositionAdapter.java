package cs3500.music.model;

import com.sun.tools.internal.ws.processor.model.Model;

import java.util.ArrayList;
import java.util.List;
import cs3500.music.model.Playable.Pitch;
import cs3500.music.util.CompositionBuilder;

/**
 * Created by margmra on 12/6/2015.
 */
public class ModelImplToCompositionAdapter implements Composition {
  CompositionImpl model;

  public ModelImplToCompositionAdapter() {

  }
  /**
   * Adds the given playable to the score
   *
   * @param playable the playable to add
   */
  @Override
  public void addNote(Playable playable) {
    model.addNote(playable.getStart(), playable.getStart() + playable.getDuration(),
            playable.getInstrument(), CompositionImpl.getNumPitch(playable.getPitch()
                    , playable.getOctave()) % 12, playable.getVolume());

  }

  /**
   * removes the given playable
   *
   * @param playable the playable to remove
   */
  @Override
  public void removeNote(Playable playable) {
    model.removeNote(playable.getStart(), new NoteToPlayableAdapter(playable.getPitch(),
            playable.getOctave(), playable.getStart(), playable.getDuration()));

  }



  /**
   * Modifies the duration of the first occurrence of the given playable to be newDuration
   *
   * @param playable    the playable to edit
   * @param newDuration the new duration to assign the given playable
   */
  @Override
  public void editDuration(Playable playable, int newDuration) {
    playable.duration = newDuration;

  }

  /**
   * Modifies the Start of the first occurrence of the given playable to be newStart
   *
   * @param playable the playable to edit
   * @param newStart the new start to assign the given playable
   */
  @Override
  public void editStart(Playable playable, int newStart) {
    playable.start = newStart;

  }

  /**
   * Modifies the Pitch of the first occurrence of the given playable to be newOctave
   *
   * @param playable  the playable to edit
   * @param newPitch  the new pitch to assign the given playable
   * @param newOctave the new octave to assign the given playable
   */
  // TODO
  @Override
  public void editPitch(Playable playable, Pitch newPitch, int newOctave) {
    playable.pitch = newPitch;
    playable.octave = newOctave;

  }

  /**
   * Modifies the instrument of the first occurrence of the given playable to be newInstrument
   *
   * @param playable      the playable to edit
   * @param newInstrument the new instrument
   */
  @Override
  public void editInstrument(Playable playable, int newInstrument) {
    playable.instrument = newInstrument;

  }


  /**
   * Returns a list of all playables playing at the given beat
   *
   * @param beat the desired beat at which to get all playables
   * @return the list of all playables at the given beat
   */
  // TODO
  @Override
  public List<Playable> whatIsPlaying(int beat) {
    return null;
  }

  /**
   * Finds the lowest Pitch of all the playables
   *
   * @return the lowest Pitch of all the playables
   */
  //TODO
  @Override
  public int lowestPitch() {
    return 0;
  }

  /**
   * Finds the highest Pitch of all the playables
   *
   * @return the highest Pitch of all the playables
   */
  // TODO
  @Override
  public int highestPitch() {
    return 0;
  }

  /**
   * Returns the last beat of the last playable's last duration
   *
   * @return the beat of the last playable's last duration
   */
  // TODO
  @Override
  public int lastNote() {
    return 0;
  }

  /**
   * Returns a list of what playables start at a given beat
   *
   * @param beat the desire beat
   * @return list of what playables start at a given beat
   */
  // TODO
  @Override
  public List<Playable> whatStartsAt(int beat) {
    return null;
  }

  /**
   * Get the tempo of the composition
   *
   * @return the tempo
   */

  @Override
  public int getTempo() {
    return model.getTempo();
  }


  /**
   * Configures and builds a {@link Composition} in builder-pattern style.
   */
  public static final class Builder implements CompositionBuilder<Composition> {

    ModelImplToCompositionAdapter musicEditor = new ModelImplToCompositionAdapter();

    /**
     * Invariants are the same as for CompositionImpl:
     *
     * length > 0 height > 0 and height < 128
     */

    public Builder notes(ArrayList<ArrayList<Note>> notes) {
      for (int i = 0; i < notes.size(); i++) {
        musicEditor.model.getNotes().add(notes.get(i));
      }
      return this;
    }

//    public Builder tempo(int tempo) {
//      this.model.tempo = tempo;
//      return this;
//    }

    @Override
    public ModelImplToCompositionAdapter build() {

      return musicEditor;
    }

    @Override
    public CompositionBuilder<Composition> setTempo(int tempo) {
      return null;
    }

    @Override
    public CompositionBuilder<Composition>
    addNote(int start, int end, int instrument, int pitch, int volume) {
      musicEditor.addNote(new NoteToPlayableAdapter())
      musicEditor.model.addNote(start, end, instrument, pitch, volume);
      return this;
    }

//    @Override
//    public CompositionBuilder<Composition> setTempo(int tempo) {
//      musicEditor.getTempo() = tempo;
//      return this;
//    }
  }
}

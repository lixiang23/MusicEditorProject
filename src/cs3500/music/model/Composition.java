package cs3500.music.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabrinakantor on 11/1/15.
 */
public interface Composition {

  /**
   * Adds the given playable to the score
   *
   * @param playable the playable to add
   */
  void addNote(Playable playable);

  /**
   * removes the given playable
   *
   * @param playable the playable to remove
   */
  void removeNote(Playable playable);

  /**
   * Modifies the duration of the first occurrence of the given playable to be newDuration
   *
   * @param playable    the playable to edit
   * @param newDuration the new duration to assign the given playable
   */
  void editDuration(Playable playable, int newDuration);

  /**
   * Modifies the Start of the first occurrence of the given playable to be newStart
   *
   * @param playable the playable to edit
   * @param newStart the new start to assign the given playable
   */
  void editStart(Playable playable, int newStart);

  /**
   * Modifies the Pitch of the first occurrence of the given playable to be newOctave
   *
   * @param playable  the playable to edit
   * @param newPitch  the new pitch to assign the given playable
   * @param newOctave the new octave to assign the given playable
   */
  void editPitch(Playable playable, Pitch newPitch, int newOctave);

  /**
   * Modifies the instrument of the first occurrence of the given playable to be newInstrument
   *
   * @param playable  the playable to edit
   * @param newInstrument the new instrument
   */
  void editInstrument(Playable playable,int newInstrument);


  /**
   * Returns a list of all playables playing at the given beat
   *
   * @param beat the desired beat at which to get all playables
   * @return the list of all playables at the given beat
   */
  List<Playable> whatIsPlaying(int beat);

  /**
   * Finds the lowest Pitch of all the playables
   *
   * @return the lowest Pitch of all the playables
   */
  int lowestPitch();

  /**
   * Finds the highest Pitch of all the playables
   *
   * @return the highest Pitch of all the playables
   */
  int highestPitch();

  /**
   * Returns the last beat of the last playable's last duration
   *
   * @return the beat of the last playable's last duration
   */
  int lastNote();


  /**
   * Returns a list of what playables start at a given beat
   *
   * @param beat the desire beat
   * @return list of what playables start at a given beat
   */
  List<Playable> whatStartsAt(int beat);

  /**
   * Get the tempo of the composition
   *
   * @return the tempo
   */
  int getTempo();
}

package cs3500.music.view;

import cs3500.music.model.Composition;
import cs3500.music.model.Playable;

import java.util.List;

/**
 * Created by sabrinakantor on 11/16/15.
 */
public abstract class ViewModel {
  private final int highestPitch;
  private final int lowestPitch;
  private final int lastNote;
  private final int tempo;

  public ViewModel(int highestPitch, int lowestPitch, int lastNote, int tempo) {
    this.highestPitch = highestPitch;
    this.lowestPitch = lowestPitch;
    this.lastNote = lastNote;
    this.tempo = tempo;

  }

  /**
   * the highest pitch
   *
   * @return the highest pitch
   */
  public int highestPitch() {
    return this.highestPitch;
  }

  /**
   * the lowest pitch
   *
   * @return the lowest pitch
   */

  public int lowestPitch() {
    return this.lowestPitch;
  }

  /**
   * the last note
   *
   * @return the last note
   */
  public int lastNote() {
    return this.lastNote;
  }

  /**
   * the tempo
   *
   * @return the tempo
   */
  public int getTempo() {
    return this.tempo;
  }

  /**
   * all the notes played at the given beat
   *
   * @param beat
   * @return List of playable at the give beat
   */
  public abstract List<Playable> whatIsPlayingAt(int beat);

  /**
   * all the notes starting at the given beat
   *
   * @param beat
   * @return List of playable starting the give beat
   */
  public abstract List<Playable> whatStartsAt(int beat);


  /**
   * Adapts the given composition to a viewModel
   *
   * @param adaptee the composition
   * @return
   */

  private static ViewModel fromComposition(Composition adaptee) {
    return new ViewModel(adaptee.highestPitch(), adaptee.lowestPitch(), adaptee.lastNote(),
            adaptee.getTempo()) {
      @Override public List<Playable> whatIsPlayingAt(int beat) {
        return adaptee.whatIsPlaying(beat);
      }

      @Override public List<Playable> whatStartsAt(int beat) {
        return adaptee.whatStartsAt(beat);
      }
    };
  }



}




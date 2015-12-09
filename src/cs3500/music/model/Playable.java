package cs3500.music.model;


/**
 * Represents a playable
 */
public abstract class Playable {
  protected Pitch pitch; //represents the pitch
  protected int octave; //represents the octave
  protected int start; //represents the starting beat
  protected int duration; //represents the duration
  protected int instrument; //represents the instrument
  protected int volume; //represents the volume

  /**
   * Constructs a Playable
   *
   * @param pitch    the desired pitch
   * @param octave   the desired octave
   * @param start    the desired start
   * @param duration the desired duration
   */
  public Playable(Pitch pitch, int octave, int start, int duration) {

    this.pitch = pitch;
    this.instrument = 1;
    this.volume = 1;

    if (octave < 0) {
      throw new IllegalArgumentException("Can't have a negative octave");
    }
    this.octave = octave;
    if (start < 0) {
      throw new IllegalArgumentException("Can't have a negative start");
    }
    this.start = start;

    if (duration < 0) {
      throw new IllegalArgumentException("Can't have negative duration");
    }
    this.duration = duration;
  }

  /**
   * Constructs a playable
   *
   * @param pitch      the desired pitch
   * @param octave     the desired octave
   * @param start      the desired start
   * @param duration   the desired duration
   * @param instrument the desired instrument
   * @param volume     the desired volume
   */
  public Playable(Pitch pitch, int octave, int start, int duration, int instrument, int volume) {
    this.pitch = pitch;
    this.instrument = instrument;
    this.volume = volume;

    if (octave < 0) {
      throw new IllegalArgumentException("Can't have a negative octave");
    }
    this.octave = octave;
    if (start < 0) {
      throw new IllegalArgumentException("Can't have a negative start");
    }
    this.start = start;

    if (duration < 0) {
      throw new IllegalArgumentException("Can't have negative duration");
    }
    this.duration = duration;
  }


  /**
   * Determines if this note is equal to the note with the given numPitch, start and duration
   *
   * @param p        pith of the note to compare
   * @param start    of the note to compare
   * @param duration of the note to compare
   * @return a boolean determining if the notes are equal
   */
  public boolean noteEqual(Pitch p, int octave, int start, int duration) {
    return this.pitch == p && this.start == start && this.octave == octave &&
            this.duration == duration;
  }


  /**
   * gets this Playable's duration
   *
   * @return this Playable's duration
   */
  public int getDuration() {
    return this.duration;
  }

  /**
   * gets this Playable's start
   *
   * @return this Playables start
   */
  public int getStart() {
    return this.start;
  }

  /**
   * gets this Playable's Pitch
   *
   * @return this Playable's pitch
   */
  public Pitch getPitch() {
    return this.pitch;
  }

  /**
   * gets this Playable's Octave
   *
   * @return this Playable's octave
   */
  public int getOctave() {
    return this.octave;
  }

  /**
   * get this Playable's Instrument
   *
   * @return this Playable's Instrument
   */
  public int getInstrument() {
    return this.instrument;
  }

  /**
   * get this Playable's Volume
   *
   * @return this Playable's Volume
   */
  public int getVolume() {
    return this.volume;
  }


  /**
   * returns the beat where this Playable ends
   *
   * @return the integer of the last beat
   */

  public int ends() {
    return this.start + this.duration;
  }


  /**
   * Returns true if this playable either starts at the given beat or has a duration over the given
   * beat
   *
   * @param beat the beat that will be checked
   * @return true if this playable is being played and false if it is not
   */

  public boolean isStillPlaying(int beat) {
    return beat >= this.start && beat <= this.ends();

  }

  /**
   * is a pitch
   */

  public enum Pitch {
    C, CSHARP, D, DSHARP, E, F, FSHARP, G, GSHARP, A, ASHARP, B
  }


}

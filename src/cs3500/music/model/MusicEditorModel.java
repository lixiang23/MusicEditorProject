package cs3500.music.model;

import java.util.*;

/**
 * Model for a music editor. This music editor must keep track of the given notes, which is a
 * "pitch", the duration of each note, measured by beats(for now, the model will only represent
 * notes that are an integral number of beats long.
 *
 * This interface also includes static factory methods for creating {@code MusicEditor} and {@link
 * MusicEditorModel.Builder}s.
 **/

public interface MusicEditorModel {

  /**
   * The default tempo of this composition
   */
  int DEFAULT_TEMPO = 200000; // in milliseconds per beat


  /**
   * Gets the piece on this editor, which is the combination of notes
   *
   * @return the notes
   */
  ArrayList<ArrayList<Note>> getNotes();

  /**
   * Gets the tempo of this composition
   *
   * @return tempo
   */
  int getTempo();

  /**
   * Gets the notes on the current beat
   *
   * @param b the beat given
   * @return the note/s that are on the given beat
   */
  ArrayList<Note> getNotesOnBeat(int b);

  /**
   * Gets a certain note on the current beat
   *
   * @param b         the beat given
   * @param midiIndex the midiIndex of the note
   * @return the note that is on the given beat, if the note is there
   */
  Note getNoteOnBeat(int b, int midiIndex);

  /**
   * Gets the number of beats in this editor
   *
   * @return the number of beats
   */
  int getBeats();

  /**
   * Determines if this composition contains the note given on the beat given
   * @param b the beat where the note should be
   * @param n the note that is checked
   * @returns true if the composition contains the note and false if the composition does not
   */
  boolean containsNote(int b, Note n);

  /**
   * Adds a note to the given list of notes (which is a piece) Edited to be compatible with MIDI
   *
   * @param start      the beat the note is inserted at
   * @param end        the best the note ends at
   * @param instrument the instrument it plays
   * @param pitch      the pitch of the note that is inserted
   * @param volume     the volume of the note
   */
  void addNote(int start, int end, int instrument, int pitch, int volume);

  /**
   * Removes a note from the given list of notes (which is a piece)
   *
   * @param n the note removed
   * @param b the beat that contains the removed note
   * @return the composite with the note removed
   */
  void removeNote(int b, NoteInterface n);


  /**
   * Produces the total duration of this piece
   */
  int totalDuration();

  /**
   * Builds a {@link MusicEditorModel}, allowing the client to configure several parameters. This is
   * a builder pattern.
   */
  interface Builder {
    /**
     * Builds and returns the specified {@link MusicEditorModel}.
     *
     * @return a new {@code MusicEditorImpl}
     */
    MusicEditorModel build();

    /**
     * Sets the length, the number of beats, of this music editor grid.
     *
     * @param length the length (positive)
     * @return {@code this}
     */
    Builder length(int length);

    /**
     * Sets the length, the number of octaves and their corresponding notes, of this music editor
     * grid
     */
    Builder height(int height);

  }


}
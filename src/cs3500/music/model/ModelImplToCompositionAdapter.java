package cs3500.music.model;

import java.util.List;

/**
 * Created by margmra on 12/6/2015.
 */
public class ModelImplToCompositionAdapter implements Composition {
    MusicEditorImpl model;

    /**
     * Adds the given playable to the score
     *
     * @param playable the playable to add
     */
    @Override
    public void addNote(Playable playable) {

    }

    /**
     * removes the given playable
     *
     * @param playable the playable to remove
     */
    @Override
    public void removeNote(Playable playable) {

    }

    /**
     * Modifies the duration of the first occurrence of the given playable to be newDuration
     *
     * @param playable    the playable to edit
     * @param newDuration the new duration to assign the given playable
     */
    @Override
    public void editDuration(Playable playable, int newDuration) {

    }

    /**
     * Modifies the Start of the first occurrence of the given playable to be newStart
     *
     * @param playable the playable to edit
     * @param newStart the new start to assign the given playable
     */
    @Override
    public void editStart(Playable playable, int newStart) {

    }

    /**
     * Modifies the Pitch of the first occurrence of the given playable to be newOctave
     *
     * @param playable  the playable to edit
     * @param newPitch  the new pitch to assign the given playable
     * @param newOctave the new octave to assign the given playable
     */
    @Override
    public void editPitch(Playable playable, Pitch newPitch, int newOctave) {

    }

    /**
     * Modifies the instrument of the first occurrence of the given playable to be newInstrument
     *
     * @param playable      the playable to edit
     * @param newInstrument the new instrument
     */
    @Override
    public void editInstrument(Playable playable, int newInstrument) {

    }

    /**
     * Returns a list of all playables playing at the given beat
     *
     * @param beat the desired beat at which to get all playables
     * @return the list of all playables at the given beat
     */
    @Override
    public List<Playable> whatIsPlaying(int beat) {
        return null;
    }

    /**
     * Finds the lowest Pitch of all the playables
     *
     * @return the lowest Pitch of all the playables
     */
    @Override
    public int lowestPitch() {
        return 0;
    }

    /**
     * Finds the highest Pitch of all the playables
     *
     * @return the highest Pitch of all the playables
     */
    @Override
    public int highestPitch() {
        return 0;
    }

    /**
     * Returns the last beat of the last playable's last duration
     *
     * @return the beat of the last playable's last duration
     */
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
        return 0;
    }
}

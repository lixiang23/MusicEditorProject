package cs3500.music.model;

import cs3500.music.MusicEditor;
import cs3500.music.util.CompositionBuilder;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Music editor implementing the {@link MusicEditorModel} interface.
 *
 * INVARIANT: Height has to be greater than 0 INVARIANT: Length has to be greater than 0
 */
public final class MusicEditorImpl implements MusicEditorModel {

    /**
     * The list of notes in the music editor
     */
    private ArrayList<ArrayList<Note>> notes;

    /**
     * The tempo of the piece in the music editor
     */
    private int tempo;

    /**
     * Constructs a music editor with the given note, octave, and length of the note.
     *
     * @param tempo, the tempo of the composition
     */
    public MusicEditorImpl(int tempo) {
        this.notes = new ArrayList<ArrayList<Note>>();
        this.tempo = tempo;
    }

    public MusicEditorImpl() {
        this.notes = new ArrayList<ArrayList<Note>>();

    }


    @Override
    public ArrayList<ArrayList<Note>> getNotes() {
        return this.notes;
    }

    @Override
    public int getTempo() {
        return this.tempo;
    }

    @Override
    public int totalDuration() {
        int num = notes.size();
        if (notes.size() == 0) {
            return notes.size();
        } else {
            for (int i = notes.size() - 1; i < notes.size(); i++) {
                for (int j = 0; j < notes.get(i).size(); j++) {
                    num = notes.get(i).get(j).getDuration() + num - 1;
                }
            }
        }
        return num;
    }

    @Override
    public int getBeats() {
        return notes.size();
    }

    @Override
    public void addNote(int start, int end, int instrument, int pitch, int volume) {
        ArrayList<ArrayList<Note>> tempNotes = notes;
        if (start < this.notes.size()) {
            tempNotes.get(start).add(new Note(pitch, end - start, instrument, volume));
        } else {
            tempNotes.addAll(addEmptyList(((start - notes.size()) + 1)));
            tempNotes.add(new ArrayList<Note>(Arrays.asList(
                new Note(pitch, end - start, instrument, volume))));
        }
        this.notes = tempNotes;

    }

    @Override
    public void removeNote(int b, Note n) {
        ArrayList<ArrayList<Note>> tempNotes = notes;
        for (int i = 0; i < tempNotes.size(); i++) {
            if (i == b) {
                tempNotes.get(i).contains(n);
                tempNotes.get(i).remove(n);
            }
        }
        this.notes = tempNotes;
    }

    @Override
    public ArrayList<Note> getNotesOnBeat(int b) {
        ArrayList<Note> tempNotes = new ArrayList<Note>();
        for (int i = 0; i < notes.size(); i++) {
            if (i == b) {
                tempNotes.addAll(notes.get(i));
            }
        }
        return tempNotes;
    }


    public Note getNoteOnBeat(int b, int midiIndex) {
        ArrayList<Note> tempNotes = this.getNotesOnBeat(b);
        Note note = new Note(0, 0, 0, 0);
        for (int i = 0; i < tempNotes.size(); i++) {
            if (tempNotes.get(i).getIndex() == midiIndex) {
                note = tempNotes.get(i);
            }
        }
        return note;
    }

    public ArrayList<ArrayList<Note>> addEmptyList(int n) {
        ArrayList<ArrayList<Note>> no = new ArrayList<ArrayList<Note>>();
        if (n == 0) {
            return no;
        } else {
            for (int i = 0; i < n - 1; i++) {
                no.add(new ArrayList<Note>());
            }
            return no;
        }
    }


    /**
     * Configures and builds a {@link MusicEditorModel} in builder-pattern style.
     */
    public static final class Builder implements CompositionBuilder<MusicEditorModel> {
        private int tempo = DEFAULT_TEMPO;

        MusicEditorImpl musicEditor = new MusicEditorImpl(tempo);

        /**
         * Invariants are the same as for MusicEditorImpl:
         *
         * length > 0 height > 0 and height < 128
         */

        public Builder notes(ArrayList<ArrayList<Note>> notes) {
            for (int i = 0; i < notes.size(); i++) {
                musicEditor.notes.add(notes.get(i));
            }
            return this;
        }

        public Builder tempo(int tempo) {
            this.tempo = tempo;
            return this;
        }

        @Override
        public MusicEditorModel build() {
            return musicEditor;
        }

        @Override
        public CompositionBuilder<MusicEditorModel>
        addNote(int start, int end, int instrument, int pitch, int volume) {
            musicEditor.addNote(start, end, instrument, pitch, volume);
            return this;
        }

        @Override
        public CompositionBuilder<MusicEditorModel> setTempo(int tempo) {
            musicEditor.tempo = tempo;
            return this;
        }
    }
}






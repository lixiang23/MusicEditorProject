package cs3500.music.model;

import cs3500.music.MusicEditor;
import cs3500.music.util.CompositionBuilder;
import cs3500.music.model.*;
import cs3500.music.model.Playable.Pitch;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Music editor implementing the {@link MusicEditorModel} interface.
 *
 * INVARIANT: Height has to be greater than 0 INVARIANT: Length has to be greater than 0
 */
public final class CompositionImpl implements MusicEditorModel {

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
    public CompositionImpl(int tempo) {
        this.notes = new ArrayList<ArrayList<Note>>();
        this.tempo = tempo;
    }

    public CompositionImpl() {
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
    public boolean containsNote(int b, Note n) {
        return false;
    }

    @Override
    public void addNote(int start, int end, int instrument, int pitch, int volume) {
        ArrayList<ArrayList<Note>> tempNotes = notes;
        if (start < this.notes.size()) {
            tempNotes.get(start).add(new Note(pitch, end - start, instrument, volume, start));
        } else {
            tempNotes.addAll(addEmptyList(((start - notes.size()) + 1)));
            tempNotes.add(new ArrayList<Note>(Arrays.asList(
                new Note(pitch, end - start, instrument, volume, start))));
        }
        this.notes = tempNotes;

    }

    @Override
    public void removeNote(int b, NoteInterface n) {
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
        Note note = new Note(0, 0, 0, 0, 0);
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

    public static int getNumPitch(Pitch pitch, int octave) {
        int numPitch = octave * 12;
        switch (pitch) {
            case C:
                numPitch += 0;
                break;
            case CSHARP:
                numPitch += 1;
                break;
            case D:
                numPitch += 2;
                break;
            case DSHARP:
                numPitch += 3;
                break;
            case E:
                numPitch += 4;
                break;
            case F:
                numPitch += 5;
                break;
            case FSHARP:
                numPitch += 6;
                break;
            case G:
                numPitch += 7;
                break;
            case GSHARP:
                numPitch += 8;
                break;
            case A:
                numPitch += 9;
                break;
            case ASHARP:
                numPitch += 10;
                break;
            case B:
                numPitch += 11;
                break;
            default:
                break;
        }
        return numPitch;
    }

    /**
     * Returns the Stirng version of the given note name
     *
     * @param pitch the desired pitch to get as String
     * @return the pitch as a String
     */
    public static String noteNames(int pitch) {
        String name = "";
        switch (pitch) {
            case 0:
                name = "C";
                break;
            case 1:
                name = "C#";
                break;
            case 2:
                name = "D";
                break;
            case 3:
                name = "D#";
                break;
            case 4:
                name = "E";
                break;
            case 5:
                name = "F";
                break;
            case 6:
                name = "F#";
                break;
            case 7:
                name = "G";
                break;
            case 8:
                name = "G#";
                break;
            case 9:
                name = "A";
                break;
            case 10:
                name = "A#";
                break;
            case 11:
                name = "B";
                break;
            default:
                break;
        }
        return name;

    }


    /**
     * Configures and builds a {@link MusicEditorModel} in builder-pattern style.
     */
    public static final class Builder implements CompositionBuilder<MusicEditorModel> {
        private int tempo = DEFAULT_TEMPO;

        CompositionImpl musicEditor = new CompositionImpl(tempo);

        /**
         * Invariants are the same as for CompositionImpl:
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






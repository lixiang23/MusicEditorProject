package cs3500.music.tests;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.*;

import cs3500.music.model.MusicEditorModel;
import cs3500.music.model.CompositionImpl;
import cs3500.music.model.Note;
import cs3500.music.MusicEditor;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.MidiViewImpl;
import cs3500.music.view.ConsoleView;
import cs3500.music.util.MusicReader;
import cs3500.music.util.CompositionBuilder;

import static org.junit.Assert.*;

public class MusicEditorImplTest {
    CompositionBuilder<MusicEditorModel> musicEditor1 = new CompositionImpl.Builder();
    MusicEditorModel musicEditor = new CompositionImpl();
    Note c4 = new Note(48, 2, 10, 40,5);
    Note csharp4 = new Note(49, 2, 10, 40,8);
    Note d4 = new Note(50, 1, 10, 40,12);


    @Test
    public void testTotalDuration1() {
        musicEditor.addNote(0, 1, 10, 48, 40); // c4
        musicEditor.addNote(1, 3, 10, 49, 40); // csharp4
        musicEditor.addNote(2, 3, 10, 50, 40); // d4
        musicEditor.addNote(2, 3, 10, 52, 40); // e4
        assertEquals(3, musicEditor.totalDuration());
        musicEditor.removeNote(2, d4);
        assertEquals(3, musicEditor.totalDuration());
    }

    @Test
    public void testTotalDuration2() {
        assertEquals(0, musicEditor.totalDuration());
    }


    @Test
    public void testAddNote2() {
        musicEditor.addNote(0, 2, 10, 48, 40);
        assertEquals(
            musicEditor.getNotes(), new ArrayList<ArrayList<Note>>(
                Arrays.asList(new ArrayList<Note>(Arrays.asList(new Note(48, 2, 10, 40,0))))));

    }


    @Test
    public void testAddNote1() {
        musicEditor.addNote(0, 2, 10, 48, 40);
        assertEquals(new ArrayList<ArrayList<Note>>(Arrays.asList(
            new ArrayList<Note>(Arrays.asList(c4)))), musicEditor.getNotes());
        musicEditor.addNote(3, 5, 10, 49, 40);
        assertEquals(new ArrayList<ArrayList<Note>>(Arrays.asList(
            new ArrayList<Note>(Arrays.asList(c4)), new ArrayList<Note>(), new ArrayList<Note>(),
            new ArrayList<Note>(Arrays.asList(csharp4)))), musicEditor.getNotes());
        musicEditor.addNote(2, 3, 10, 50, 40);
        musicEditor.removeNote(0, c4);
        assertEquals(new ArrayList<ArrayList<Note>>(Arrays.asList(
                new ArrayList<Note>(), new ArrayList<Note>(),
                new ArrayList<Note>(Arrays.asList(d4)), new ArrayList<Note>(
                    Arrays.asList(csharp4)))),
            musicEditor.getNotes());

    }

//    @Test
//    public void testConsole() throws InvalidMidiDataException, InterruptedException, IOException {
//        FileReader mary = new FileReader("/Users/nancyli/Desktop/OOD HW/hw04/mary-little-lamb");
//        FileReader mystery1 = new FileReader("/Users/nancyli/Desktop/OOD HW/hw04/mystery-1");
//        FileReader mystery2 = new FileReader("/Users/nancyli/Desktop/OOD HW/hw04/mystery-2");
//        MusicReader mr = new MusicReader();
//        MusicEditorModel me = MusicReader.parseFile(mary, musicEditor1);
//        ConsoleView console = new ConsoleView(musicEditor);
//        console.createConsole(me);
//    }

    @Test
    public void testMidi() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException, IOException {
        FileReader mary = new FileReader("/Users/nancyli/Desktop/OOD HW/hw04/mary-little-lamb");
        FileReader mystery1 = new FileReader("/Users/nancyli/Desktop/OOD HW/hw04/mystery-1");
        FileReader mystery2 = new FileReader("/Users/nancyli/Desktop/OOD HW/hw04/mystery-2");
        MusicReader mr = new MusicReader();
        MusicEditorModel me = MusicReader.parseFile(mary, musicEditor1);
        MidiViewImpl midiView = new MidiViewImpl(musicEditor);
        midiView.playNote(me);
    }

    @Test
    public void testGetNotesOnBeat() {
        musicEditor.addNote(0, 2, 10, 48, 40);
        musicEditor.addNote(3, 5, 10, 49, 40);
        musicEditor.addNote(2, 3, 10, 50, 40);
        musicEditor.addNote(2, 4, 10, 49, 40);
        assertEquals(new ArrayList<Note>(Arrays.asList(c4)), musicEditor.getNotesOnBeat(0));
        assertEquals(new ArrayList<Note>(Arrays.asList(csharp4)), musicEditor.getNotesOnBeat(3));
        assertEquals(new ArrayList<Note>(Arrays.asList(d4, csharp4)), musicEditor.getNotesOnBeat(2));
    }
}
